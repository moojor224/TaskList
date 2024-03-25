package com.Team8858.TaskList;

import java.util.function.Supplier;

public class Task {
    private boolean initialized = false;
    private Runnable init = () -> {
    };
    private Supplier<Boolean> task;

    public Task(Supplier<Boolean> task) {
        this(() -> {
        }, task);
    }

    public Task(Runnable init, Supplier<Boolean> task) {
        this.init = init;
        this.task = task;
    }

    public boolean execute() {
        if (!this.initialized) {
            this.init.run();
        }
        return this.task.get();
    }
}
