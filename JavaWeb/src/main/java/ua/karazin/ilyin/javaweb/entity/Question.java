package ua.karazin.ilyin.javaweb.entity;

import java.sql.Date;

public class Question {
    private long question_id;
    private String question_body;
    private long author_id;
    private java.sql.Date date_created;
    private boolean status;

    public Question() {
    }

    public Question(long question_id, String question_body, long author_id, Date date_created, boolean status) {
        this.question_id = question_id;
        this.question_body = question_body;
        this.author_id = author_id;
        this.date_created = date_created;
        this.status = status;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public String getQuestion_body() {
        return question_body;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public boolean isStatus() {
        return status;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

    public void setQuestion_body(String question_body) {
        this.question_body = question_body;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}