package com.rom4.departments.controller.employee;

import com.rom4.departments.controller.employee.editors.DateEditor;
import com.rom4.departments.controller.employee.editors.DepartmentEditor;
import com.rom4.departments.domain.Department;
import com.rom4.departments.domain.Employee;
import com.rom4.departments.exception.ValidateException;
import com.rom4.departments.service.dao.DepartmentService;
import com.rom4.departments.service.dao.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    @Autowired
    @Qualifier("EmployeeValidator")
    private Validator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
        binder.registerCustomEditor(Department.class, new DepartmentEditor(departmentService));
        binder.setValidator(validator);
    }

    @RequestMapping("/list.html")
    public String employers (Model model) {
        model.addAttribute("employeers", employeeService.getList());
        model.addAttribute("departmentID", 0);
        return "employee/employeers";
    }
    @RequestMapping(value = "/list.html", params = "employeeLastName")
    public String employersAfterDelete (@RequestParam String employeeLastName,
                                        Model model) {
        model.addAttribute("lastName", employeeLastName);
        model.addAttribute("employeers", employeeService.getList());
        model.addAttribute("departmentID", 0);
        return "employee/employeers";
    }

    @RequestMapping(value="/list.html", params = "departmentID")
    public String employersByDepartment (@RequestParam Integer departmentID,
                                         Model model) {
        model.addAttribute("departmentID", departmentID);
        model.addAttribute("employeers", employeeService.getList(departmentID));
        return "employee/employeers";
    }

    @RequestMapping(value="/list.html", params = {"departmentID" ,"employeeLastName"})
    public String employersByDepartment (@RequestParam String employeeLastName,
                                         @RequestParam Integer departmentID,
                                         Model model) {
        model.addAttribute("lastName", employeeLastName);
        model.addAttribute("departmentID", departmentID);
        model.addAttribute("employeers", employeeService.getList(departmentID));
        return "employee/employeers";
    }


    @RequestMapping(method = RequestMethod.GET,value = "/edit.html")
    public String addEmploye (Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getList());
        model.addAttribute("pageType", "new");
        return "employee/editEmployee";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/edit.html", params = {"saveStatus", "employeeID"})
    public String addEmploye (@RequestParam("saveStatus") String saveStatus,
                              @RequestParam("employeeID") Integer employeeID,
                              Model model) {

        if ((saveStatus.equals("1")||saveStatus.equals("2"))&&employeeID>0 ) {
            saveStatus = saveStatus.equals("1") ? "created!" : "updated!";
            model.addAttribute("saveStatus", "Employee " + employeeService.read(employeeID).getLastName() + " has been " + saveStatus);
        }
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentService.getList());
        model.addAttribute("pageType", "new");
        return "employee/editEmployee";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/edit.html", params = "employeeID")
    public String editEmploye (@RequestParam("employeeID") Integer employeeID,
                               Model model) {
        model.addAttribute("employee", employeeService.read(employeeID));
        model.addAttribute("departments", departmentService.getList());
        model.addAttribute("pageType", "edit");
        return "employee/editEmployee";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save.html", params = "pageType=new")
    public String createEmployee(@Valid Employee employee,
                                 BindingResult result,
                                 Model model) {

        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("pageType", "new");
            return "employee/editEmployee";
        }
        employeeService.create(employee);
        return "redirect:edit.html?saveStatus=1&employeeID=" + employee.getEmployeeID();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save.html" , params = "pageType=edit")
    public String updateEmployee (@Valid Employee employee,
                                  BindingResult result,
                                  Model model) {
        if (result.hasErrors()) {
            model.addAttribute("employee", employee);
            model.addAttribute("departments", departmentService.getList());
            model.addAttribute("pageType", "edit");
            return "employee/editEmployee";
        }
        employeeService.update(employee);
        return "redirect:edit.html?saveStatus=2&employeeID="+employee.getEmployeeID();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/delete.html")
    public String deleteEmployee (@RequestParam Integer employeeID,
                                  @RequestParam Integer departmentID) {
        String redirectURL = "redirect:list.html";
        Employee employee = employeeService.read(employeeID);
        String name = employee.getLastName();
        employeeService.delete(employee);
        redirectURL += departmentID == 0 ? "?employeeLastName=" + name : "?employeeLastName=" + name + "&departmentID=" + departmentID;
        return redirectURL;
    }
}
