package _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.unidirectional_flow.model;

import jakarta.persistence.*;

@Entity(name = "unidirectional_answer")
@Table(name = "unidirectional_answer_table")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private int id;

    @Column(name = "answer_ans")
    private String answer;

    public Answer() {

    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public Answer(int id, String answer) {
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
