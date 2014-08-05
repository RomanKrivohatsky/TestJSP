package com.rom4.departments.controller.employee;

import com.rom4.departments.domain.Department;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.exception.ValidateException;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rom4 on 01.08.14.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private EmployeeService employeeService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
        binder.registerCustomEditor(Department.class, new EmployeeEditor(departmentService));
    }

    @RequestMapping("/list.html")
    public String employers (Model model) {
        model.addAttribute("employeers", employeeService.getList());
        return "employee/employeers";
    }

    @RequestMapping(value="/list.html", params = "departmentID")
    public String employersByDepartment (@RequestParam Integer departmentID, Model model) {
        model.addAttribute("employeers", employeeService.getList(departmentID));
        return "employee/employeers";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/edit.html")
    public String addDEmploye (Model model) {
        model.addAttribute("departments", departmentService.getList());
        model.addAttribute("pageType", "new");
        return "employee/editEmployee";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/edit.html", params = "employeID")
    public String editDEmploye (@RequestParam("employeID") Integer employeeID, Model model) {
        model.addAttribute("employee", employeeService.read(employeeID));
        model.addAttribute("departments", departmentService.getList());
        model.addAttribute("pageType", "edit");
        return "employee/editEmployee";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save.html",  params = "pageType=new")
    public String saveEmployee (@ModelAttribute("employee") Employee employee, Model model)  {
        try {
            employeeService.create(employee);
        } catch (ValidateException e) {

           /* Map<String, String> errors = parseErrors(e.getErrors());
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("pageType", "new");
            model.addAttribute("errors", errors);
            return "employee/editEmployee";*/
        }
        return "redirect:edit.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save.html" , params = "pageType=edit")
    public String updateEmployee (@ModelAttribute("employee") Employee employee,  Model model) {
        try {
            employeeService.update(employee);
        } catch (ValidateException e) {

            Map<String, String> errors = parseErrors(e.getErrors());
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("pageType", "edit");
            model.addAttribute("errors", errors);
            return "employee/editEmployee";
        }
        return "redirect:edit.html";
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
