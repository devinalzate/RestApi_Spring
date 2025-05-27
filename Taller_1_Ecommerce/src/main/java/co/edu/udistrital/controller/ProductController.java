package co.edu.udistrital.controller;

import co.edu.udistrital.data.ProductDTO;
import co.edu.udistrital.services.impementation.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "products";
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id) {
        return (ProductDTO) productService.getById(id);

    }
}