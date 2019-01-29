package mate.academy.springdemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperDto {
    private Long id;
    private String name;
    private int age;
    private int salary;
}
