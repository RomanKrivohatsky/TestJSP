package com.rom4.departments.springtest.springdol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 14:20
 * Project name Departments
 */
public class PoeticJuggler extends  Juggler{
    private Poem poem;

    public PoeticJuggler(int beanBugs, Poem poem) {
        super(beanBugs);
        this.poem = poem;
    }


    public PoeticJuggler( Poem poem) {
        super();
        this.poem = poem;
    }

    @Override
    public void perform() throws PerformanceException {
        super.perform();
        System.out.println("While reciting...");
        poem.recite();
    }
}
