package mate.academy.springdemo.service;

import mate.academy.springdemo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User create(User user);

    User findByUserName(String userName);

    User findById(Long id);

    void deleteById(Long id);

    void deleteByUserName(String userName);

    void update(User user);

    boolean existsByUserName(String userName);

    List<User> getAll();

    boolean changeRole(Long id, String role);
}
