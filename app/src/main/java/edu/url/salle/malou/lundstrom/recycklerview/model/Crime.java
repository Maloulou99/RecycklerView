package edu.url.salle.malou.lundstrom.recycklerview.model;

public class Crime {
    private String title;
    private String description;
    private boolean isCritical;

    public Crime(String title, String description, boolean isCritical) {
        this.title = title;
        this.description = description;
        this.isCritical = isCritical;
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

    public boolean isCritical() {
        return isCritical;
    }

    public void setCritical(boolean critical) {
        this.isCritical = critical;
    }
}
