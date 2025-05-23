package co.edu.udistrital.controller;

import co.edu.udistrital.data.CartDTO;
import co.edu.udistrital.data.UsersDTO;
import co.edu.udistrital.services.IRestServices;
import co.edu.udistrital.services.impementation.CartServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    private final IRestServices cartService;

    public CartController(@Qualifier("cartServiceImpl") IRestServices cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCarts() {
        return ResponseEntity.ok(cartService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCartById(@PathVariable int id) {
        return ResponseEntity.ok(cartService.getById(id));
    }

    @PostMapping
    public ResponseEntity<?> AddNewUser(CartDTO cartDTO) {
        return ResponseEntity.ok(cartService.AddNew(cartDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateUser(@PathVariable int id,CartDTO cartDTO) {
        return ResponseEntity.ok(cartService.Update(id, cartDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id) {
        cartService.Delete(id);
        return ResponseEntity.noContent().build();
    }
}
