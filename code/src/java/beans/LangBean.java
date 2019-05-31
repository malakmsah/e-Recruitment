/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author User
 */
@Named(value = "langBean")
@SessionScoped
public class LangBean implements Serializable {

    private String locale;
    private String lang;
    private String dir;
    private String styleFloat;
    private String styleFloatOpposite;
    private String linkLabel;
    private boolean isEnglish;

    public LangBean() {
        locale = "en";
        lang = "en";
        dir = "ltr";
        styleFloat = "left";
        styleFloatOpposite = "right";
        linkLabel = "Arabic";
        isEnglish = true;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getStyleFloat() {
        return styleFloat;
    }

    public void setStyleFloat(String styleFloat) {
        this.styleFloat = styleFloat;
    }
    
    public String getStyleFloatOpposite() {
        return styleFloatOpposite;
    }

    public void setStyleFloatOpposite(String styleFloatOpposite) {
        this.styleFloatOpposite = styleFloatOpposite;
    }

    public boolean getIsEnglish() {
        return isEnglish;
    }

    public void setIsEnglish(boolean isEnglish) {
        this.isEnglish = isEnglish;
    }

    public String getLinkLabel() {
        return linkLabel;
    }

    public void setLinkLabel(String linkLabel) {
        this.linkLabel = linkLabel;
    }

    public void toggleLanguage() {
        this.isEnglish = !this.isEnglish;

        if (locale.equals("ar")) {
            locale = "en";
            lang = "en";
            dir = "ltr";
            styleFloat = "left";
            styleFloatOpposite = "right";
            linkLabel = "Arabic";
        } else {
            locale = "ar";
            lang = "ar";
            dir = "rtl";
            styleFloat = "right";
            styleFloatOpposite = "left";
            linkLabel = "انجليزي";
        }
    }

}
