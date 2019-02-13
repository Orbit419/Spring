package mate.academy.springdemo.repository;

import mate.academy.springdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findById(Long id);

    User findByUserName(String name);

    void deleteById(Long id);

    void deleteByUserName(String userName);

    boolean existsByUserName(String userName);
}
