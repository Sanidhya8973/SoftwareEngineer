package _0__Hibernate._02__Hibernate_Annotations.service;

import _0__Hibernate._02__Hibernate_Annotations.model.Employee;
import _0__Hibernate._02__Hibernate_Annotations.dao.EmployeeDao;

public class EmployeeService {

    public static void createEmployee(Employee employee) {
        EmployeeDao.createEmployee(employee);
    }

    public static void updateEmployee(Employee employee) {
        EmployeeDao.updateEmployee(employee);
    }

    public static void deleteEmployee(Employee employee) {
        EmployeeDao.deleteEmployee(employee);
    }

    public static void displayEmployee() {
        EmployeeDao.displayEmployee();
    }

}