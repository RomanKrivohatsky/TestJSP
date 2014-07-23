package com.rom4.departments.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 13:22
 * Project name Departments
 */
public class Auditorium {
    private int humans;
    private static  int cc;

    public Auditorium () {
    }

    public Auditorium (int humans) {
        this.humans = humans;
        cc++;
        System.out.println("cc="+cc );
    }

    public void turnOnLights() {
        System.out.println("turn on");
    }

    public void turnOffLights() {
        System.out.println("turn off");
    }

    public void fillHumans() {
        System.out.println("Fill auiditorium " + humans + " humans "  + cc );
    }


    public static void main (String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("Auditorium.xml");
        Auditorium a = (Auditorium) ac.getBean("auditorium");
        //ApplicationContext ac2 = new ClassPathXmlApplicationContext("Auditorium.xml");
        Auditorium a2 = (Auditorium) ac.getBean("auditorium");
        a.fillHumans();
        a2.fillHumans();

    }
}
