package _0__Hibernate._03__Relationship_Mapping_Annotations._03__ManyToOne.unidirectional_flow.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "entity_question")
@Table(name = "table_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_question_id")
    @SequenceGenerator(name = "generator_question_id", sequenceName = "sequence_question_id", allocationSize = 1)
    @Column(name = "question_id")
    private int id;

    @Column(name = "question_que", nullable = false, unique = false)
    private String question;

    public Question() {

    }

    public Question(String question) {
        super();
        this.question = question;
    }

    public Question(int id, String question) {
        super();
        this.id = id;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Question -> [ id=" + id + ", question=" + question + " ]";
    }

}