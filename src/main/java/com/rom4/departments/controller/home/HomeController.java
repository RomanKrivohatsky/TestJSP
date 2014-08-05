package com.rom4.departments.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rom4 on 31.07.14.
 */
@Controller
public class HomeController {

    @RequestMapping({"*/", "*/home.html", "*home.html"})
    public String showHomePage() {
        return "index";
    }
    @RequestMapping({"*contact.html"})
    public String showContacts() {
        return "contacts";
    }

}
