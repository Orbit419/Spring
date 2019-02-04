package mate.academy.springdemo.repository;

import mate.academy.springdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String name);

    void deleteByLogin(String login);

    boolean existsByLogin(String login);
}
