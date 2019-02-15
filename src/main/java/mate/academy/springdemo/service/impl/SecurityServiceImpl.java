package mate.academy.springdemo.service.impl;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.model.User;
import mate.academy.springdemo.model.userDto.UserRegistration;
import mate.academy.springdemo.service.SecurityService;
import mate.academy.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean doRegistration(UserRegistration userRegistration) {
        User user = User.builder()
                .userName(userRegistration.getUserName())
                .password(passwordEncoder.encode(userRegistration.getPassword()))
                .mail(userRegistration.getMail())
                .build();
        if(userService.existsByUserName(user.getUserName())) {
            log.info("User with the same username already exist!");
            return false;
        } else {
            userService.create(user);
            return true;
        }
    }

    @Override
    public boolean changeRole(Long id, String role) {
        return userService.changeRole(id, role);
    }
}
