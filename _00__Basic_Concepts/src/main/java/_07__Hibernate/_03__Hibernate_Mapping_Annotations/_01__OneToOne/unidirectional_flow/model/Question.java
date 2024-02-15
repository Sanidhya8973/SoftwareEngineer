package _07__Hibernate._03__Hibernate_Mapping_Annotations._01__OneToOne.unidirectional_flow.model;

import jakarta.persistence.*;

@Entity(name = "entity_question")
@Table(name = "table_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_question_id")
    @SequenceGenerator(name = "generator_question_id", sequenceName = "sequence_question_id", allocationSize = 1)
    @Column(name = "question_id")
    private int id;

    @Column(name = "question_que")
    private String question;

    @OneToOne(cascade = CascadeType.ALL)
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
