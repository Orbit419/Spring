package mate.academy.springdemo.controller;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.dtoUtil.DtoUtil;
import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.developerDto.DeveloperInput;
import mate.academy.springdemo.model.developerDto.DeveloperOutput;
import mate.academy.springdemo.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Log4j2
@Controller
@RequestMapping("/developer")
public class DeveloperController {
    @Autowired
    private DeveloperService developerService;

    @RequestMapping(method = RequestMethod.GET)
    public String info(ModelMap model) {
        List<DeveloperOutput> developers = developerService.getAll();
        model.addAttribute("developers", developers);
        return "index";
    }

    @RequestMapping(value = "/jQueryDev", method = RequestMethod.GET)
    public String jQueryDev(ModelMap model) {
        log.info("jQuery returned view!");
        return "developers/testJson";
    }

    @ResponseBody
    @GetMapping(value = "/all")
    public List<DeveloperOutput> getAll() {
        List<DeveloperOutput> developers = developerService.getAll();
        log.info("getAll returned list of developers!");
        return developers;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String id(@PathVariable Long id, Model model) {
        DeveloperOutput dev = developerService.findById(id);
        model.addAttribute("developer", dev);
        return "developers/info";
    }

    @RequestMapping(value = "/newDev", method = RequestMethod.GET)
    public ModelAndView newDeveloper() {
        return new ModelAndView("developers/createDeveloper", "developer", new DeveloperInput());
    }

    @RequestMapping(value = "/addDev", method = RequestMethod.POST)
    public String postDeveloper(@ModelAttribute("developer") DeveloperInput devInput, ModelMap model) {
        Developer dev = Developer.builder()
                .age(devInput.getAge())
                .name(devInput.getName())
                .salary(devInput.getSalary())
                .build();
        Long id = developerService.create(dev).getId();

        DeveloperOutput devOut = DtoUtil.getDeveloperOutput(dev);
        devOut.setId(id);

        model.addAttribute("developer", devOut);
        return "developers/developerView";
    }

    @RequestMapping(value = "/put", method = RequestMethod.GET)
    public String put() {
        return "developers/putDeveloper";
    }

    @ResponseBody
    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public String put(@RequestBody MultiValueMap<String, String> formParams) {
        Developer dev = Developer.builder()
                .name(formParams.getFirst("name"))
                .age(Integer.parseInt(formParams.getFirst("age")))
                .salary(Integer.parseInt(formParams.getFirst("salary")))
                .build();
        developerService.create(dev);
        return "Developer created!";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete() {
        return "developers/delete";
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id) {
        developerService.deleteById(id);
        return "Developer deleted";
    }
}
