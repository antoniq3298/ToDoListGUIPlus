package view;

import controller.TaskController;

import javax.swing.*;
import java.awt.*;


import controller.TaskController;


public class TaskGUI extends JFrame {
    private JTextField taskInput = new JTextField(15);
    private JComboBox<String> statusBox = new JComboBox<>(new String[]{"Pending", "In Progress", "Done"});
    private JComboBox<String> priorityBox = new JComboBox<>(new String[]{"Low", "Medium", "High"});
    private JButton addButton = new JButton("Add Task");
    private JTextArea output = new JTextArea(10, 30);

    public TaskGUI(TaskController controller) {
        setTitle("ToDo List Manager");
        setLayout(new FlowLayout());

        add(new JLabel("Task:"));
        add(taskInput);
        add(new JLabel("Status:"));
        add(statusBox);
        add(new JLabel("Priority:"));
        add(priorityBox);
        add(addButton);
        add(new JScrollPane(output));

        addButton.addActionListener(e -> {
            String title = taskInput.getText();
            String status = (String) statusBox.getSelectedItem();
            String priority = (String) priorityBox.getSelectedItem();
            controller.addTask(title, status, priority);
            taskInput.setText("");
            controller.loadTasks(output);
        });

        controller.loadTasks(output);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }
}

