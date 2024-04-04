package com.Team8858.TaskList;

import java.util.function.Supplier;

public class Task {
    /**
     * whether the task's init function has been run yet
     */
    private boolean initialized = false;

    /**
     * the task's init function
     */
    private Runnable init = () -> {
    };

    /**
     * the task's main function
     */
    private Supplier<Boolean> periodic;

    /**
     * creates a task without an init function
     * 
     * @param task the task's main function
     */
    public Task(Supplier<Boolean> task) {
        this(() -> {
        }, task);
    }

    /**
     * creates a task with an init function
     * 
     * @param init function that runs once before the the task's first run
     * @param task the task's main function
     */
    public Task(Runnable init, Supplier<Boolean> task) {
        this.init = init;
        this.periodic = task;
    }

    /**
     * runs the task
     * 
     * @return true if the task is complete, false if it isn't
     */
    public boolean execute() {
        if (!this.initialized) {
            this.init.run();
        }
        return this.periodic.get();
    }
}
