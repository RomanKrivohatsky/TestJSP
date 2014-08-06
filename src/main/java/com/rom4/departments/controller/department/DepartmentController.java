package com.rom4.departments.controller.department;

import com.rom4.departments.controller.employee.editors.DateEditor;
import com.rom4.departments.controller.employee.editors.EmployeeEditor;
import com.rom4.departments.domain.Department;
import com.rom4.departments.exception.ValidateException;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.validation.DepartmentValidation;
import com.rom4.departments.validation.EmployeeValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rom4 on 31.07.14.
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new DepartmentValidation());
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
    public String editDepartment (@RequestParam("departmentID") Integer departmentID, Model model) {
        model.addAttribute("department", service.read(departmentID));
        model.addAttribute("pageType", "edit");
        return "department/editDepartment";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save.html" ,  params = "pageType=new")
    public String saveDepartment (@Valid Department department, Model model)  {

        try {
            service.create(department);
        } catch (ValidateException e) {

            Map<String, String> errors = parseErrors(e.getErrors());
            model.addAttribute("department", department);
            model.addAttribute("pageType", "new");
            model.addAttribute("errors", errors);
            return "department/editDepartment";
        }

        return "redirect:edit.html?saveStatus=1&departmentID="+department.getDepartmentID();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save.html" , params = "pageType=edit")
    public String updateDepartment (@ModelAttribute("department") Department department, Model model) {

        try {
            service.update(department);
        } catch (ValidateException e) {

            Map<String, String> errors = parseErrors(e.getErrors());
            model.addAttribute("department", department);
            model.addAttribute("pageType", "edit");
            model.addAttribute("errors", errors);
            return "department/editDepartment";
        }

        return "redirect:edit.html?saveStatus=2&departmentID="+department.getDepartmentID();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete.html")
    public String deleteDepartment (Department department) throws ValidateException {
        String name = (service.read(department.getDepartmentID())).getName();

            service.delete(department);

        return "redirect:list.html?departmentName=" + name;
    }

    private Map<String, String> parseErrors( List<ObjectError> errorList) {
        Map<String, String> errors = new HashMap<>();
        for (ObjectError objectError : errorList) {
            if (objectError instanceof FieldError) {
                errors.put( ((FieldError) objectError).getField(), objectError.getDefaultMessage());
            }
        }
        return errors;
    }
}
