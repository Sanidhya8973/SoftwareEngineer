package _02__Spring_JDBC_Operations._01__CRUD_Operations.dao.interfaces;

import _02__Spring_JDBC_Operations._01__CRUD_Operations.beans.Student;

public interface StudentDao {

    void getSingleObjectFromDB1(int id);

    void getSingleObjectFromDB2(int id);

    void getMultipleObjectsFromDB();

    void insert(Student student);

    void update(Student updateStudent, int oldId);

    void delete(int id);

}
