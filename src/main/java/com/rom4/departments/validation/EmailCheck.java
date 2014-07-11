package com.rom4.departments.validation;

import com.rom4.departments.dao.DAOFactory;
import com.rom4.departments.dao.EmployeDAO;
import com.rom4.departments.exception.AppException;
import com.rom4.departments.model.Employe;
import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;

/**
 * Created by rom4 on 10.07.14.
 * Creation time 12:13
 * Project name Departments
 */
public class EmailCheck extends AbstractAnnotationCheck<Email> {

    @Override
    public boolean isSatisfied(Object validateObject, Object validateValue, OValContext oValContext, Validator validator) throws OValException {

        EmployeDAO dao = DAOFactory.getEmployeDAO();
        try {
            Employe employe = dao.getEmployeByEmail((String) validateValue);
            if (employe != null) {
                if (!employe.getEmployeID().equals(((Employe)validateObject).getEmployeID())) {
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
