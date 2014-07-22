package com.rom4.departments.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by rom4 on 22.07.14.
 * Creation time 15:39
 * Project name Departments
 */
public class KnightMain {
    public static void main(String[] args) throws QuestException {
// Загрузка контекста Spring

        ApplicationContext context =
                new ClassPathXmlApplicationContext("Knight.xml");
// Получение компонента knight
            Knight knight = (Knight) context.getBean("knight");
// Использование компонента knight
        knight.embarkOnQuest();
    }
}
