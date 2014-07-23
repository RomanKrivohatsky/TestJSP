package com.rom4.departments.springtest.springdol;

import com.rom4.departments.springtest.Address;
import com.rom4.departments.springtest.City;
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

        Address address = (Address) ac.getBean("address");
        System.out.println(address.getCity());
        System.out.println("bigCities");
        for(City city:address.getBigCities()) {
            System.out.println(city);
        }

        performer = (Performer) ac.getBean("harry");
        performer.perform();


    }
}
