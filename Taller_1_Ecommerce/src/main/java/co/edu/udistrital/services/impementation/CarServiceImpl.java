package co.edu.udistrital.services.impementation;

import co.edu.udistrital.data.CartDTO;
import co.edu.udistrital.services.IRestServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@Service
public class CarServiceImpl implements IRestServices<CartDTO> {

    private final RestTemplate restTemplate;

    @Override
    public List<CartDTO> getAll() {
        CartDTO[] cart = restTemplate.getForObject("/carts", CartDTO[].class);
        return List.of(cart);
    }

    @Override
    public CartDTO AddNew(CartDTO o) {
        return null;
    }

    @Override
    public CartDTO getById(int id) {
        return null;
    }

    @Override
    public CartDTO Update(int id, CartDTO o) {
        return null;
    }

    @Override
    public void Delete(int id) {

    }
}
