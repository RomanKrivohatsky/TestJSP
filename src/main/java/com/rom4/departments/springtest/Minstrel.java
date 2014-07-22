package com.rom4.departments.springtest;

/**
 * Created by rom4 on 22.07.14.
 * Creation time 17:08
 * Project name Departments
 */
public class Minstrel {
    public void singBeforeQuest() { // Вызывается перед выполнением задания
        System.out.println("Fa la la; The knight is so brave!");
    }
    public void singAfterQuest() { // Вызывается после выполнения задания
        System.out.println(
                "Tee hee he; The brave knight did embark on a quest!");
    }
}
