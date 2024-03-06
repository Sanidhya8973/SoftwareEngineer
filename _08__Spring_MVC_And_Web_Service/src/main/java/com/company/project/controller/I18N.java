package com.company.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Locale;

@Controller(value = "controller_i18n")
public class I18N {

    public void i18n(HttpServletRequest request) {
        // returns a list of all 2-letter language codes defined in ISO 639
        String[] countryCodes = Locale.getISOCountries();
        for (String countryCode : countryCodes) {
            Locale locale = new Locale("", countryCode);
            System.out.println("I18N {");
            System.out.println(" countryCode : " + locale.getCountry());
            System.out.println(" countryCode : " + locale.getDisplayCountry());
            System.out.println("}");
        }
        // returns a list of all 2-letter country codes defined in ISO 3166
        String[] languageCodes = Locale.getISOLanguages();
        for (String languageCode : languageCodes) {
            Locale locale = new Locale(languageCode);
            System.out.println("I18N {");
            System.out.println(" languageCode: " + locale.getLanguage());
            System.out.println(" languageName: " + locale.getDisplayLanguage());
            System.out.println("}");
        }
    }

    @RequestMapping(path = "/i18n", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView i18nWeb(HttpServletRequest request) {

        ModelAndView mnv = new ModelAndView("i18n.html");

        Locale locale = request.getLocale();

        String countryCode = locale.getCountry();
        String countryName = locale.getDisplayCountry();
        String languageCode = locale.getLanguage();
        String languageName = locale.getDisplayLanguage();

        System.out.println("> " + countryCode + " : " + countryName);
        System.out.println("> " + languageCode + " : " + languageName);

        return mnv;

    }

}
