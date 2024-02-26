package _02__Spring_JDBC_Operations._01__CRUD_Operations.beans;

import org.springframework.stereotype.Component;

@Component("student")
public class Student {

    private int id;
    private String name;
    private String course;

    public Student() {

    }

    public Student(String name, String course) {
        setName(name);
        setCourse(course);
    }

    public Student(int id, String name, String course) {
        setId(id);
        setName(name);
        setCourse(course);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
