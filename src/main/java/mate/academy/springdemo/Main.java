package mate.academy.springdemo;

import mate.academy.springdemo.config.Config;
import mate.academy.springdemo.model.Developer;
import mate.academy.springdemo.service.DeveloperService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        DeveloperService developerService = context.getBean(DeveloperService.class);
        Developer dev2 = Developer.builder().id(1L).name("Vasya").age(30).salary(900).build();
        developerService.create(dev2);

        developerService.create(dev2);
    }
}
