package _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.bidirectional_flow;

import _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.bidirectional_flow.config.HibernateConfig;
import _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.bidirectional_flow.model.Answer;
import _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.bidirectional_flow.model.Question;
import org.hibernate.*;

import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        // testOneToOne();
        testFlow();
    }

    public static void testOneToOne() {

        List<Question> questionList = new ArrayList<>();
        List<Answer> answerList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Question question = new Question("question-" + i);
            Answer answer = new Answer("answer-" + i, question);
            question.setAnswer(answer);
            questionList.add(question);
            answerList.add(answer);
        }

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

        BiConsumer<Question, Answer> consume = (Question q, Answer a) -> {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.persist(q);
            session.persist(a);
            tx.commit();

            session.close();
        };

        consume.accept(questionList.get(0), answerList.get(0));
        consume.accept(questionList.get(1), answerList.get(1));
        consume.accept(questionList.get(2), answerList.get(2));
        consume.accept(questionList.get(3), answerList.get(3));
        consume.accept(questionList.get(4), answerList.get(4));

        sessionFactory.close();

        System.out.println("\nSUCCESS\n");

    }

    public static void testFlow() {

        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        List<Question> questionList = session.createQuery("from bidirectional_question", Question.class).list();
        List<Answer> answerList = session.createQuery("from bidirectional_answer", Answer.class).list();

        session.close();
        sessionFactory.close();

        System.out.println();
        System.out.println("---------------------");
        System.out.println("UNI-DIRECTIONAL CHECK");
        System.out.println("---------------------");
        System.out.println("> QUESTIONS");
        questionList.forEach(e -> System.out.println(e));
        System.out.println("> ANSWERS");
        answerList.forEach(e -> System.out.println(e));
        System.out.println();
        System.out.println("---------------------");
        System.out.println("BI-DIRECTIONAL CHECK");
        System.out.println("---------------------");
        System.out.println(answerList.get(0).getQuestion());
        System.out.println(answerList.get(1).getQuestion().getId());
        System.out.println(answerList.get(2).getQuestion().getAnswer());
        System.out.println(answerList.get(3).getQuestion());
        System.out.println(answerList.get(4).getQuestion().getClass());

        System.out.println("\nSUCCESS\n");

    }

}
