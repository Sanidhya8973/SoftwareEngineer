package _0__Hibernate._04__company.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import _0__Hibernate._01__config.HibernateConfig;
import _0__Hibernate._04__company.model.Employee;

public class EmployeeDao {

    public static void createEmployee(Employee employee) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(employee);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    public static void updateEmployee(Employee newEmployeeData) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        Employee updateEmployee = session.get(Employee.class, newEmployeeData.getId());
        updateEmployee.setName(newEmployeeData.getName());
        updateEmployee.setGender(newEmployeeData.getGender());
        updateEmployee.setEmail(newEmployeeData.getEmail());

        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(updateEmployee);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    public static void deleteEmployee(Employee employee) {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        Employee deleteEmployee = session.get(Employee.class, employee.getId());

        Transaction transaction = session.beginTransaction();
        session.delete(deleteEmployee);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }

    public static void displayEmployee() {
        SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        Session session = sessionFactory.openSession();

        // single user
        try {
            Employee employee = session.get(Employee.class, 1); // session.load(Employee.class, index);
            System.out.println(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // multiple users
        List<Employee> employees = session.createQuery("from employee", Employee.class).list();
        employees.forEach(e -> System.out.println(e));

        session.close();
        sessionFactory.close();
    }

}