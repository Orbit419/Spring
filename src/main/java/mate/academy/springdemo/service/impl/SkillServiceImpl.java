package mate.academy.springdemo.service.impl;

import mate.academy.springdemo.model.Skill;
import mate.academy.springdemo.repository.SkillRepository;
import mate.academy.springdemo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillServiceImpl implements SkillService {
    private final SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill create(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill findById(Long id) {
        return skillRepository.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

    @Override
    public void update(Skill skill) {
        skillRepository.save(skill);
    }
}
