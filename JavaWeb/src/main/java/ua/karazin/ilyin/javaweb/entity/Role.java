package ua.karazin.ilyin.javaweb.entity;

public class Role {

    private long id;
    private String title;

    public Role() {
    }

    public Role(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
