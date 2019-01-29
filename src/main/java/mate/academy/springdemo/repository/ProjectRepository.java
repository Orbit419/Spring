package mate.academy.springdemo.repository;

import mate.academy.springdemo.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
