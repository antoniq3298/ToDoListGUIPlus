package controller;

import Task.Task;
import database.DBManager;

import model1.JavaTask;

import javax.swing.*;
import java.util.List;

public class TaskController {
    private DBManager db = new DBManager();

    public void addTask(String title, String status, String priority) {
        if (!title.trim().isEmpty() && status != null && priority != null) {
            db.addTask(title, status, priority);
        }
    }

    public void loadTasks(JTextArea output) {
        List<JavaTask> tasks = db.getAllTasks();
        output.setText("");
        for (JavaTask t : tasks) {
            output.append(String.format("• %s [%s / %s]%n", t.getTitle(), t.getStatus(), t.getPriority()));
        }
    }
}

