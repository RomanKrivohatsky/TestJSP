package com.rom4.departments.springtest.springdol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 14:14
 * Project name Departments
 */
public class IdolsMain {

    public static void main (String[] args) throws PerformanceException {

        ApplicationContext ac = new ClassPathXmlApplicationContext("SpringIdol.xml");
        Performer performer = (Performer)ac.getBean("duke");
        performer.perform();
        Performer performer2 = (Performer)ac.getBean("kenny");
        performer2.perform();
        Performer performer3 = (Performer)ac.getBean("hank");
        performer3.perform();


    }
}
