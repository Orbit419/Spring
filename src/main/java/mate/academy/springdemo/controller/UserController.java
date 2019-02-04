package mate.academy.springdemo.controller;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.model.User;
import mate.academy.springdemo.model.userDto.UserLogIn;
import mate.academy.springdemo.model.userDto.UserRegistration;
import mate.academy.springdemo.model.util.Response;
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
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping(value = "/login")
    public String logIn() {
        log.info("Login GET works!");
        return "users/logIn";
    }

    @ResponseBody
    @PostMapping(value = "/login")
    public Response logIn(@RequestBody UserLogIn userInput) {
        Response resp = new Response();
        log.info("Entered into login POST!");
        if (service.existsByLogin(userInput.getLogin())) {
            User user = service.findByLogin(userInput.getLogin());
            log.info("Find a user!");
            if (
                    user.getLogin().equalsIgnoreCase(userInput.getLogin())
                            & user.getPassword().equals(userInput.getPassword())
            ) {
                resp.setResponse("Success!");
                return resp;
            }
        }
        resp.setResponse("Denied!");
        return resp;
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "users/registration";
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
