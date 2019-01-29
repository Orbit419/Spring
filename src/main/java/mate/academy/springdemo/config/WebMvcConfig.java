package mate.academy.springdemo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "mate.academy.springdemo.controller")
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {
        viewResolverRegistry.jsp("/WEB-INF/pages/", ".jsp");
    }

    public void addResourceHandlers (ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
