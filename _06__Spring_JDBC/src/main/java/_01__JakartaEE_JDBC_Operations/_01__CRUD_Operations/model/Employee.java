package _01__JakartaEE_JDBC_Operations._01__CRUD_Operations.model;

public class Employee {

    private String id;
    private String name;
    private String email;
    private String salary;

    public Employee(String id, String name, String email, String salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSalary() {
        return salary;
    }

    public String toString() {
        return "EMPLOYEE -> [ ID: " + id + ", NAME: " + name + ", EMAIL: " + email + ", SALARY: " + salary + " ]";
    }

}
