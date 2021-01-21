package ua.karazin.ilyin.javaweb.dto;

import ua.karazin.ilyin.javaweb.dao.DBUtils;
import ua.karazin.ilyin.javaweb.entity.Question;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;

public class QuestionDisplay {

    private int sequence_number;
    private String question_title;
    private String author;
    private int answers_number;
    private String status;

    public QuestionDisplay(int sequence_number, Question question) throws NoSuchMethodException, IOException, InstantiationException, SQLException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        DBUtils db = new DBUtils();
        Connection connection = db.setConnection();
        this.sequence_number = sequence_number;
        this.question_title = question.getQuestion_name();
        this.author = db.f
    }
}
