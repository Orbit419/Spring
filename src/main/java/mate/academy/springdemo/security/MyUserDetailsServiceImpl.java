package mate.academy.springdemo.security;

import mate.academy.springdemo.model.User;
import mate.academy.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user =  userService.findByUserName(userName);
        if(user == null) throw new UsernameNotFoundException("User not found!");

        Set<GrantedAuthority> authoritySet = new HashSet<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        authoritySet.add(authority);
        return new org.springframework.security.core.userdetails
                .User(user.getUserName(), user.getPassword(), authoritySet);
    }
}
