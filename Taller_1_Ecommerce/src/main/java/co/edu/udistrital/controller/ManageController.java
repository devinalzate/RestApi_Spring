package co.edu.udistrital.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ManageController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("mensaje", "Este es el inicio de la vista");
        return "index";
    }
}
