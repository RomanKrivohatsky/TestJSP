package com.rom4.departments.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.Objects;

/**
 * Created by rom4 on 31.07.14.
 */
@Controller
public class HomeController {

    @RequestMapping({"/", "*/home"})
    public String showHomePage(Map<String, Object> model) {
        return "index";
    }
}
