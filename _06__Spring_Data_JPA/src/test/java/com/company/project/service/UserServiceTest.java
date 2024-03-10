package com.company.project.service;

import java.util.List;

import com.company.project.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.company.project.entity.Role;
import com.company.project.entity.User;

@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	protected void test() {

		User u1 = new User();
		u1.setFirstName("first-name-1");
		u1.setLastName("last-name-1");
		u1.setEmail("email-1");
		u1.setPassword("password-1");

		User u2 = new User();
		u2.setFirstName("first-name-2");
		u2.setLastName("last-name-2");
		u2.setEmail("email-2");
		u2.setPassword("password-2");

		User u3 = new User();
		u3.setFirstName("first-name-3");
		u3.setLastName("last-name-3");
		u3.setEmail("email-3");
		u3.setPassword("password-3");

		User u4 = new User();
		u4.setFirstName("first-name-4");
		u4.setLastName("last-name-4");
		u4.setEmail("email-4");
		u4.setPassword("password-4");

		User u5 = new User();
		u5.setFirstName("first-name-5");
		u5.setLastName("last-name-5");
		u5.setEmail("email-5");
		u5.setPassword("password-5");

		Role r1 = new Role();
		r1.setName("ROLE_OWNER");
		r1.setUserList(List.of(u1));

		Role r2 = new Role();
		r2.setName("ROLE_ADMIN");
		r2.setUserList(List.of(u1, u2));

		Role r3 = new Role();
		r3.setName("ROLE_USER");
		r3.setUserList(List.of(u1, u2, u3, u4, u5));

		Role r4 = new Role();
		r4.setName("ROLE_CONSUMER");
		r4.setUserList(List.of(u3));

		Role r5 = new Role();
		r5.setName("ROLE_SUPPLIER");
		r5.setUserList(List.of(u4));

		u1.setRoleList(List.of(r1, r2, r3));
		u2.setRoleList(List.of(r2, r3));
		u3.setRoleList(List.of(r3, r4));
		u4.setRoleList(List.of(r3, r5));
		u5.setRoleList(List.of(r3));

		userRepository.saveAll(List.of(u1, u2, u3, u4, u5));
		// roleRepository.saveAll(List.of(r1, r2, r3, r4, r5));

	}

}
