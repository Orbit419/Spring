package mate.academy.springdemo.service.impl;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.model.userDto.UserLogIn;
import mate.academy.springdemo.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public boolean doLogin(UserLogIn userLogIn) {
        Authentication authenticate;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(userLogIn.getLogin());
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails
                    , userLogIn.getPassword()
                    , userDetails.getAuthorities());

            authenticate =
                    authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            return false;
        }
        return true;
    }
}
