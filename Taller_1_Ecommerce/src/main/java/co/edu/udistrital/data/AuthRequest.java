package co.edu.udistrital.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AuthRequest {
    private String username;
    private String password;
}
