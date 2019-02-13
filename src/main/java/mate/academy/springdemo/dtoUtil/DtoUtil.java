package mate.academy.springdemo.dtoUtil;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.Project;
import mate.academy.springdemo.model.User;
import mate.academy.springdemo.model.developerDto.DeveloperInput;
import mate.academy.springdemo.model.developerDto.DeveloperOutput;
import mate.academy.springdemo.model.projectDto.ProjectOutputDto;
import mate.academy.springdemo.model.userDto.UserAdminOutput;

public class DtoUtil {
    public static DeveloperOutput getDeveloperOutput(Developer dev) {
        return DeveloperOutput.builder()
                .id(dev.getId())
                .age(dev.getAge())
                .name(dev.getName())
                .salary(dev.getSalary())
                .build();
    }

    public static DeveloperInput getDeveloperInput(Developer dev) {
        return DeveloperInput.builder()
                .age(dev.getAge())
                .name(dev.getName())
                .salary(dev.getSalary())
                .build();
    }

    public static UserAdminOutput getUserAdminOutput (User user) {
        return UserAdminOutput.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .role(user.getRole())
                .build();
    }

    public static ProjectOutputDto getProjectOutputDto (Project project) {
        return ProjectOutputDto.builder()
                .id(project.getId())
                .birthday(project.getBirthday().toString())
                .cost(project.getCost())
                .name(project.getName())
                .build();
    }
}
