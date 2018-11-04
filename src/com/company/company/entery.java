package com.company.company;

public class entery {
    int enterTime, exitTime;

    public entery(int enterTime, int exitTime) {
        this.enterTime = enterTime;
        this.exitTime = exitTime;
    }

    public int getEnterTime() {
        return enterTime;
    }

    public int getExitTime() {
        return exitTime;
    }

    public int activeTime(){
        return exitTime-enterTime;
    }


}
