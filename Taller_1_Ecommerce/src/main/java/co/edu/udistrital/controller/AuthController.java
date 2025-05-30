package co.edu.udistrital.controller;

import co.edu.udistrital.data.*;
import co.edu.udistrital.services.IRestServices;
import co.edu.udistrital.services.impementation.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @Qualifier("authServiceImpl")
    private final AuthServiceImpl authService;
    private final IRestServices<UsersDTO> userServices;
    private final IRestServices<CartDTO> cartServices;
    private final IRestServices<ProductDTO> productServices;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("authRequest", new AuthRequest());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AuthRequest authRequest, Model model) {
        try {
            AuthResponse response = authService.login(authRequest.getUsername(), authRequest.getPassword());
//            if(response != null) {
//                model.addAttribute("productosUsuarioLogeado", authRequest.getCart());
//            }
            // Puedes guardar info del usuario en sesión si es necesario
            // session.setAttribute("token", response.getToken());
            UsersDTO[] users = userServices.getAll().toArray(new UsersDTO[0]);
            CartDTO[] carts = cartServices.getAll().toArray(new CartDTO[0]);
            ProductDTO[] productos = productServices.getAll().toArray(new ProductDTO[0]);
            ArrayList<ProductDTO> productosEnviados = new ArrayList<>();
            for(UsersDTO user : users){
                if (user.getUsername().equals(authRequest.getUsername()) &&
                        user.getPassword().equals(authRequest.getPassword())) {
                    for(CartDTO cart : carts){
                        if (cart.getUserId() == user.getId()){
                            model.addAttribute("userLoged", user);
                            model.addAttribute("products", cart.getProducts());
                            for(ProductDTO product : productos){
                                for(ProductCartDTO productLog : cart.getProducts()){
                                    if(product.getId() == productLog.getProductId()){
                                        productosEnviados.add(product);
                                    }
                                }
                            }
                            model.addAttribute("productsEnviados", productosEnviados);
                        }
                    }
                }
            }

            model.addAttribute("toker", response); // opcional
            return "loged"; // o la página principal tras login
        } catch (Exception e) {
            e.printStackTrace();

            model.addAttribute("error", "Usuario o contraseña inválidos");
            return "login";
        }
    }
}
