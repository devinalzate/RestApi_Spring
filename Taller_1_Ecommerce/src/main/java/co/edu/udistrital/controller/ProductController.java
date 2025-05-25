package co.edu.udistrital.controller;

import co.edu.udistrital.data.ProductDTO;
import co.edu.udistrital.services.impementation.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id) {
        return (ProductDTO) productService.getById(id);

    }
}