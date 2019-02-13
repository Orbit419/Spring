package mate.academy.springdemo.service.impl;

import mate.academy.springdemo.model.User;
import mate.academy.springdemo.repository.UserRepository;
import mate.academy.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
    public User findByUserName(String userName) {
        return repository.findByUserName(userName);
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteByUserName(String userName) {
        repository.deleteByUserName(userName);
    }

    @Override
    public void update(User user) {
        repository.save(user);
    }

    @Override
    public boolean existsByUserName(String userName) {
        return repository.existsByUserName(userName);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public boolean changeRole(Long id, String role) {
        User user = repository.findById(id);
        user.setRole(role.toUpperCase());
        repository.save(user);
        return true;
    }
}
