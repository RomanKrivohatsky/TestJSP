package com.rom4.departments.springtest.events;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rom4 on 24.07.14.
 * Creation time 12:02
 * Project name Departments
 */
public class CourseFullEvent extends ApplicationEvent {
    private Course course;
    public CourseFullEvent(Object source, Course course) {
        super(source);
        this.course = course;
    }
    public Course getCourse() {
        return course;
    }

    void execute () {
        ApplicationContext ac = new ClassPathXmlApplicationContext("events.xml");
        ac.publishEvent(new CourseFullEvent(this, new Course()));
    }

    public  static void main (String[] args) {
        CourseFullEvent e = new CourseFullEvent(new Object(),new Course());
        e.execute();
    }
}
