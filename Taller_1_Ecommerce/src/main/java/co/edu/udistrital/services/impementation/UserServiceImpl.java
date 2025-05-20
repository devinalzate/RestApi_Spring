package co.edu.udistrital.services.impementation;

import co.edu.udistrital.data.UsersDTO;
import co.edu.udistrital.services.IRestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IRestServices<UsersDTO> {

    private final RestTemplate restTemplate;

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
