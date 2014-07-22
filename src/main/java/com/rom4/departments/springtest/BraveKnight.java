package com.rom4.departments.springtest;

/**
 * Created by rom4 on 22.07.14.
 * Creation time 15:43
 * Project name Departments
 */
public class BraveKnight implements Knight {
    private Quest quest;
    public BraveKnight(Quest quest) {
        this.quest = quest;
    }
    // Внедрение сценария подвига

    @Override
    public void embarkOnQuest() throws QuestException {
        quest.embark();
    }
}
