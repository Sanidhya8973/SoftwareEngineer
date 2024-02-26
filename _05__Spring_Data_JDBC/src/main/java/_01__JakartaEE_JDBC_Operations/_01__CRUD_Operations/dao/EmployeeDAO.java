package _01__JakartaEE_JDBC_Operations._01__CRUD_Operations.dao;

import _01__JakartaEE_JDBC_Operations._01__CRUD_Operations.model.Employee;
import _01__JakartaEE_JDBC_Operations._01__CRUD_Operations.dao.helper.ConnectionProvider;
import _01__JakartaEE_JDBC_Operations._01__CRUD_Operations.dao.helper.Query;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO extends Query {

    public static void insert(Employee employee) {
        try {
            Connection con = ConnectionProvider.connectDB();
            String query = Query.insert;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, employee.getId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getEmail());
            ps.setString(4, employee.getSalary());
            int updated = ps.executeUpdate();
            System.out.println("\n> ROWS UPDATED: " + updated + ", WHERE DETAILS ARE: " + employee.toString());
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void view() { // Easy...
        try {
            Connection con = ConnectionProvider.connectDB();
            String query = Query.view;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("------------------------------");
            System.out.println("| ID | NAME | EMAIL | SALARY |");
            System.out.println("------------------------------");
            while (rs.next()) {
                System.out.println("| " + rs.getString("id") + " | " + rs.getString("name") + " | "
                        + rs.getString("email") + " | " + rs.getString("salary") + " |");
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Employee> viewList() { // Hard...
        ArrayList<Employee> employeeList = new ArrayList<>();
        try {
            Connection con = ConnectionProvider.connectDB();
            String query = Query.view;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String salary = rs.getString("salary");
                Employee employee = new Employee(id, name, email, salary);
                employeeList.add(employee);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public static void updateId(String newId, String id) {
        try {
            Connection con = ConnectionProvider.connectDB();
            String query = Query.updateId;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newId);
            ps.setString(2, id);
            ps.executeUpdate();
            System.out.println("> SUCCESSFULLY UPDATED...");
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateName(String newName, String id) {
        try {
            Connection con = ConnectionProvider.connectDB();
            String query = Query.updateName;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newName);
            ps.setString(2, id);
            ps.executeUpdate();
            System.out.println("> SUCCESSFULLY UPDATED...");
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateEmail(String newEmail, String id) {
        try {
            Connection con = ConnectionProvider.connectDB();
            String query = Query.updateEmail;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newEmail);
            ps.setString(2, id);
            ps.executeUpdate();
            System.out.println("> SUCCESSFULLY UPDATED...");
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateSalary(String newSalary, String id) {
        try {
            Connection con = ConnectionProvider.connectDB();
            String query = Query.updateSalary;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, newSalary);
            ps.setString(2, id);
            ps.executeUpdate();
            System.out.println("> SUCCESSFULLY UPDATED...");
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(String id) {
        try {
            Connection con = ConnectionProvider.connectDB();
            String query = Query.delete;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, id);
            int updated = ps.executeUpdate();
            System.out.println("\n> USER DELETED: " + updated);
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

