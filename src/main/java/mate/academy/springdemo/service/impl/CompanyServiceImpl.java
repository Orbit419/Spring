package mate.academy.springdemo.service.impl;

import mate.academy.springdemo.model.Company;
import mate.academy.springdemo.repository.CompanyRepository;
import mate.academy.springdemo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company create(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.getOne(id);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void update(Company company) {
        companyRepository.save(company);
    }
}
