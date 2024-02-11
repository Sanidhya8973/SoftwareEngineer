package _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.unidirectional_flow;

import _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.unidirectional_flow.config.HibernateConfig;
import _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.unidirectional_flow.model.Answer;
import _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.unidirectional_flow.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class Main {

    public static void main(String[] args) {
        testOneToOne();
        // testFlow();
    }

    public static void testOneToOne() {

        Question q1 = new Question("question-1");
        Answer a1 = new Answer("answer-1");
        q1.setAnswer(a1);

        Question q2 = new Question("question-2");
        Answer a2 = new Answer("answer-2");
        q2.setAnswer(a2);

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(q1);
        session.persist(q2);
        session.persist(a1);
        session.persist(a2);

        tx.commit();

        session.close();
        sessionFactory.close();

        System.out.println("\nSUCCESS\n");

    }

    public static void testFlow() {

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Question> questionList = session.createQuery("from unidirectional_question", Question.class).list();
        List<Answer> answerList = session.createQuery("from unidirectional_answer", Answer.class).list();

        questionList.forEach(System.out::println);
        answerList.forEach(System.out::println);

        session.close();
        sessionFactory.close();

        System.out.println("\nSUCCESS\n");

    }

}
