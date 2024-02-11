package _0__Hibernate._03__Relationship_Mapping_Annotations._04__ManyToMany.model;

import jakarta.persistence.*;

import java.util.*;

@Entity(name = "entity_answer")
@Table(name = "table_answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_answer_id")
    @SequenceGenerator(name = "generator_answer_id", sequenceName = "sequence_answer_id", allocationSize = 1)
    @Column(name = "answer_id")
    private int id;

    @Column(name = "answer_ans", nullable = false, unique = false)
    private String answer;

    @ManyToMany(mappedBy = "answer")
    private List<Question> question = new ArrayList<>();

    public Answer() {

    }

    public Answer(String answer) {
        super();
        this.answer = answer;
    }

    public Answer(String answer, List<Question> question) {
        super();
        this.answer = answer;
        this.question = question;
    }

    public Answer(int id, String answer, List<Question> question) {
        super();
        this.id = id;
        this.answer = answer;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer -> [ id=" + id + ", answer=" + answer + " ]";
    }

}