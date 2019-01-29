package mate.academy.springdemo.service.impl;

import mate.academy.springdemo.model.Project;
import mate.academy.springdemo.repository.ProjectRepository;
import mate.academy.springdemo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public void update(Project project) {
        projectRepository.save(project);
    }
}
