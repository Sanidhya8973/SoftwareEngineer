package _02__Spring_JDBC_Operations._01__CRUD_Operations.dao.implementations;

import _02__Spring_JDBC_Operations._01__CRUD_Operations.beans.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperImplementation implements RowMapper<Student> {

    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt(1));
        student.setName(rs.getString(2));
        student.setCourse(rs.getString(3));

        // return new Student(rs.getInt(1), rs.getString(2), rs.getString(3)); // for "1 liner SENIOR SDE"
        return student;
    }

}
