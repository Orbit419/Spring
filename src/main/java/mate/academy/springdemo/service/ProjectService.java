package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {
    Project create(Project project);

    Project findById(Long id);

    List<Project> findAll();

    void deleteById(Long id);

    void update(Project project);
}
