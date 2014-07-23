package com.rom4.departments.springtest.springdol;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 17:54
 * Project name Departments
 */
public class Magician implements Performer {
    public Magician() {}

    @Override
    public void perform() throws PerformanceException {

            System.out.println(magicWords);
            System.out.println("The magic box contains...");
            System.out.println(magicBox.getContents()); // Исследует содержимое

    }

    // ящика
// внедрение
    private MagicBox magicBox;
    public void setMagicBox(MagicBox magicBox) {
        this.magicBox = magicBox; // Внедрение волшебного ящика
    }
    private String magicWords;
    public void setMagicWords(String magicWords) {
        this.magicWords = magicWords;
    }
}