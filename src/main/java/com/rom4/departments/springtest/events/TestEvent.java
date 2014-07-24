package com.rom4.departments.springtest.events;

import org.aspectj.weaver.ast.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rom4 on 24.07.14.
 * Creation time 12:11
 * Project name Departments
 */
public class TestEvent {

    void execute () {
        ApplicationContext ac = new ClassPathXmlApplicationContext("events.xml");
        Course course = new Course();
        ac.publishEvent(new CourseFullEvent(this, course));
    }

    public static void main (String[] args) {
        //TestEvent e = new TestEvent();
        //e.execute();
    }
}
