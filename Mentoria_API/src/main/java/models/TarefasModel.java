package models;

public class TarefasModel {
	private String title;
    private String description;
    private String deadLine;
    private boolean done;
    
    public TarefasModel(String title, String description, String deadLine, boolean done) {
        this.title = title;
        this.description = description;
        this.deadLine = deadLine;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }



}
