package com.rom4.departments.springtest.springdol;

import org.springframework.beans.factory.support.MethodReplacer;
import java.lang.reflect.Method;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 18:17
 * Project name Departments
 */
public class TigerReplacer implements MethodReplacer{
    @Override
    public Object reimplement(Object target, Method method, Object[] args) throws Throwable {
            return "A tiger";
    }
}
