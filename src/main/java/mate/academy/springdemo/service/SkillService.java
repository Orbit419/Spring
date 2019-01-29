package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Skill;
import org.springframework.stereotype.Service;

@Service
public interface SkillService {
    Skill create(Skill skill);

    Skill findById(Long id);

    void deleteById(Long id);

    void update(Skill skill);
}
