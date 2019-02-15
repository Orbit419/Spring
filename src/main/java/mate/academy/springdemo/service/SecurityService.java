package mate.academy.springdemo.service;

import mate.academy.springdemo.model.userDto.UserLogIn;
import mate.academy.springdemo.model.userDto.UserRegistration;
import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
    boolean doRegistration(UserRegistration userRegistration);

    boolean changeRole(Long id, String role);
}
