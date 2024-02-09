package _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.bidirectional_flow.model;

import jakarta.persistence.*;

@Entity(name = "bidirectional_answer")
@Table(name = "bidirectional_answer_table")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private int id;

    @Column(name = "answer_ans")
    private String answer;

    @OneToOne(mappedBy = "answer")
    private Question question;

    public Answer() {

    }

    public Answer(String answer) {
        this.answer = answer;
    }

    public Answer(String answer, Question question) {
        this.answer = answer;
        this.question = question;
    }

    public Answer(int id, String answer, Question question) {
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer -> [ id=" + id + ", answer=" + answer + " ]";
    }

}
