package beans;

import daos.CityDao;
import daos.CountryDao;
import daos.RecruiterAddressDao;
import daos.RecruiterDao;
import models.City;
import models.Country;
import models.RecruiterAddress;
import models.Recruiter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sara
 */
@Named(value = "addEditRecruitersBean")
@ViewScoped
public class AddEditRecruitersBean implements Serializable {


    private final RecruiterDao recruitersDao = new RecruiterDao();
    private final RecruiterAddressDao recruiterAdressDao = new RecruiterAddressDao();
    private final CountryDao countryDao = new CountryDao();
    private final CityDao cityDao = new CityDao();

    private List<City> cities;
    private List<Country> countries;

    private Recruiter recruiters;
    private RecruiterAddress addresses;

    @Inject
    private SessionBean sessionBean;

    public AddEditRecruitersBean() {

    }

    @PostConstruct
    public void init() {

        try {
            countries = countryDao.getAllCountry();
            cities = cityDao.getAllCity();


            if (sessionBean.getRecruiterId() != 0) {
                recruiters = recruitersDao.getRecruiter(sessionBean.getRecruiterId());
                if (recruiters == null) {
                    recruiters = new Recruiter();
                } else {
                    addresses = recruiterAdressDao.getRecruiterAddress(recruiters.getId());
                    if (addresses == null) {
                        addresses = new RecruiterAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void saveEvent() {
        try {
            if (recruiters.getId() > 0) {
                recruitersDao.updateRecruiter(recruiters);
                recruiterAdressDao.updateRecruiterAddress(addresses);


            } else {
                int id = recruitersDao.insertRecruiter(recruiters);
                recruiters.setId(id);
//                addresses.setRecruiterId(recruiters);
                recruiterAdressDao.insertRecruiterAddress(addresses);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditRecruitersBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Recruiter getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(Recruiter recruiters) {
        this.recruiters = recruiters;
    }

    public RecruiterDao getRecruitersDao() {
        return recruitersDao;
    }

    public RecruiterAddressDao getRecruiterAddressDao() {
        return recruiterAdressDao;
    }

    public CountryDao getCountryDao() {
        return countryDao;
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public RecruiterAddress getAddresses() {
        return addresses;
    }

    public void setAddresses(RecruiterAddress addresses) {
        this.addresses = addresses;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
