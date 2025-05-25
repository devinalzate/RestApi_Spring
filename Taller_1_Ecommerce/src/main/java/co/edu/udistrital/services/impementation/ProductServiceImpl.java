package co.edu.udistrital.services.impementation;

import co.edu.udistrital.data.ProductDTO;
import co.edu.udistrital.services.IRestServices;
import co.edu.udistrital.data.ProductDTO;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
public class ProductServiceImpl implements IRestServices<ProductDTO> {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String BASE_URL = "https://fakestoreapi.com/products";

    @Override
    public List<ProductDTO> getAll() {
        ProductDTO[] products = restTemplate.getForObject(BASE_URL, ProductDTO[].class);
        return Arrays.asList(products);
    }

    @Override
    public ProductDTO AddNew(ProductDTO product) {
        return restTemplate.postForObject(BASE_URL, product, ProductDTO.class);
    }

    @Override
    public ProductDTO getById(int id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, ProductDTO.class);
    }

    @Override
    public ProductDTO Update(int id, ProductDTO product) {
        restTemplate.put(BASE_URL + "/" + id, product);
        return getById(id);
    }

    @Override
    public void Delete(int id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }
}