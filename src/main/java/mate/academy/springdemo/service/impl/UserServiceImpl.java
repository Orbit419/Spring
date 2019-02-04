package mate.academy.springdemo.service.impl;

import mate.academy.springdemo.model.User;
import mate.academy.springdemo.repository.UserRepository;
import mate.academy.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User findByLogin(String login) {
        return repository.findByLogin(login);
    }

    @Override
    public void deleteByLogin(String login) {
        repository.deleteByLogin(login);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public boolean existsByLogin(String login) {
        return repository.existsByLogin(login);
    }
}
