package mate.academy.springdemo.model.developerDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperInput {
    private String name;
    private int age;
    private int salary;
}

