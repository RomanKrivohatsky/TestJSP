package com.rom4.departments.controller.department;

import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by rom4 on 31.07.14.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @RequestMapping("/list.html")
    public String departments (Model model) {
        model.addAttribute(service.getList());
        return "department/departments";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/edit.html")
    public String addDepartment (Model model) {
        model.addAttribute("pageType", "new");
        return "department/editDepartment";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/edit.html", params = "departmentID")
    public String editDepartment (@RequestParam("departmentID") Integer departmentID, Model model) {
        model.addAttribute("department", service.read(departmentID));
        model.addAttribute("pageType", "edit");
        return "department/editDepartment";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save.html" ,  params = "pageType=new")
    public String saveDepartment (Department department, BindingResult bindingResult)  {
        service.create(department);
        return "redirect:edit.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save.html" , params = "pageType=edit")
    public String updateDepartment (@ModelAttribute("department") Department department, BindingResult bindingResult) {
        service.update(department);
        return "redirect:edit.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete.html")
    public String deleteDepartment (Department department) {
        service.delete(department);
        return "redirect:list.html";
    }
}
