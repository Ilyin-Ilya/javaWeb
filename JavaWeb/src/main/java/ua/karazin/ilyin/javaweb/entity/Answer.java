package ua.karazin.ilyin.javaweb.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;

@Component
@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private int answer_id;
    @Column(name = "answer_body")
    private String answer_body;
    @Column(name = "author")
    private int author_id;
    @Column(name = "date_answered")
    private java.sql.Date date_answered;
    @Column(name = "question_id")
    private int question_id;
    @Column(name = "is_answer")
    private boolean is_answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id", insertable = false, updatable = false)
    private Question question;

    public Answer(int answer_id, String answer_body, int author_id, Date date_answered, int question_id, boolean is_answer, User user, Question question) {
        this.answer_id = answer_id;
        this.answer_body = answer_body;
        this.author_id = author_id;
        this.date_answered = date_answered;
        this.question_id = question_id;
        this.is_answer = is_answer;
        this.user = user;
        this.question = question;
    }

    public Answer() {
    }

    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswer_body() {
        return answer_body;
    }

    public void setAnswer_body(String answer_body) {
        this.answer_body = answer_body;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public Date getDate_answered() {
        return date_answered;
    }

    public void setDate_answered(Date date_answered) {
        this.date_answered = date_answered;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public boolean isIs_answer() {
        return is_answer;
    }

    public void setIs_answer(boolean is_answer) {
        this.is_answer = is_answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
