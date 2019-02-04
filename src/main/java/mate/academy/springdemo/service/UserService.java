package mate.academy.springdemo.service;

import mate.academy.springdemo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User create(User user);

    User findByLogin(String login);

    void deleteByLogin(String login);

    void update(User user);

    boolean existsByLogin(String login);
}
