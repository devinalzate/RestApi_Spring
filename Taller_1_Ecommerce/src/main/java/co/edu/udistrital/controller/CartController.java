package co.edu.udistrital.controller;

import co.edu.udistrital.services.IRestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    private final IRestServices cartService;

    public CartController(@Qualifier("carServiceImpl") IRestServices cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCarts() {
        return ResponseEntity.ok(cartService.getAll());
    }
}
