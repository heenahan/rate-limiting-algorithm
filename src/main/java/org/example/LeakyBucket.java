package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class LeakyBucket {

    private int tokens;
    private int size;
    
    public LeakyBucket(int capacity, int outFlowRate) {
        this.tokens = 0;
        this.size = capacity;

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                remove(outFlowRate);
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }
    
    public int add() {
        if (this.tokens >= this.size) {
            return 429;
        }
        this.tokens++;
        return 200;
    }
    
    private void remove(int outFlowRate) {
        var outFlowedTokensCount = this.tokens - outFlowRate;

        this.tokens = Math.max(outFlowedTokensCount, 0);
    }
}
