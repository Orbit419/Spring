package mate.academy.springdemo.service;

import mate.academy.springdemo.model.userDto.UserLogIn;
import org.springframework.stereotype.Service;

@Service
public interface SecurityService {
    boolean doLogin(UserLogIn userLogIn);
}
