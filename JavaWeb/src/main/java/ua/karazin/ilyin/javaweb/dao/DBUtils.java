package ua.karazin.ilyin.javaweb.dao;

import ua.karazin.ilyin.javaweb.entity.Answer;
import ua.karazin.ilyin.javaweb.entity.Question;
import ua.karazin.ilyin.javaweb.entity.Role;
import ua.karazin.ilyin.javaweb.entity.User;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class DBUtils {

    public Connection setConnection() throws IOException, ClassNotFoundException, SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String username = "root";
        String url = "jdbc:mysql://localhost/forum?serverTimezone=Europe/Moscow&useSSL=false";
        String password = "fateLol98";
        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public boolean addQuestion(Question question, Connection conn) throws SQLException {
        try {
            String query = "INSERT INTO `question` VALUES (NULL,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, question.getQuestion_body());
            preparedStatement.setInt(2, question.getAuthor_id());
            preparedStatement.setDate(3, question.getDate_created());
            preparedStatement.setString(4, question.getQuestion_name());

            int rows = preparedStatement.executeUpdate();

            System.out.printf("%d rows added", rows);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addUser(User user, Connection conn) {
        try {
            String query = "INSERT INTO `users` VALUES (NULL,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getRole().getId());


            int rows = preparedStatement.executeUpdate();

            System.out.printf("%d rows added", rows);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addAnswer(Answer answer, Connection conn) {
        try {
            String query = "INSERT INTO `answer` VALUES (NULL,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, answer.getAnswer_body());
            preparedStatement.setInt(2, answer.getAuthor_id());
            preparedStatement.setDate(3, answer.getDate_answered());
            preparedStatement.setInt(4, answer.getQuestion_id());
            preparedStatement.setBoolean(5, answer.isIs_answer());

            int rows = preparedStatement.executeUpdate();

            System.out.printf("%d rows added", rows);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public ArrayList<Answer> getAllAnswers(Question question, Connection conn) {
        ArrayList<Answer> answers = new ArrayList<>();
        try {
            String query = "SELECT * FROM `answer`" +
                    "INNER JOIN `question`" +
                    "WHERE `answer`.question_id=" + question.getQuestion_id();

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Answer answer = new Answer();
                answer.setAnswer_id(resultSet.getInt(1));
                answer.setAnswer_body(resultSet.getString(2));
                answer.setAuthor_id(resultSet.getInt(3));
                answer.setDate_answered(resultSet.getDate(4));
                answer.setQuestion_id(resultSet.getInt(5));
                answer.setIs_answer(resultSet.getBoolean(6));
                answers.add(answer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return answers;
    }

    public ArrayList<Question> getAllQuestions(Connection conn) {
        ArrayList<Question> questions = new ArrayList<>();
        try {
            String query = "SELECT * FROM `question`";

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Question question = new Question();
                question.setQuestion_id(resultSet.getInt(1));
                question.setQuestion_body(resultSet.getString(2));
                question.setAuthor_id(resultSet.getInt(3));
                question.setDate_created(resultSet.getDate(4));
                question.setStatus(resultSet.getBoolean(5));
                question.setQuestion_name(resultSet.getString(6));
                questions.add(question);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return questions;
    }

    public User findUserLogin(String login, Connection conn) {
        try {
            String query = "SELECT * FROM `users`" +
                    " where `users`.login = " + "'" + login + "'";


            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                Role role = new Role();
                role.setId(resultSet.getInt(4));
                user.setRole(role);
                Role role1 = this.findRole(user, conn);
                user.setRole(role1);
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new User();
    }

    public User findAuthor(Question question, Connection conn) {
        ArrayList<Question> questions = new ArrayList<>();
        try {
            String query = "SELECT * FROM `users` \n" +
                    "INNER JOIN `question` \n" +
                    "ON `users`.user_id = `question`.author \n" +
                    "where `users`.user_id = " + question.getAuthor_id();

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                Role role = new Role();
                role.setId(resultSet.getInt(4));
                user.setRole(role);
                Role role1 = this.findRole(user, conn);
                user.setRole(role1);
                return user;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new User();
    }

    public Role findRole(User user, Connection conn) {
        try {
            String query = "SELECT * FROM `role`\n" +
                    "INNER JOIN `users`  \n" +
                    "ON `users`.role = `role`.role_id\n" +
                    "where `role`.role_id = " + user.getRole().getId();

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Role role = new Role();
            while (resultSet.next()) {
                role.setId(resultSet.getInt(1));
                role.setTitle(resultSet.getString(2));
                return role;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        Role role = new Role();
        return role;
    }

    public Integer getSumOfAnswers(Question question, Connection conn) {
        try {
            String query = "SELECT COUNT(*) from `answer` \n" +
                    "INNER JOIN `question` ON \n" +
                    "`answer`.question_id = " + question.getQuestion_id();

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next())
                return resultSet.getInt(1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public Question findQuestion(Integer question_id, Connection conn) {
        try {
            String query = "SELECT * FROM `question`\n" +
                    "where `question`.question_id = " + question_id;

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            Question question = new Question();
            while (resultSet.next()) {
                question.setQuestion_id(resultSet.getInt(1));
                question.setQuestion_body(resultSet.getString(2));
                question.setAuthor_id(resultSet.getInt(3));
                question.setDate_created(resultSet.getDate(4));
                question.setStatus(resultSet.getBoolean(5));
                question.setQuestion_name(resultSet.getString(6));
                return question;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new Question();
    }

    public User findAnswerAuthor(Answer answer, Connection conn) {
        try {
            String query = "SELECT * FROM `users`\n" +
                    "INNER JOIN `answer` \n" +
                    "ON `answer`.author = `users`.user_id \n" +
                    "where `answer`.answer_id = " + answer.getAnswer_id();

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            User author = new User();
            while (resultSet.next()) {
                author.setId(resultSet.getInt(1));
                author.setLogin(resultSet.getString(2));
                return author;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new User();
    }
}
