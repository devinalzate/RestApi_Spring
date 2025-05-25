package co.edu.udistrital.controller;

import co.edu.udistrital.data.AuthRequest;
import co.edu.udistrital.data.AuthResponse;
import co.edu.udistrital.data.UsersDTO;
<<<<<<< Updated upstream
import co.edu.udistrital.services.IRestServices;
=======
>>>>>>> Stashed changes
import co.edu.udistrital.services.impementation.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Qualifier("authServiceImpl")
    private final AuthServiceImpl authService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("authRequest", new AuthRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute UsersDTO authRequest, Model model) {
        try {
            AuthResponse response = authService.login(authRequest.getUsername(), authRequest.getPassword());
<<<<<<< Updated upstream
            if(response != null) {
=======

            if(response != null) {
                model.addAttribute("prodcutosUsuarioLogeado", authRequest.getCart().getProducts());
>>>>>>> Stashed changes
            }
            // Puedes guardar info del usuario en sesión si es necesario
            // session.setAttribute("token", response.getToken());

            model.addAttribute("userLoged", response); // opcional
            return "/index"; // o la página principal tras login
        } catch (Exception e) {
            e.printStackTrace();

            model.addAttribute("error", "Usuario o contraseña inválidos");
            return "login";
        }
    }
}
