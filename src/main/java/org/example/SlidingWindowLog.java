package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowLog {

    private List<LocalDateTime> cache;
    private int capacity;

    public SlidingWindowLog(int capacity) {
        this.cache = new ArrayList<>();
        this.capacity = capacity;
    }

    public int add() {
        this.cache.add(LocalDateTime.now());
        this.
    }

    private void filterPreviousWindow() {
        var windowStart = LocalDateTime.now();
        windowStart.
    }
}
