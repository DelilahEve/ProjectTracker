package ca.delilaheve.scheduler.data;

import java.io.Serializable;

public class Task implements Serializable {

    private int taskID;
    private int projectID = -1;

    private String taskTitle;

    public Task(int taskID, String taskTitle) {
        this.taskID = taskID;
        this.taskTitle = taskTitle;
    }

    public Task(int taskID, int projectID, String taskTitle)
    {
        this.taskID = taskID;
        this.projectID = projectID;
        this.taskTitle = taskTitle;
    }

    public int getProjectID() {
        return projectID;
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskTitle() {
        return taskTitle;
    }
}
