package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.developerDto.DeveloperOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeveloperService {
    Developer create(Developer dev);

    DeveloperOutput findById(Long id);

    List<DeveloperOutput> getAll();

    void deleteById(Long id);

    void update(Developer developer);

    List<Developer> getDevelopersWithSalaryGt(Integer salary);
}
