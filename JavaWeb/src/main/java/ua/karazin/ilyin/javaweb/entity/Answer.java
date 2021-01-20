package ua.karazin.ilyin.javaweb.entity;

import java.sql.Date;

public class Answer {
    private long answer_id;
    private String answer_body;
    private long author_id;
    private java.sql.Date date_answered;
    private long question_id;
    private boolean is_answer;

    public Answer() {
    }

    public Answer(long answer_id, String answer_body, long author_id, Date date_answered, long question_id, boolean is_answer) {
        this.answer_id = answer_id;
        this.answer_body = answer_body;
        this.author_id = author_id;
        this.date_answered = date_answered;
        this.question_id = question_id;
        this.is_answer = is_answer;
    }

    public long getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(long answer_id) {
        this.answer_id = answer_id;
    }

    public String getAnswer_body() {
        return answer_body;
    }

    public void setAnswer_body(String answer_body) {
        this.answer_body = answer_body;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public Date getDate_answered() {
        return date_answered;
    }

    public void setDate_answered(Date date_answered) {
        this.date_answered = date_answered;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

    public boolean isIs_answer() {
        return is_answer;
    }

    public void setIs_answer(boolean is_answer) {
        this.is_answer = is_answer;
    }
}
