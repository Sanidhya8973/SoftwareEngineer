package _0__Hibernate._03__Relationship_Mapping_Annotations._02__OneToMany.unidirectional_flow.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity(name = "unidirectional_question")
@Table(name = "unidirectional_question_table")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;

    @Column(name = "question_que")
    private String question;

    @OneToMany
    @JoinColumn(name = "fk_question_id", referencedColumnName = "question_id")
    private List<Answer> answer = new ArrayList<>();

    public Question() {

    }

    public Question(String question) {
        this.question = question;
    }

    public Question(String question, List<Answer> answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question(int id, List<Answer> answer) {
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

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question -> [ id=" + id + ", question=" + question + ", answer=" + answer + " ]";
    }

}