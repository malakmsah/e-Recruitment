package beans;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import daos.CityDao;
import daos.CountryDao;
import daos.RecruiterAddressDao;
import daos.RecruiterDao;
import java.io.Serializable;
import models.City;
import models.Country;
import models.Recruiter;
import models.RecruiterAddress;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Sara
 */
@Named(value = "addEditRecruiterBean")
@ViewScoped
public class AddEditRecruiterBean implements Serializable {

    private final RecruiterDao recruiterDao = new RecruiterDao();
    private final RecruiterAddressDao recruiterAddressDao = new RecruiterAddressDao();
    private final CountryDao countryDao = new CountryDao();
    private final CityDao cityDao = new CityDao();

    private List<City> cities;
    private List<Country> countries;

    private Recruiter recruiter;
    private RecruiterAddress address;

    @Inject
    private beans.SessionBean sessionBean;

    public AddEditRecruiterBean() {

    }

    @PostConstruct
    public void init() {

        try {
            countries = countryDao.getAllCountry();
            cities = cityDao.getAllCity();

            if (sessionBean.getRecruiterId() != 0) {
                recruiter = recruiterDao.getRecruiter(sessionBean.getRecruiterId());
                if (recruiter == null) {
                    recruiter = new Recruiter();
                } else {
                    address = recruiterAddressDao.getRecruiterAddress(recruiter.getId());
                    if (address == null) {
                        address = new RecruiterAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void saveEvent() {
        try {
            if (recruiter.getId() > 0) {
                recruiterDao.updateRecruiter(recruiter);
                recruiterAddressDao.updateRecruiterAddress(address);

            } else {
                int id = recruiterDao.insertRecruiter(recruiter);
                recruiter.setId(id);
                address.setRecruiterId(id);
                recruiterAddressDao.insertRecruiterAddress(address);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddEditRecruiterBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Recruiter getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(Recruiter recruiter) {
        this.recruiter = recruiter;
    }

    public RecruiterDao getRecruiterDao() {
        return recruiterDao;
    }

    public RecruiterAddressDao getRecruiterAddressDao() {
        return recruiterAddressDao;
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
        return address;
    }

    public void setAddresses(RecruiterAddress address) {
        this.address = address;
    }

    public beans.SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(beans.SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

}
