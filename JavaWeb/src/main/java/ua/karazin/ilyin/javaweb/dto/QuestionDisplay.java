package ua.karazin.ilyin.javaweb.dto;

import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.entity.Question;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class QuestionDisplay implements Serializable {

    private int sequence_number;
    private String question_title;
    private String author;
    private int answers_number;
    private String status;

    public QuestionDisplay() {
    }

    public QuestionDisplay(Question question) throws NoSuchMethodException, IOException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        DBUtils utils = new DBUtils();
        this.sequence_number = question.getQuestion_id();
        this.question_title = question.getQuestion_name();
        this.author = utils.findAuthor(question).getLogin();
        this.answers_number = utils.getSumOfAnswers(question);
        if (!question.isStatus()) {
            this.status = "Open";
        } else {
            this.status = "Closed";
        }
    }

    /*
    if (question.isStatus()) {
            this.status = "Open";
        } else {
            this.status = "Closed";
        }
     */

    public int getSequence_number() {
        return sequence_number;
    }

    public void setSequence_number(int sequence_number) {
        this.sequence_number = sequence_number;
    }

    public String getQuestion_title() {
        return question_title;
    }

    public void setQuestion_title(String question_title) {
        this.question_title = question_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getAnswers_number() {
        return answers_number;
    }

    public void setAnswers_number(int answers_number) {
        this.answers_number = answers_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
