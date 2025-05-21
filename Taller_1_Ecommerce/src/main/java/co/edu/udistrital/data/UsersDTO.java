package co.edu.udistrital.data;

import lombok.Data;

@Data
public class UsersDTO {
    private int id;
    private String username;
    private String email;
    private String password;
}
