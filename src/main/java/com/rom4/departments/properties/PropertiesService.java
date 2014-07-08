package com.rom4.departments.properties;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by rom4 on 02.07.14.
 * Service to get url string, user, password
 */
public class PropertiesService {
    private final static String BUNDLE_PATH = "departments";
    private static PropertiesService service = new PropertiesService();
    private static ResourceBundle rb = null;

    private PropertiesService() {
    }

    public static PropertiesService getService() {

        if (rb == null) {
            rb = ResourceBundle.getBundle(BUNDLE_PATH);
        }
        return service;
    }

    public String getParam (String param) {
        return rb.getString(param);
    }

/*    public static void main (String args[]) {
        PropertiesService ps = null;
        ps = ps.getService();
        System.out.println(ps.getParam("user"));

        //ResourceBundle rb = ResourceBundle.getBundle("main.1", Locale.ENGLISH);

    }*/
}
