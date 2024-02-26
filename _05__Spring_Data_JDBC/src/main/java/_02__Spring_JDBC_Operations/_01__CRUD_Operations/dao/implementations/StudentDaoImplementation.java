package _02__Spring_JDBC_Operations._01__CRUD_Operations.dao.implementations;

import _02__Spring_JDBC_Operations._01__CRUD_Operations.dao.interfaces.StudentDao;
import _02__Spring_JDBC_Operations._01__CRUD_Operations.beans.Student;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("studentDao")
public class StudentDaoImplementation implements StudentDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDaoImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insert(Student student) {
        // solved using @Autowired annotation
        // var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        // JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
        String query = "INSERT INTO school.student ( name, course ) VALUES ( ?, ? ) ;";
        Object[] arg = {student.getName(), student.getCourse()};
        int rowUpdates = jdbcTemplate.update(query, arg);
        System.out.println("> DATABASE STATUS: " + rowUpdates + " row updated");
    }

    public void update(Student updateStudent, int oldId) {
        String query = "UPDATE school.student SET name=(?) , course=(?) WHERE id=(?) ;";
        Object[] arg = {updateStudent.getName(), updateStudent.getCourse(), oldId};
        int rowUpdates = jdbcTemplate.update(query, arg);
        System.out.println("> DATABASE STATUS: " + rowUpdates + " row updated");
    }

    public void delete(int id) {
        String query = "DELETE FROM school.student WHERE id=(?) ;";
        int rowUpdates = jdbcTemplate.update(query, id);
        System.out.println("> DATABASE STATUS: " + rowUpdates + " row updated");
    }

    public void getMultipleObjectsFromDB() {
        String query = "SELECT * FROM school.student ;";
        RowMapper<Student> rowMapper = new RowMapperImplementation();
        List<Student> studentList = jdbcTemplate.query(query, rowMapper);
        for (Student student : studentList) {
            System.out.println("Student {\n   id: " + student.getId() + ",\n   name: " + student.getName() + ",\n   course: " + student.getCourse() + ",\n};");
        }
    }

    // Method-1: uses another class which implements RowMapper<> but it good for multiple invocation
    public void getSingleObjectFromDB1(int id) {
        String query = "SELECT * FROM school.student WHERE id=(?) ;";
        RowMapper<Student> rowMapper = new RowMapperImplementation();
        Student student = jdbcTemplate.queryForObject(query, rowMapper, id);
        System.out.println("Student {\n   id: " + student.getId() + ",\n   name: " + student.getName() + ",\n   course: " + student.getCourse() + ",\n};");
    }

    // Method-2: Anonymous Class implementation
    public void getSingleObjectFromDB2(int id) {
        String query = "SELECT * FROM school.student WHERE id=(?) ;";
        Student student = jdbcTemplate.queryForObject(query, new RowMapper<Student>() {
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Student(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        }, id);
        System.out.println("Student {\n   id: " + student.getId() + ",\n   name: " + student.getName() + ",\n   course: " + student.getCourse() + ",\n};");
    }

}