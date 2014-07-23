package com.rom4.departments.springtest.springdol;

import org.hibernate.context.internal.JTASessionContext;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 14:08
 * Project name Departments
 */
public class Juggler implements  Performer{
    private int beanBugs = 3;
    public Juggler () {

    }
    public Juggler (int beanBugs) {
        this.beanBugs = beanBugs;
    }

    @Override
    public void perform() throws PerformanceException {
        System.out.println("Juggling "  + beanBugs + " beanBugs");
    }
}
