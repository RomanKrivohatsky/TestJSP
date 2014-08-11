package com.rom4.departments.controller.department;

import com.rom4.departments.domain.Department;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.validation.DepartmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by rom4 on 31.07.14.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @Autowired
    @Qualifier("departmentValidator")
    private Validator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }


    @RequestMapping("/list.html")
    public String departments (Model model) {
         model.addAttribute(service.getList());
        return "department/departments";
    }

    @RequestMapping(value = "/list.html", params = "departmentName")
    public String departmentsAfterDelete (@RequestParam("departmentName") String departmentName, Model model) {
        model.addAttribute("deleteStatus", "Department " + departmentName + " has been deleted!" );
        model.addAttribute(service.getList());
        return "department/departments";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/edit.html")
    public String addDepartment (Model model) {
        model.addAttribute("department", new Department());
        model.addAttribute("pageType", "new");
        return "department/editDepartment";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/edit.html", params = {"saveStatus", "departmentID"})
    public String editDepartment (@RequestParam("saveStatus") String saveStatus,
                                  @RequestParam("departmentID") Integer departmentID,
                                  Model model) {
        if ((saveStatus.equals("1")||saveStatus.equals("2"))&&departmentID>0 ) {
            saveStatus = saveStatus.equals("1") ? "created!" : "updated!";
            model.addAttribute("saveStatus", "Department " + service.read(departmentID).getName() + " has been " + saveStatus);
        }
        model.addAttribute("department", new Department());
        model.addAttribute("pageType", "edit");
        return "department/editDepartment";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/edit.html", params = "departmentID")
    public String editDepartment (@RequestParam("departmentID") Integer departmentID,
                                  Model model) {
        model.addAttribute("department", service.read(departmentID));
        model.addAttribute("pageType", "edit");
        return "department/editDepartment";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save.html" ,  params = "pageType=new")
    public String saveDepartment (@Valid Department department,
                                  BindingResult result,
                                  Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("department", department);
            model.addAttribute("pageType", "new");
            return "department/editDepartment";
        }

        service.create(department);

        return "redirect:edit.html?saveStatus=1&departmentID="+department.getDepartmentID();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save.html" , params = "pageType=edit")
    public String updateDepartment (@Valid Department department,
                                    BindingResult result,
                                    Model model
                                    ) {
        if (result.hasErrors()) {
            model.addAttribute("department", department);
            model.addAttribute("pageType", "edit");
            return "department/editDepartment";
        }

        service.update(department);
        return "redirect:edit.html?saveStatus=2&departmentID="+department.getDepartmentID();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete.html")
    public String deleteDepartment (@Valid Department department) {
         String name = (service.read(department.getDepartmentID())).getName();

         service.delete(department);

        return "redirect:list.html?departmentName=" + name;
    }
}
