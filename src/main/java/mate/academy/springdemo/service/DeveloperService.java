package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.dto.DeveloperDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeveloperService {
    Developer create(Developer dev);

    DeveloperDto findById(Long id);

    void deleteById(Long id);

    void update(Developer developer);

    List<Developer> getDevelopersWithSalaryGt(Integer salary);
}
