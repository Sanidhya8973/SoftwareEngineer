package _0__Hibernate._03__Relationship_Mapping_Annotations._02__OneToMany.unidirectional_flow.model;

import jakarta.persistence.*;

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

    public Answer() {

    }

    public Answer(String answer) {
        super();
        this.answer = answer;
    }

    public Answer(int id, String answer) {
        super();
        this.id = id;
        this.answer = answer;
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

    @Override
    public String toString() {
        return "Answer -> [ id=" + id + ", answer=" + answer + " ]";
    }

}