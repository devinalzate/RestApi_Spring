package co.edu.udistrital.services.impementation;

import co.edu.udistrital.data.ProductDTO;
import co.edu.udistrital.services.IRestServices;

import java.util.List;

public class ProductServiceImpl implements IRestServices<ProductDTO> {

    @Override
    public List<ProductDTO> getAll() {
        return List.of();
    }

    @Override
    public ProductDTO AddNew(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO getById(int id) {
        return null;
    }

    @Override
    public ProductDTO Update(int id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public void Delete(int id) {

    }
}
