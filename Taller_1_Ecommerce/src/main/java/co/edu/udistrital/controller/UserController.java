package co.edu.udistrital.controller;

import co.edu.udistrital.data.UsersDTO;
import co.edu.udistrital.services.IRestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    @Qualifier("userServiceImpl")
    private final IRestServices<UsersDTO> userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> AddNewUser(UsersDTO usersDTO) {
        return ResponseEntity.ok(userService.AddNew(usersDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateUser(@PathVariable int id, UsersDTO usersDTO) {
        return ResponseEntity.ok(userService.Update(id,usersDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id) {
        userService.Delete(id);
        return ResponseEntity.noContent().build();
    }

}
