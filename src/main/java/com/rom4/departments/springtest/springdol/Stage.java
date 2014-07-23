package com.rom4.departments.springtest.springdol;


/**
 * Created by rom4 on 23.07.14.
 * Creation time 14:02
 * Project name Departments
 */
public class Stage {

    private Stage () {  }

    private static class StageHolder {
        static Stage instance = new Stage();
    }


    public static Stage getInstance () {
        return StageHolder.instance;
    }
}
