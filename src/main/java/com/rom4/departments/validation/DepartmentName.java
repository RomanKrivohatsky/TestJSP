package com.rom4.departments.validation;

import com.rom4.departments.dao.DAOFactory;
import com.rom4.departments.dao.DepartmentDAO;
import com.rom4.departments.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Department;
import com.rom4.departments.model.Employe;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

/**
 * Created by rom4 on 14.07.14.
 * Creation time 14:10
 * Project name Departments
 */
public class DepartmentName extends AbstractAnnotationCheck<DepartmentNameUnique> {
    @Override
    public boolean isSatisfied(Object validateObject, Object validateValue, OValContext context, Validator validator) throws OValException {


        DepartmentDAO dao = DAOFactory.getDepartmentDAO();
        try {
            Department department= dao.getDepartmentByName((String) validateValue);
            if (department != null) {
                if (!department.getDepartmentID().equals(((Department)validateObject).getDepartmentID())) {
                    return false;
                }
            }
            ;
        } catch (AppException e) {
            return false;
        }
        return true;
    }
}
