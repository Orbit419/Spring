package mate.academy.springdemo.dtoUtil;

import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.model.dto.DeveloperInput;
import mate.academy.springdemo.model.dto.DeveloperOutput;

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
}
