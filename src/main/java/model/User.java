package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class User {
    private int userId;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
}
