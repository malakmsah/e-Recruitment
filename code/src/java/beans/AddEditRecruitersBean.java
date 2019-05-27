package beans;

import daos.CityDao;
import daos.CountryDao;
import daos.RecruiterAddressDao;
import daos.RecruitersDao;
import models.City;
import models.Country;
import models.RecruiterAddresses;
import models.Recruiters;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 * @author Sara
 */
@Named(value = "addEditRecruitersBean")
@ViewScoped
public class AddEditRecruitersBean implements Serializable {


    private final RecruitersDao recruitersDao = new RecruitersDao();
    private final RecruiterAddressDao recruiterAdressDao = new RecruiterAddressDao();
    private final CountryDao countryDao = new CountryDao();
    private final CityDao cityDao = new CityDao();

    private List<City> cities;
    private List<Country> countries;

    private Recruiters recruiters;
    private RecruiterAddresses addresses;

    @Inject
    private SessionBean sessionBean;

    public AddEditRecruitersBean() {

    }

    @PostConstruct
    public void init() {

        try {
            countries = countryDao.getAllCountry();
            cities = cityDao.getAllCity();


            if (sessionBean.getRecruitersID() != 0) {
                recruiters = recruitersDao.getRecruiters(sessionBean.getRecruitersID());
                if (recruiters == null) {
                    recruiters = new Recruiters();
                } else {
                    addresses = recruiterAdressDao.getRecruitersAdresses(recruiters.getId());
                    if (addresses == null) {
                        addresses = new RecruiterAddresses();
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
                recruitersDao.updateRecruiters(recruiters);
                recruiterAdressDao.updateRecruiterAddresses(addresses);


            } else {
                int id = recruitersDao.insertRecruiters(recruiters);
                recruiters.setId(id);
                addresses.setRecruiters(recruiters);
                recruiterAdressDao.insertRecruiterAddresses(addresses);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditRecruitersBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Recruiters getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(Recruiters recruiters) {
        this.recruiters = recruiters;
    }

    public RecruitersDao getRecruitersDao() {
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

    public RecruiterAddresses getAddresses() {
        return addresses;
    }

    public void setAddresses(RecruiterAddresses addresses) {
        this.addresses = addresses;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
}
