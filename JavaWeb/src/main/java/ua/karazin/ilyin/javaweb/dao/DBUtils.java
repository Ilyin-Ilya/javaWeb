package ua.karazin.ilyin.javaweb.dao;

import ua.karazin.ilyin.javaweb.entity.Answer;
import ua.karazin.ilyin.javaweb.entity.Question;
import ua.karazin.ilyin.javaweb.entity.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {
    public Connection setConnection(String url) throws IOException, ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String username = "root";
        String password = "fateLol98";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public boolean addQuestion(Question question, Connection conn) throws SQLException {
        try {
            String query = "INSERT INTO `question` VALUES (?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, question.getQuestion_body());
            preparedStatement.setInt(2, question.getAuthor_id());
            preparedStatement.setDate(3, question.getDate_created());


            int rows = preparedStatement.executeUpdate();

            System.out.printf("%d rows added", rows);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public long addUser(User user) {

    }

    public long addAnswer(User user) {

    }

    public Answer[] getAllAnswers(Question question) {

    }

    public Question[] getAllQuestions() {

    }
};
