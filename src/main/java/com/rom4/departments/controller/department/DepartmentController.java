package com.rom4.departments.controller.department;

import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/list.html{departmentName}")
    public String departments (@PathVariable("departmentName") String departmentName, Model model) {
        model.addAttribute("deleteStatus", "Department " + departmentName + " has been deleted!" );
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
        String name = (service.read(department.getDepartmentID())).getName();
        service.delete(department);
        return "redirect:list.html?departmentName=" + name;
    }
}
