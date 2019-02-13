package mate.academy.springdemo.controller;

import mate.academy.springdemo.dtoUtil.DtoUtil;
import mate.academy.springdemo.model.userDto.UserAdminOutput;
import mate.academy.springdemo.model.userDto.UserInputChangedRoleDto;
import mate.academy.springdemo.model.util.Response;
import mate.academy.springdemo.service.SecurityService;
import mate.academy.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;

    @GetMapping
    public String getAll() {
        return "administration/allUsers";
    }

    @ResponseBody
    @GetMapping("/all")
    public List<UserAdminOutput> getAllUsers() {
        return userService.getAll().stream()
                .map(DtoUtil::getUserAdminOutput)
                .collect(Collectors.toList());
    }

    @GetMapping("/changeRole/{id}")
    public String changeRole(@PathVariable Long id, Model model) {
        UserAdminOutput user  = DtoUtil.getUserAdminOutput(userService.findById(id));
        model.addAttribute("user", user);
        return "administration/changeRole";
    }

    @ResponseBody
    @PostMapping("/changeRole")
    public Response changeRole(@RequestBody UserInputChangedRoleDto userInput) {
        securityService.changeRole(userInput.getId(), userInput.getRole().toUpperCase());
        return new Response("http://localhost:8080/springdemo_war_exploded/admin");
    }
}
