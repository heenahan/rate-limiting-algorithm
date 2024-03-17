package org.example;

import java.util.Timer;
import java.util.TimerTask;

public class TokenBucket {

    private int tokens;
    private int capacity;

    public TokenBucket(
        int capacity,
        int refillRate
    ) {
        this.tokens = capacity;
        this.capacity = capacity;

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                add(refillRate); // 불변이 아니라서 잘못 짬
            }
        };
        timer.schedule(timerTask, 1000, 1000);
    }

    private void add(int refillRate) {
        var refillTokenCount = this.tokens + refillRate;

        this.tokens = Math.min(refillTokenCount, this.capacity);
    }

    public int remove() {
        if (this.tokens > 0) {
            this.tokens--;
            return 200;
        }
        return 429;
    }
}
