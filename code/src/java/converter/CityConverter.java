package java.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.daos.CityDao;
import java.models.City;

@Named(value = "cityConverter")
@ViewScoped
@FacesConverter("cityConverter")
public class CityConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String newValue) {
        CityDao cityDao = new CityDao();
        try {
            return cityDao.getCity(Integer.valueOf(newValue));
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
        if (object instanceof City) {
            City city = (City) object;
            return Integer.toString(city.getId());
        } else {
            throw new ConverterException(new FacesMessage(object + " is not a valid City"));
        }
    }


}