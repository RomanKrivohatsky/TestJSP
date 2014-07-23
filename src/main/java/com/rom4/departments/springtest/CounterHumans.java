package com.rom4.departments.springtest;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 13:43
 * Project name Departments
 */
public class CounterHumans {
    private static int count=0;

    public static int getCount() {
        return count+=10;
    }
}
