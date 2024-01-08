package _02__Spring_JDBC_Operations.dao.implementations;

import _02__Spring_JDBC_Operations.config.ProjectConfig;
import _02__Spring_JDBC_Operations.dao.interfaces.StudentDAO;
import _02__Spring_JDBC_Operations.beans.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDAOImplementation implements StudentDAO {

    @Override
    public void update(Student student) {
        String sql = "INSERT INTO student ( name, course ) VALUES ( ?, ? );";
        Object[] arg = {student.getName(), student.getCourse()};
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        int rowsUpdated = jdbcTemplate.update(sql, arg);
        System.out.println("> Database Status: " + rowsUpdated + " row updated");
    }

}
