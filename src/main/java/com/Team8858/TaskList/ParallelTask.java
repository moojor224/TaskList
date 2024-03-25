package com.Team8858.TaskList;

import java.util.ArrayList;

public class ParallelTask extends Task {
    private ArrayList<Task> list;

    public ParallelTask(Task... tasks) {
        super(() -> false);
        this.list = new ArrayList<Task>();
        for (int i = 0; i < tasks.length; i++) {
            this.list.add(tasks[i]);
        }
    }

    @Override
    public boolean execute() {
        boolean done = true;
        for (int i = 0; i < this.list.size(); i++) {
            if (!this.list.get(i).execute()) {
                done = false;
            }
        }
        return done;
    }
}
