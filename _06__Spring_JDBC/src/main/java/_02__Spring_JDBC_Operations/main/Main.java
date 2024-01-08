package _02__Spring_JDBC_Operations.main;

import _02__Spring_JDBC_Operations.dao.implementations.StudentDAOImplementation;
import _02__Spring_JDBC_Operations.dao.interfaces.StudentDAO;
import _02__Spring_JDBC_Operations.beans.Student;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("sanidhya", "core java");
        StudentDAO studentDAO1 = new StudentDAOImplementation();
        studentDAO1.update(student1); // create / insert / update / deletel
    }

}
