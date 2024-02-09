package _0__Hibernate._03__Relationship_Mapping_Annotations._02__OneToMany.unidirectional_flow;

import _0__Hibernate._03__Relationship_Mapping_Annotations._02__OneToMany.unidirectional_flow.config.HibernateConfig;
import _0__Hibernate._03__Relationship_Mapping_Annotations._02__OneToMany.unidirectional_flow.model.Answer;
import _0__Hibernate._03__Relationship_Mapping_Annotations._02__OneToMany.unidirectional_flow.model.Question;

import org.hibernate.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // testOneToMany();
        testFlow();
    }

    public static void testOneToMany() {

        Question q1 = new Question("question-1");
        Answer a1 = new Answer("answer-1");
        Answer a2 = new Answer("answer-2");
        q1.getAnswer().addAll(Arrays.asList(a1, a2));

        Question q2 = new Question("question-2");
        Answer a3 = new Answer("answer-3");
        q2.getAnswer().addAll(Arrays.asList(a3));

        Question q3 = new Question("question-3");
        Answer a4 = new Answer("answer-4");
        Answer a5 = new Answer("answer-5");
        q3.getAnswer().addAll(Arrays.asList(a4, a5));

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(q1);
        session.persist(q2);
        session.persist(q3);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);
        session.persist(a4);
        session.persist(a5);

        transaction.commit();

        session.close();
        sessionFactory.close();

        System.out.println("\nSUCCESS\n");

    }

    public static void testFlow() {

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Question> qtable = session.createQuery("from unidirectional_question", Question.class).list();
        List<Answer> atable = session.createQuery("from unidirectional_answer", Answer.class).list();

        // lazy instantiation
        System.out.println("QUESTIONS");
        qtable.forEach(e -> System.out.println(e));
        System.out.println("ANSWERS");
        atable.forEach(e -> System.out.println(e));

        session.close();
        sessionFactory.close();

        System.out.println("\nSUCCESS\n");

    }

}
