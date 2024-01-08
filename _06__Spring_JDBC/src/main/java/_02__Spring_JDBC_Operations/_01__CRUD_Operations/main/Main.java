package _02__Spring_JDBC_Operations._01__CRUD_Operations.main;

import _02__Spring_JDBC_Operations._01__CRUD_Operations.config.ProjectConfig;
import _02__Spring_JDBC_Operations._01__CRUD_Operations.dao.implementations.StudentDaoImplementation;
import _02__Spring_JDBC_Operations._01__CRUD_Operations.dao.interfaces.StudentDao;
import _02__Spring_JDBC_Operations._01__CRUD_Operations.beans.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        StudentDao studentDao = context.getBean("studentDao", StudentDaoImplementation.class);
        Student student = new Student("student-1", "core-java");
        studentDao.insert(student);
        studentDao.getMultipleObjectsFromDB();
    }

}
