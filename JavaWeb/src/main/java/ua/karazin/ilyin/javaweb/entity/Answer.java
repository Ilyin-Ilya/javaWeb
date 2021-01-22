package ua.karazin.ilyin.javaweb.entity;

import ua.karazin.ilyin.javaweb.dao.DBUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.SQLException;

public class Answer {
    private int answer_id;
    private String answer_body;
    private int author_id;
    private java.sql.Date date_answered;
    private int question_id;
    private boolean is_answer;

    public Answer() {
    }

    public Answer(int answer_id, String answer_body, int author_id, Date date_answered, int question_id, boolean is_answer) {
        this.answer_id = answer_id;
        this.answer_body = answer_body;
        this.author_id = author_id;
        this.date_answered = date_answered;
        this.question_id = question_id;
        this.is_answer = is_answer;
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

    public User findAuthor() throws NoSuchMethodException, IOException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        DBUtils dbUtils = new DBUtils();
        return dbUtils.findAnswerAuthor(this, dbUtils.setConnection());
    }
}
