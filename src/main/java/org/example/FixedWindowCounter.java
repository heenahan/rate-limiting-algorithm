package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class FixedWindowCounter {

    private int counter;
    private int capacity;

    public FixedWindowCounter(int capacity) {
        this.counter = 0;
        this.capacity = capacity;

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                init();
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }

    private void init() {
        this.counter = 0;
    }

    public int add() {
        if (this.counter < this.capacity) {
            this.counter++;

            return 200;
        }

        return 429;
    }
}
