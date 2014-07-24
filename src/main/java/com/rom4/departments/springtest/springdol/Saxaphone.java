package com.rom4.departments.springtest.springdol;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 15:22
 * Project name Departments
 */
@Component
@Qualifier("saxaphone")
public class Saxaphone implements Instrument {
    @Override
    public void play() {
        System.out.println("TOOT TOOT TOOT");
    }
}
