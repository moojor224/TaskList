package com.Team8858.TaskList;

import java.util.ArrayList;

public class ParallelTask extends Task {
    private ArrayList<Task> list;
    private boolean stopWhenDone = false;

    /**
     * creates a new parallel task with the given tasks
     * 
     * @param tasks the tasks to run
     */
    public ParallelTask(Task... tasks) {
        super(() -> false);
        this.list = new ArrayList<Task>();
        for (int i = 0; i < tasks.length; i++) {
            this.list.add(tasks[i]);
        }
    }

    /**
     * creates a new parallel task with the given tasks
     * 
     * @param tasks the tasks to run
     */
    public ParallelTask(boolean stopWhenDone, Task... tasks) {
        this(tasks);
        this.stopWhenDone = stopWhenDone;
    }

    @Override
    public boolean execute() {
        boolean done = true; // done will remain true if all tasks are complete
        for (int i = 0; i < this.list.size(); i++) { // loop through each task in the list
            if (!this.list.get(i).execute()) { // run the task
                done = false; // if task isn't complete, set done to false
            } else { // the task is complete
                if (this.stopWhenDone) { // if stopWhenDone is true, the task is removed
                    this.list.remove(i); // remove the task
                    i--; // decrement i to continue running tasks
                }
            }
        }
        return done;
    }
}
