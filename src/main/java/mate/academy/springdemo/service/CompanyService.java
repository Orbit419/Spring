package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Company;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {
    Company create(Company dev);

    Company findById(Long id);

    void deleteById(Long id);

    void update(Company developer);
}
