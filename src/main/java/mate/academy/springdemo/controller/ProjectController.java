package mate.academy.springdemo.controller;

import mate.academy.springdemo.dtoUtil.DtoUtil;
import mate.academy.springdemo.model.Project;
import mate.academy.springdemo.model.projectDto.ProjectInputDto;
import mate.academy.springdemo.model.projectDto.ProjectOutputDto;
import mate.academy.springdemo.model.util.Response;
import mate.academy.springdemo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String index() {
        return "projects/info";
    }

    @GetMapping("/all")
    @ResponseBody
    public List<ProjectOutputDto> getAll() {
        return projectService.findAll().stream()
                .map(DtoUtil::getProjectOutputDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/addProject")
    public String addProject() {
        return "projects/addProject";
    }

    @ResponseBody
    @PutMapping("/addProject")
    public Response addProject(@RequestBody ProjectInputDto projectInputDto) {
        Project project = Project.builder()
                .name(projectInputDto.getName())
                .cost(projectInputDto.getCost())
                .birthday(projectInputDto.getBirthday())
                .build();
        projectService.create(project);
        return new Response("New project was added!");
    }
}
