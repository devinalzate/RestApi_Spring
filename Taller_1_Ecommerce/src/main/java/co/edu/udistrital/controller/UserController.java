package co.edu.udistrital.controller;

import co.edu.udistrital.data.UsersDTO;
import co.edu.udistrital.services.IRestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    @Qualifier("userServiceImpl")
    private final IRestServices<UsersDTO> userService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/getAll")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "index";
    }

    @PostMapping
    public ResponseEntity<?> AddNewUser(UsersDTO usersDTO) {
        return ResponseEntity.ok(userService.AddNew(usersDTO));
    }

    @GetMapping("/buscar")
    public String getUserById(@RequestParam int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "index";
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
