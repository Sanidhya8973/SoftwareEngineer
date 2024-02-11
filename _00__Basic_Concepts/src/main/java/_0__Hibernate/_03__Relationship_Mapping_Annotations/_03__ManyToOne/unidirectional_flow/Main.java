package _0__Hibernate._03__Relationship_Mapping_Annotations._03__ManyToOne.unidirectional_flow;

import _0__Hibernate._03__Relationship_Mapping_Annotations._03__ManyToOne.unidirectional_flow.config.HibernateConfig;
import _0__Hibernate._03__Relationship_Mapping_Annotations._03__ManyToOne.unidirectional_flow.model.Answer;
import _0__Hibernate._03__Relationship_Mapping_Annotations._03__ManyToOne.unidirectional_flow.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testManyToOne();
        // testFlow()
    }

    public static void testManyToOne() {
        Question q1 = new Question("question-1");
        Answer a1a = new Answer("answer-1.a", q1);
        Answer a1b = new Answer("answer-1.b", q1);

        Question q2 = new Question("question-2");
        Answer a2a = new Answer("answer-2.a", q2);
        Answer a2b = new Answer("answer-2.b", q2);

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(q1);
        session.persist(q2);
        session.persist(a1a);
        session.persist(a1b);
        session.persist(a2a);
        session.persist(a2b);

        transaction.commit();
        session.close();
        sessionFactory.close();

        System.out.println("\nSUCCESS\n");

    }

    public static void testFlow() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Question> qlist = session.createQuery("from entity_question", Question.class).list();
        List<Answer> alist = session.createQuery("from entity_answer", Answer.class).list();

        System.out.println("QUESTIONS");
        qlist.forEach(System.out::println);
        System.out.println("ANSWERS");
        alist.forEach(System.out::println);

        session.close();
        sessionFactory.close();

        System.out.println("\nSUCCESS\n");

    }

}