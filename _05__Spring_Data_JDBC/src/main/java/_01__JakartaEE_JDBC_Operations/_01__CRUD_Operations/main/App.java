package _01__JakartaEE_JDBC_Operations._01__CRUD_Operations.main;

import _01__JakartaEE_JDBC_Operations._01__CRUD_Operations.model.Employee;
import _01__JakartaEE_JDBC_Operations._01__CRUD_Operations.dao.EmployeeDAO;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println(">>> EMPLOYEE MANAGEMENT SYSTEM <<<");
            System.out.println("------------------------------------------");
            System.out.println("> 1. CREATE, 2. READ, 3. UPDATE, 4. DELETE");
            System.out.println("------------------------------------------");
            System.out.print("> Enter Your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println("------------------------------------------");
            System.out.println();
            switch (choice) {
                case 1: {
                    System.out.println("------------------------------------------");
                    System.out.println(">> PLEASE ENTER THE EMPLOYEE DETAILS...");
                    System.out.println("------------------------------------------");
                    System.out.print(" > Enter Your ID : ");
                    String id = sc.nextLine();
                    System.out.print(" > Enter Your NAME : ");
                    String name = sc.nextLine();
                    System.out.print(" > Enter Your EMAIL : ");
                    String email = sc.nextLine();
                    System.out.print(" > Enter Your Salary : ");
                    String salary = sc.nextLine();
                    Employee employee = new Employee(id, name, email, salary);
                    EmployeeDAO.insert(employee);
                    break;
                }
                case 2: {
                    System.out.println("------------------------------------------");
                    System.out.println(">> VIEWING THE DATABASE...");
                    System.out.println("------------------------------------------");
                    // EmployeeDao.view();
                    System.out.println("------------------------------");
                    System.out.println("| ID | NAME | EMAIL | SALARY |");
                    System.out.println("------------------------------");
                    ArrayList<Employee> employeeList = EmployeeDAO.viewList();
                    for (Employee employee : employeeList) {
                        System.out.println("| " + employee.getId() + " | " + employee.getName() + " | " + employee.getEmail() + " | " + employee.getSalary() + " |");
                    }
                    break;
                }
                case 3: {
                    System.out.println("------------------------------------------");
                    System.out.println(">> UPDATE THE EMPLOYEE INFORMATION...");
                    System.out.println("------------------------------------------");
                    System.out.println("> 1. ID, 2. NAME, 3. EMAIL, 4. SALARY ");
                    System.out.println("------------------------------------------");
                    System.out.print(" > ENTER YOUR ID : ");
                    String id = sc.nextLine();
                    System.out.print(" > ENTER YOUR CHOICE: ");
                    int updateChoice = sc.nextInt();
                    sc.nextLine();
                    switch (updateChoice) {
                        case 1: {
                            System.out.println("------------------------------------------");
                            System.out.print(" > Enter NEW_ID: ");
                            String newId = sc.nextLine();
                            System.out.println("------------------------------------------");
                            EmployeeDAO.updateId(newId, id);
                            System.out.println("------------------------------------------");
                            break;
                        }
                        case 2: {
                            System.out.println("------------------------------------------");
                            System.out.print(" > Enter NEW_NAME: ");
                            String newName = sc.nextLine();
                            System.out.println("------------------------------------------");
                            EmployeeDAO.updateName(newName, id);
                            System.out.println("------------------------------------------");
                            break;
                        }
                        case 3: {
                            System.out.println("------------------------------------------");
                            System.out.print(" > Enter NEW_EMAIL: ");
                            String newEmail = sc.nextLine();
                            System.out.println("------------------------------------------");
                            EmployeeDAO.updateEmail(newEmail, id);
                            System.out.println("------------------------------------------");
                            break;
                        }
                        case 4: {
                            System.out.println("------------------------------------------");
                            System.out.print(" > Enter NEW_SALARY: ");
                            String newSalary = sc.nextLine();
                            System.out.println("------------------------------------------");
                            EmployeeDAO.updateSalary(newSalary, id);
                            System.out.println("------------------------------------------");
                            break;
                        }
                        default: {
                            System.out.println("------------------------------------------");
                            System.out.println(" > INVALID INPUT, PLEASE TRY AGAIN...");
                            System.out.println("------------------------------------------");
                            break;
                        }
                    }
                    break;
                }
                case 4: {
                    System.out.println("------------------------------------------");
                    System.out.println(">> DELETE AN EMPLOYEE...");
                    System.out.println("------------------------------------------");
                    System.out.print(" > Enter Employee ID: ");
                    String id = sc.nextLine();
                    EmployeeDAO.delete(id);
                    break;
                }
                default: {
                    flag = false;
                    System.out.println("------------------------------------------");
                    System.out.println("> SUCCESSFULLY EXITED THE SYSTEM...");
                    System.out.println("------------------------------------------");
                    break;
                }
            }
        }
        sc.close();
    }

}