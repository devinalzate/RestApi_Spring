package co.edu.udistrital.services.impementation;

import co.edu.udistrital.data.UsersDTO;
import co.edu.udistrital.services.IRestServices;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IRestServices<UsersDTO> {

    private final RestTemplate restTemplate;

    @Override
    public List<UsersDTO> getAll() {
        UsersDTO[] usersDTO = restTemplate.getForObject("/users", UsersDTO[].class);
        return List.of(usersDTO);
    }

    @Override
    public UsersDTO AddNew(UsersDTO usersDTO) {
        return restTemplate.postForObject("/users", usersDTO, UsersDTO.class);
    }

    @Override
    public UsersDTO getById(int id) {
        UsersDTO findUser = restTemplate.getForObject("/users/" + id, UsersDTO.class, id);
        return findUser;
    }

    @Override
    public UsersDTO Update(int id, UsersDTO usersDTO) {
        return restTemplate.postForObject("/users/" + id, usersDTO, UsersDTO.class);
    }

    @Override
    public void Delete(int id) {
        restTemplate.delete("/users/" + id);
    }
}
