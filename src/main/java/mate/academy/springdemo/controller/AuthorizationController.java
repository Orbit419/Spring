package mate.academy.springdemo.controller;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.model.User;
import mate.academy.springdemo.model.userDto.UserLogIn;
import mate.academy.springdemo.model.userDto.UserRegistration;
import mate.academy.springdemo.model.util.AuthResponse;
import mate.academy.springdemo.model.util.Response;
import mate.academy.springdemo.service.SecurityService;
import mate.academy.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Log4j2
@Controller
@RequestMapping(value = "/auth")
public class AuthorizationController {
    @Autowired
    private UserService service;

    @Autowired
    private SecurityService securityService;

    @GetMapping(value = "/login")
    public String logIn() {
        log.info("Login GET works!");
        return "authorization/logIn";
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public AuthResponse doLogin(@RequestBody UserLogIn userLogIn) {
        log.info("Entered into POST doLogin()");
        boolean result = securityService.doLogin(userLogIn);
        log.info("POST doLogin() works!");

        return new AuthResponse(result);
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "authorization/registration";
    }

    @ResponseBody
    @PostMapping(value = "/registration")
    public Response registration(@RequestBody UserRegistration userReg) {
        User user = User.builder()
                .login(userReg.getLogin())
                .password(userReg.getPassword())
                .mail(userReg.getMail())
                .build();
        service.create(user);
        return new Response("New user was created!");
    }
}
