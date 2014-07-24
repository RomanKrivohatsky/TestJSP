package com.rom4.departments.springtest.springdol;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 15:15
 * Project name Departments
 */

@Component
public class Instrumentalist implements Performer {
    private String song;
    private Instrument instrument;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    @Autowired
    @Qualifier("saxaphone")
    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }


    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public Instrumentalist() {
    }


    @Override
    public void perform() throws PerformanceException {
        System.out.print("Playing " + song + " : ");
        instrument.play();
    }
}
