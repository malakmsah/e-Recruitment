package converter;


import daos.CountryDao;
import models.Country;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


@Named(value = "countryConverter")
@ViewScoped
@FacesConverter("countryConverter")
public class CountryConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
        CountryDao countryDao = new CountryDao();
        try {
            return countryDao.getCountry(Integer.valueOf(newValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if (object == null) {
            return "";
        }
        if (object instanceof Country) {
            Country country = (Country) object;

            return country.getId().toString();
        } else {
            throw new ConverterException(new FacesMessage(object + " is not a valid Country"));
        }
    }


}