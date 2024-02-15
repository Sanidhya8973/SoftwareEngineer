package _07__Hibernate._03__Hibernate_Mapping_Annotations._04__ManyToMany;

import _07__Hibernate._03__Hibernate_Mapping_Annotations._04__ManyToMany.config.HibernateConfig;
import _07__Hibernate._03__Hibernate_Mapping_Annotations._04__ManyToMany.model.Answer;
import _07__Hibernate._03__Hibernate_Mapping_Annotations._04__ManyToMany.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        testManyToMany();
        // testFlow()
    }

    public static void testManyToMany() {

        Question q1 = new Question("question-1");
        Question q2 = new Question("question-2");
        Question q3 = new Question("question-3");
        Question q4 = new Question("question-4");

        Answer a1 = new Answer("answer-1");
        Answer a2 = new Answer("answer-2");
        Answer a3 = new Answer("answer-3");
        Answer a4 = new Answer("answer-4");

        a1.getQuestion().addAll(Arrays.asList(q1, q2, q4));
        a2.getQuestion().addAll(Arrays.asList(q2, q4));
        a3.getQuestion().addAll(Arrays.asList(q1, q3, q4));
        a4.getQuestion().addAll(Arrays.asList(q3, q4));

        q1.getAnswer().addAll(Arrays.asList(a1, a3));
        q2.getAnswer().addAll(Arrays.asList(a1, a2));
        q3.getAnswer().addAll(Arrays.asList(a3, a4));
        q4.getAnswer().addAll(Arrays.asList(a1, a2, a3, a4));

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.persist(q1);
        session.persist(q2);
        session.persist(q3);
        session.persist(q4);

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