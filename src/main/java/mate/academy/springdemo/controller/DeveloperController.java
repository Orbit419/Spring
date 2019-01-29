package mate.academy.springdemo.controller;

import mate.academy.springdemo.config.Config;
import mate.academy.springdemo.model.Customer;
import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Project;
import mate.academy.springdemo.model.Skill;
import mate.academy.springdemo.model.dto.DeveloperDto;
import mate.academy.springdemo.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.web.JsonPath;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.HashSet;

@Controller
@RequestMapping("/developer")
public class DeveloperController {
    @Autowired
    DeveloperService developerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String info() {
        Developer dev2 = Developer.builder()
                .id(4L)
                .name("Vasya")
                .age(30)
                .salary(900)
                .projects(new HashSet<>())
                .skills(new HashSet<>())
                .build();
        Skill skill = Skill.builder()
                .id(1L)
                .branch("Java")
                .level("Junior")
                .build();
        Project project = Project.builder()
                .id(1L)
                .name("Astra")
                .birthday(LocalDate.parse("2005-06-08"))
                .cost(150000)
                .build();
        Customer customer = Customer.builder()
                .id(1L)
                .name("Tolya")
                .country("Amerika")
                .projects(new HashSet<>())
                .build();
        customer.addProject(project);
        dev2.addProject(project);
        dev2.addSkill(skill);
        developerService.create(dev2);

        return "developers/info";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String id(@PathVariable Long id, Model model) {
        DeveloperDto dev = developerService.findById(id);
        model.addAttribute("developer", dev);
        return "developers/id";
    }

    @RequestMapping(value = "/newDev", method = RequestMethod.GET)
    public ModelAndView newDeveloper() {
        return new ModelAndView("developers/createDeveloper", "developer", new Developer());
    }

    @RequestMapping(value = "/addDev", method = RequestMethod.POST)
    public String putDeveloper(@ModelAttribute("developer") DeveloperDto devDto, ModelMap model) {
        Developer dev = Developer.builder()
                .id(devDto.getId())
                .age(devDto.getAge())
                .name(devDto.getName())
                .salary(devDto.getSalary())
                .build();
        developerService.create(dev);

        model.addAttribute(devDto);
        return "developers/developerView";
    }
}
