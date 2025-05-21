package co.edu.udistrital.persistence.entity;

import co.edu.udistrital.data.ProductDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class CartEntity implements Serializable {
    private int id;
    private int userId;
    private ArrayList<ProductDTO> products;
}
