package ua.karazin.ilyin.javaweb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import ua.karazin.ilyin.javaweb.entity.Answer;
import ua.karazin.ilyin.javaweb.entity.Question;
import ua.karazin.ilyin.javaweb.entity.Role;
import ua.karazin.ilyin.javaweb.entity.User;

import java.util.List;

public class DBUtils {

    public boolean addQuestion(Question question) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(question);
        tx1.commit();
        session.close();
        return true;
    }

    public boolean addUser(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
        return true;
    }

    public boolean addAnswer(Answer answer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(answer);
        tx1.commit();
        session.close();
        return true;
    }

    public List<Answer> getAllAnswers(Question question) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from answer" +
                "inner join question" +
                "where answer.question_id= :question_id");

        query.setParameter("question_id", question.getQuestion_id());
        List list = query.list();
        return list;
    }

    public List<Question> getAllQuestions() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from question");
        List list = query.list();
        return list;
    }

    public User findUserLogin(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from users" +
                "where users.login = :user_login");
        query.setParameter("user_login", login);
        User res = (User) query.getSingleResult();
        return res;
    }

    public User findAuthor(Question question) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from users" +
                "inner join question" +
                "where users.user_id = :author_id");
        query.setParameter("author_id", question.getAuthor_id());
        User res = (User) query.getSingleResult();
        return res;
    }

    public Role findRole(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from role\n" +
                "inner join users  \n" +
                "where role.role_id = :role_id");
        query.setParameter("role_id", user.getRole().getId());
        Role res = (Role) query.getSingleResult();
        return res;
    }

    public Integer getSumOfAnswers(Question question) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select count(*) from answer \n" +
                "INNER JOIN question ON");
        Integer res = (Integer) query.getSingleResult();
        return res;
    }

    public Question findQuestion(Integer question_id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from question\n" +
                "where question.question_id = :question_id");
        query.setParameter("question_id", question_id);
        Question res = (Question) query.getSingleResult();
        return res;
    }

    public User findAnswerAuthor(Answer answer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from users\n" +
                "inner join answer \n" +
                "where answer.answer_id = :answer_id");
        query.setParameter("answer_id", answer.getAnswer_id());
        User res = (User) query.getSingleResult();
        return res;
    }
}
