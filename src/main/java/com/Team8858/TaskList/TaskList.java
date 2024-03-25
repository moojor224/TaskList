package com.Team8858.TaskList;

import java.util.ArrayList;

public class TaskList extends Task {
    private ArrayList<Task> tasks;

    public TaskList(Task... tasks) {
        super(() -> false);
        this.tasks = new ArrayList<Task>();
        for (int i = 0; i < tasks.length; i++) {
            this.tasks.add(tasks[i]);
        }
    }

    public int size() {
        return this.tasks.size();
    }

    public Task get(int index){
        return this.tasks.get(index);
    }

    public boolean isDone() {
        return this.tasks.size() == 0;
    }

    @Override
    public boolean execute() {
        Task t = this.tasks.get(0);
        boolean result = t.execute();
        if (result) {
            this.tasks.remove(0);
        }
        return this.isDone();
    }
}
