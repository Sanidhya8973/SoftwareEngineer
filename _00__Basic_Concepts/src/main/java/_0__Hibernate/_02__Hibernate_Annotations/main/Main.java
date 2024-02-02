package _0__Hibernate._02__Hibernate_Annotations.main;

import _0__Hibernate._02__Hibernate_Annotations.model.Address;
import _0__Hibernate._02__Hibernate_Annotations.model.Certificate;
import _0__Hibernate._02__Hibernate_Annotations.model.Employee;
import _0__Hibernate._02__Hibernate_Annotations.model.Gender;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
       // business logic
    }

    public static Employee setEmployeeData() {

        Certificate certificate = new Certificate();
        certificate.setName("Bachelors Of Technology");
        certificate.setSignature("$X#IU%20%24!*");
        certificate.setStartDate(LocalDate.of(2020, 6, 1));
        certificate.setEndDate(LocalDate.of(2024, 5, 30));

        Address homeAddress = new Address("home", "X-69", "XXX", "XXXX", "XXXX", 6969, "XXXXX", "XXXXX", "XXXXXX");
        Address officeAddress = new Address("office", "x-88", "YYY", "YYYY", "YYYY", 8888, "YYYYY", "YYYYY", "YYYYYY");
        List<Address> addressList = new ArrayList<Address>();
        addressList.add(homeAddress);
        addressList.add(officeAddress);

        Employee employee = new Employee();
        employee.setName("employee-1");
        employee.setGender(Gender.MALE);
        employee.setEmail("emp1@gmail.com");
        employee.setCertificate(certificate);
        employee.setJoiningDateTime(LocalDateTime.now());
        employee.setToken("abcX69Xfd88199sfywddf");
        employee.setAddressList(addressList);
        employee.setSalary(50000);
        employee.setPassword("$^xyz@abc#");
        // storing image
        // employee.setImage(null);
        try {
            FileInputStream fis = new FileInputStream("com/company/database/user_profile.png");
            byte[] data = new byte[fis.available()];
            fis.read(data);
            employee.setImage(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return employee;
    }

}
