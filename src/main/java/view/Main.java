package view;

import controller.TaskController;

public class Main {
    public static void main(String[] args) {
        new TaskGUI(new TaskController());
    }
}
