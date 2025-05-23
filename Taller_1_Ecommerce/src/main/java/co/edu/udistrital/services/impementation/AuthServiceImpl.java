package co.edu.udistrital.services.impementation;

import co.edu.udistrital.data.AuthRequest;
import co.edu.udistrital.data.AuthResponse;
import co.edu.udistrital.services.IRestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl {
    private final RestTemplate restTemplate;

    public AuthResponse login(String username, String password) {
        AuthRequest request = new AuthRequest();
        request.setUsername(username);
        request.setPassword(password);
        try {
            return restTemplate.postForObject("/auth/login", request, AuthResponse.class);
        } catch (HttpClientErrorException.Unauthorized ex) {
            // Captura el error 401 para manejarlo
            throw new RuntimeException("Usuario o contraseña incorrectos");
        }
    }
}
