package mate.academy.springdemo.service.impl;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.model.User;
import mate.academy.springdemo.model.userDto.UserLogIn;
import mate.academy.springdemo.model.userDto.UserRegistration;
import mate.academy.springdemo.service.SecurityService;
import mate.academy.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public boolean doLogin(UserLogIn userLogIn) {
        Authentication authenticate;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userLogIn.getUserName());
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails
                    , userLogIn.getPassword()
                    , userDetails.getAuthorities());
            authenticate =
                    authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException e) {
            log.info("Authorization failed: BadCredentialsException!");
            return false;
        } catch (UsernameNotFoundException e) {
            log.info("UsernameNotFoundException in SecurityServiceImpl!");
            return false;
        }
        return true;
    }

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
