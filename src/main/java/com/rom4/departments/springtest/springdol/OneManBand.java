package com.rom4.departments.springtest.springdol;

import java.util.Collection;
import java.util.Map;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 15:34
 * Project name Departments
 */
public class OneManBand implements Performer {
    private Map<String, Instrument> instruments;

    public void setInstruments(Map<String, Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public void perform() throws PerformanceException {
        for (String s:instruments.keySet()) {
            System.out.println("Plaing on:"+ s);
            Instrument instrument = instruments.get(s);
            instrument.play();
        }

    }
}
