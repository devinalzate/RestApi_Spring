package co.edu.udistrital.persistence.repository;

import co.edu.udistrital.persistence.entity.CartEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository {
    CartEntity saveCar(CartEntity car) {
        return null;
    }

    CartEntity findCarById(int id) {
        return null;
    }

    CartEntity updateCar(CartEntity car) {
        return null;
    }

    void deleteCar(int id) {
        // Implementation to delete a car by ID
    }

    List<CartEntity> findAllCars() {
        return null;
    }
}
