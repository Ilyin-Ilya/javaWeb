package ua.karazin.ilyin.javaweb.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Component
@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int question_id;
    @Column(name = "title")
    private String question_name;
    @Column(name = "question_body")
    private String question_body;
    @Column(name = "author")
    private int author_id;
    @Column(name = "date_created")
    private java.sql.Date date_created;
    @Column(name = "status")
    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User author;

    public Question() {
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getQuestion_name() {
        return question_name;
    }

    public void setQuestion_name(String question_name) {
        this.question_name = question_name;
    }

    public String getQuestion_body() {
        return question_body;
    }

    public void setQuestion_body(String question_body) {
        this.question_body = question_body;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public Date getDate_created() {
        return date_created;
    }

    public void setDate_created(Date date_created) {
        this.date_created = date_created;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Question(int question_id, String question_name, String question_body, int author_id, Date date_created, boolean status, User author) {
        this.question_id = question_id;
        this.question_name = question_name;
        this.question_body = question_body;
        this.author_id = author_id;
        this.date_created = date_created;
        this.status = status;
        this.author = author;
    }
}
