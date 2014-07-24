package com.rom4.departments.springtest.events;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by rom4 on 24.07.14.
 * Creation time 12:35
 * Project name Departments
 */
public class RefreshListener implements ApplicationListener{
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof CourseFullEvent) {
            System.out.println("onApplicationEvent " + ((CourseFullEvent)event).getCourse());
        }
            System.out.println("onApplicationEvent " + event.getSource().getClass().getName());
    }
}
