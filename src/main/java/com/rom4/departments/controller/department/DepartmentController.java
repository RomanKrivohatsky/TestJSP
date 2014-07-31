package com.rom4.departments.controller.department;

import com.rom4.departments.controller.common.PageUtil;
import com.rom4.departments.domain.Department;
import com.rom4.departments.exception.ValidateException;
import com.rom4.departments.service.dao.DepartmentService;
import com.sun.java.swing.plaf.motif.resources.motif_de;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by rom4 on 31.07.14.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @RequestMapping("/list")
    public String departments (Model model) {
        model.addAttribute(service.getList());
        return "departments";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editDepartment" , params = "edit" )
    public String editDepartment (@RequestParam("department") Department department, Model model) {
        model.addAttribute("department", service.read(department.getDepartmentID()));
        model.addAttribute("pageType", "edit");
        return "editDepartment";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/editDepartment" )
    public String addDepartment (Model model) {
        model.addAttribute("pageType", "new");
        return "editDepartment";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteDepartment")
    public String deleteDepartment () {
        return "/list";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveDepartment" ,  params = "new")
    public String saveDepartment (Department department, BindingResult bindingResult)  {
        service.create(department);
        return "redirect:/addDepartment";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveDepartment" , params = "edit")
    public String updateDepartment (Department department, BindingResult bindingResult) {
        service.update(department);
        return "redirect:/addDepartment";
    }
}
