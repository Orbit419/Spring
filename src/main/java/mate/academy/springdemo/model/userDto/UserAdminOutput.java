package mate.academy.springdemo.model.userDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAdminOutput {
    private Long id;
    private String userName;
    private String role;
}
