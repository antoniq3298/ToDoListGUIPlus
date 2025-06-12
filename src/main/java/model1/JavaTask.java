package model1;

public class JavaTask {
    private int id;
    private String title;
    private String status;
    private String priority;

    public JavaTask(int id, String title, String status, String priority) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.priority = priority;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getStatus() { return status; }
    public String getPriority() { return priority; }

    public void setStatus(String status) { this.status = status; }
    public void setPriority(String priority) { this.priority = priority; }
}






