package mate.academy.springdemo.service;

import mate.academy.springdemo.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer create(Customer customer);

    Customer findById(Long id);

    void deleteById(Long id);

    void update(Customer customer);
}
