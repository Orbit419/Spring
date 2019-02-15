package mate.academy.springdemo.controller;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.model.userDto.UserRegistration;
import mate.academy.springdemo.model.util.Response;
import mate.academy.springdemo.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Log4j2
@Controller
public class AuthorizationController {
    @Autowired
    private SecurityService securityService;

    @GetMapping(value = "/login")
    public String logIn(Authentication authentication, ModelMap model, HttpServletRequest request) {
        if(authentication != null)
            return "redirect:/";
        if(request.getParameterMap().containsKey("error"))
            model.addAttribute("error", true);
        log.info("Login GET works!");
        return "authorization/logIn";
    }

    @GetMapping(value = "/registration")
    public String registration() {
        return "authorization/registration";
    }

    @ResponseBody
    @PostMapping(value = "/registration")
    public Response registration(@RequestBody UserRegistration userReg) {
        boolean result = securityService.doRegistration(userReg);
        if(result)
            return new Response("New user was created!");
        else
            return new Response("Something incorrect!");
    }
}
