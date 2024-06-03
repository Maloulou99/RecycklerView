package edu.url.salle.malou.lundstrom.recycklerview.model;

public class Crime {
    private String title;
    private String description;
    private boolean solved;
    private boolean isCritical;

    public Crime(String title, String description, boolean solved, boolean isCritical) {
        this.title = title;
        this.description = description;
        this.solved = solved;
        this.isCritical = isCritical; // Initialize the new field
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSolved() {
        return solved;
    }

    public boolean isCritical() {
        return isCritical;
    }

    public void setCritical(boolean critical) {
        isCritical = critical;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }
}
