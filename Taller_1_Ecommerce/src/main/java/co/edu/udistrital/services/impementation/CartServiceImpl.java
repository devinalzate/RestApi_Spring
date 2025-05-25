package co.edu.udistrital.services.impementation;

import co.edu.udistrital.data.CartDTO;
import co.edu.udistrital.services.IRestServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@Service
public class CartServiceImpl implements IRestServices<CartDTO> {

    private final RestTemplate restTemplate;

    @Override
    public List<CartDTO> getAll() {
        CartDTO[] cart = restTemplate.getForObject("/carts", CartDTO[].class);
        return List.of(cart);
    }

    @Override
    public CartDTO AddNew(CartDTO cartDTO) {
        return  restTemplate.postForObject("/carts", cartDTO, CartDTO.class);
    }

    @Override
    public CartDTO getById(@PathVariable int id) {
        CartDTO cart = restTemplate.getForObject("/carts/{id}", CartDTO.class, id);
        return cart;
    }

    @Override
    public CartDTO Update(@PathVariable int id, CartDTO cartDTO) {
        return restTemplate.postForObject("/carts/{id}", cartDTO, CartDTO.class);
    }

    @Override
    public void Delete(@PathVariable int id) {
        restTemplate.delete("/carts/{id}", id);
    }
}
