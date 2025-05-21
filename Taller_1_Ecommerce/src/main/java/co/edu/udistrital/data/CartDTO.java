package co.edu.udistrital.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private int id;
    private int userId;
    private String date;
    private ArrayList<ProductDTO> products;
}
