package com.rom4.departments.springtest.springdol;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 14:21
 * Project name Departments
 */
public class Sonnet29 implements Poem{
    private static String[] lines = {
            "Когда в раздоре с миром и судьбой,",
            "Припомнив годы, полные невзгод,",
            "Тревожу я бесплодною мольбой",
            "Глухой и равнодушный небосвод",
            "И, жалуясь на горестный удел,",
            "Готов меняться жребием своим",
            "С тем, кто в искусстве больше преуспел,",
            "Богат надеждой и людьми любим, -",
            "Тогда, внезапно вспомнив о тебе,"};

    @Override
    public void recite() {
        for (int i=0; i<lines.length;i++){
            System.out.println(lines[i]);
        }
    }
}
