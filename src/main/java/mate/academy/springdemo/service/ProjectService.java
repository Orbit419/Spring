package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Project;
import org.springframework.stereotype.Service;

@Service
public interface ProjectService {
    Project create(Project project);

    Project findById(Long id);

    void deleteById(Long id);

    void update(Project project);
}
