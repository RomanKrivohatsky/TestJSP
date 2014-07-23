package com.rom4.departments.springtest.springdol;

/**
 * Created by rom4 on 23.07.14.
 * Creation time 15:15
 * Project name Departments
 */
public class Instrumentalist implements Performer {
    private String song;
    private Instrument instrument;

    public Instrument getInstrument() {
        return instrument;
    }

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
