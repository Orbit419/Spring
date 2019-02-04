package mate.academy.springdemo.service.impl;

import mate.academy.springdemo.dtoUtil.DtoUtil;
import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.dto.DeveloperOutput;
import mate.academy.springdemo.repository.DeveloperRepository;
import mate.academy.springdemo.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeveloperServiceImpl implements DeveloperService {
    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer create(Developer dev) {
        return developerRepository.save(dev);
    }

    @Transactional(readOnly = true)
    public DeveloperOutput findById(Long id) {
        Developer dev = developerRepository.getOne(id);
        DeveloperOutput devDto = DeveloperOutput.builder()
                .id(dev.getId())
                .age(dev.getAge())
                .name(dev.getName())
                .salary(dev.getSalary())
                .build();
        return devDto;
    }

    @Override
    public List<DeveloperOutput> getAll() {
        return developerRepository.findAll().stream()
                .map(developer -> DtoUtil.getDeveloperOutput(developer))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        developerRepository.deleteById(id);
    }

    @Override
    public void update(Developer developer) {
        developerRepository.save(developer);
    }

    public List<Developer> getDevelopersWithSalaryGt(Integer salary) {
        return developerRepository.findAllBySalaryGreaterThan(salary);
    }
}
