package _01__Lombok;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class TestUserA {

    private int id;
    private String name;
    private String email;
    private String password;

}
