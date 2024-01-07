package _01__JakartaEE_JDBC_Operations.dao.helper;

public class Query {

    public static String view = "SELECT * FROM school.employee;";
    public static String insert = "INSERT INTO school.employee ( id, name, email, salary ) VALUES ( ?, ?, ?, ? );";
    public static String updateId = "UPDATE school.employee SET id = ? WHERE id = ?;";
    public static String updateName = "UPDATE school.employee SET name = ? WHERE id = ?;";
    public static String updateEmail = "UPDATE school.employee SET email = ? WHERE id = ?;";
    public static String updateSalary = "UPDATE school.employee SET salary = ? WHERE id = ?;";
    public static String delete = "DELETE FROM school.employee WHERE id = ?;";

}
