package com.Team8858.TaskList;

import java.util.ArrayList;

public class TaskList extends Task {
    private ArrayList<Task> tasks;

    /**
     * creates a task list with the specified tasks
     * 
     * @param tasks list of tasks to add
     */
    public TaskList(Task... tasks) {
        super(() -> false);
        this.tasks = new ArrayList<Task>();
        for (int i = 0; i < tasks.length; i++) {
            this.tasks.add(tasks[i]);
        }
    }

    /**
     * creates an empty task list
     */
    public TaskList() {
        super(() -> false);
        this.tasks = new ArrayList<Task>();
    }

    /**
     * gets the size of the task list
     * 
     * @return the size of the task list
     */
    public int size() {
        return this.tasks.size();
    }

    /**
     * gets the task at the given index
     * 
     * @param index index to get
     * @return the task at the index
     */
    public Task get(int index) {
        return this.tasks.get(index);
    }

    /**
     * adds a task to the list
     * 
     * @param task the task to add
     */
    public void add(Task task) {
        this.tasks.add(task);
    }

    /**
     * skips the next task on the list
     */
    public void skip() {
        this.tasks.remove(0);
    }

    /**
     * checks if the task list is completed or not
     * 
     * @return true if the list is done (empty), false if it isn't
     */
    public boolean isDone() {
        return this.tasks.isEmpty();
    }

    /**
     * runs the tasklist
     * 
     * @return true if the list is done (empty), false if it isn't
     */
    @Override
    public boolean execute() {
        if (this.tasks.size() > 0) {
            if (this.tasks.get(0).execute()) {
                this.tasks.remove(0);
            }
            return false;
        }
        return true;
    }

    /**
     * clears the task list
     */
    public void clear() {
        this.tasks.clear();
    }
}
