package mate.academy.springdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "developers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private int salary;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Skill> skills;
    @ManyToMany(cascade = CascadeType.ALL)
    Set<Project> projects;

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}

