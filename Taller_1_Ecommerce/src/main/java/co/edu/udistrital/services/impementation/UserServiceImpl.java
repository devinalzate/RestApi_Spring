package co.edu.udistrital.services.impementation;

import co.edu.udistrital.data.UsersDTO;
import co.edu.udistrital.services.IRestServices;

import java.util.List;

public class UserServiceImpl implements IRestServices<UsersDTO> {

    @Override
    public List<UsersDTO> getAll() {
        return List.of();
    }

    @Override
    public UsersDTO AddNew(UsersDTO usersDTO) {
        return null;
    }

    @Override
    public UsersDTO getById(int id) {
        return null;
    }

    @Override
    public UsersDTO Update(int id, UsersDTO usersDTO) {
        return null;
    }

    @Override
    public void Delete(int id) {

    }
}
