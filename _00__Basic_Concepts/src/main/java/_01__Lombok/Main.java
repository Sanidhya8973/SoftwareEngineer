package _01__Lombok;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        TestUserA tua = new TestUserA();
        tua.setId(1);
        tua.setName("user");
        tua.setEmail("user@mail.com");
        tua.setPassword("password");
    }

}
