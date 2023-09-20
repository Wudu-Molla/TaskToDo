package com.example.taskstodo;

public class Tasks {

    private String task;
    private boolean isDone = false;
    private String end_date = String.valueOf(' ');
    private String remaining_date = String.valueOf(' ');

    public Tasks(String task, boolean isDone, String end_date, String remaining_date) {
        this.task = task;
        this.isDone = isDone;
        this.end_date = end_date;
        this.remaining_date = remaining_date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getRemaining_date() {
        return remaining_date;
    }

    public void setRemaining_date(String remaining_date) {
        this.remaining_date = remaining_date;
    }
}
