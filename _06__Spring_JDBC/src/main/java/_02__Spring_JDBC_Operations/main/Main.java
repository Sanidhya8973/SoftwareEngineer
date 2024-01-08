package _02__Spring_JDBC_Operations.main;

import _02__Spring_JDBC_Operations.dao.implementations.StudentDAOImplementation;
import _02__Spring_JDBC_Operations.dao.interfaces.StudentDAO;
import _02__Spring_JDBC_Operations.beans.Student;

public class Main {

    public static void main(String[] args) {
        String name;
        String course;
        Student student1 = new Student(name = "sanidhya-problem", course = "core java");
        StudentDAO studentDAO1 = new StudentDAOImplementation();
        studentDAO1.update(student1); // create / insert / update / deletel
    }

}
