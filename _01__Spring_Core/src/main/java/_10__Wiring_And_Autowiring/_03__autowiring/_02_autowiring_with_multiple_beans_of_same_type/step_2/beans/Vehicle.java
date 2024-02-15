package _10__Wiring_And_Autowiring._03__autowiring._02_autowiring_with_multiple_beans_of_same_type.step_2.beans;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
