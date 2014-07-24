package com.rom4.departments.springtest.springdol;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 15:39
 * Project name Departments
 */
@Component
    @Qualifier ("button")
public class Piano implements  Instrument{
    @Override
    public void play() {
        System.out.println("plim-plim-plim");
    }
}
