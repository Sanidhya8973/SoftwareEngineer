package _0__Hibernate._03__Relationship_Mapping_Annotations._01__OneToOne.bidirectional_flow.model;

import jakarta.persistence.*;

@Entity(name = "bidirectional_question")
@Table(name = "bidirectional_question_table")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;

    @Column(name = "question_que")
    private String question;

    @OneToOne
    @JoinColumn(name = "fk_answer_id")
    private Answer answer;

    public Question() {

    }

    public Question(String question) {
        this.question = question;
    }

    public Question(String question, Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question(int id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
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

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question -> [ id=" + id + ", question=" + question + ", answer=" + answer + " ]";
    }

}

