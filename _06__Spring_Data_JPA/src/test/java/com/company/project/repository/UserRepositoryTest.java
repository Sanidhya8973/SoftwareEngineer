package com.company.project.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {

    @Test
    @DisplayName(value = "givenData_whenOperation_thenReturnData")
    public void given_when_then() {
        // given - precondition or setup
        // when  - action or the behavior that we are going to test
        // then  - verify the output
    }

}
