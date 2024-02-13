package _0__Hibernate._03__Hibernate_Mapping_Annotations._02__OneToMany.unidirectional_flow;


import java.util.*;

import _0__Hibernate._03__Hibernate_Mapping_Annotations._02__OneToMany.unidirectional_flow.config.*;
import _0__Hibernate._03__Hibernate_Mapping_Annotations._02__OneToMany.unidirectional_flow.model.*;
import org.hibernate.*;

public class Main {

    public static void main(String[] args) {
        testOneToMany();
        // testFlow()
    }

    public static void testOneToMany() {
        Question q1 = new Question("question-1");
        Answer a1a = new Answer("answer-1.a");
        Answer a1b = new Answer("answer-1.b");
        q1.getAnswer().addAll(Arrays.asList(a1a, a1b));

        Question q2 = new Question("question-2");
        Answer a2a = new Answer("answer-2.a");
        Answer a2b = new Answer("answer-2.b");
        q2.getAnswer().addAll(Arrays.asList(a2a, a2b));

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(q1);
        session.persist(q2);

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
