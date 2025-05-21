package co.edu.udistrital.services.impementation;

import co.edu.udistrital.data.CartDTO;
import co.edu.udistrital.services.IRestServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@AllArgsConstructor
@Service
public class CarServiceImpl implements IRestServices {

    private final RestTemplate restTemplate;

    @Override
    public List<CartDTO> getAll() {
        CartDTO[] cart = restTemplate.getForObject("/carts", CartDTO[].class);
        return List.of(cart);
    }

    @Override
    public Object AddNew(Object o) {
        return null;
    }

    @Override
    public Object getById(int id) {
        return null;
    }

    @Override
    public Object Update(int id, Object o) {
        return null;
    }

    @Override
    public void Delete(int id) {

    }
}
