package mate.academy.springdemo.model.projectDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectOutputDto {
    private Long id;
    private String birthday;
    private String name;
    private int cost;
}
