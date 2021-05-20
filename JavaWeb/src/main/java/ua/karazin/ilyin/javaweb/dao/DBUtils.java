package ua.karazin.ilyin.javaweb.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ua.karazin.ilyin.javaweb.entity.Answer;
import ua.karazin.ilyin.javaweb.entity.Question;
import ua.karazin.ilyin.javaweb.entity.Role;
import ua.karazin.ilyin.javaweb.entity.User;

import java.util.List;

@Repository
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
        Query query = session.createQuery("from Question");
        List list = query.list();
        return list;
    }

    public User findUserLogin(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User " +
                "where login =: user_login", User.class);
        query.setParameter("user_login", login);
        User res = (User) query.getSingleResult();
        return res;
    }

    public User findAuthor(Question question) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from User as u" +
                " inner join u.questions as q" +
                " where q.author_id = :author_id");
        query.setParameter("author_id", question.getAuthor().getId());
        if (!query.list().isEmpty()) {
            List list = query.list();
            Object[] f = (Object[]) query.getSingleResult();
            User res = (User) f[0];
            return res;
        }
        return null;
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

    public Long getSumOfAnswers(Question question) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select count(*) from Answer a \n" +
                "INNER JOIN a.question");
        List list = query.list();
        Object f = query.getSingleResult();
        Long res = (Long) f;
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
