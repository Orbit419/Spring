package mate.academy.springdemo.model.projectDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectInputDto {
    private String name;
    @Builder.Default
    private LocalDate birthday = LocalDate.now();
    private int cost;
}
