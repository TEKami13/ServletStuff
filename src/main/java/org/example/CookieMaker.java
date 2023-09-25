package org.example;

import java.util.Date;

public class CookieMaker {

    private String name;
    private int counter;
    private Date timer;

    public CookieMaker(String name, int counter, Date timer) {
        this.name = name;
        this.counter = counter;
        this.timer = timer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public Date getTimer() {
        return timer;
    }

    public void setTimer(Date timer) {
        this.timer = timer;
    }
}
