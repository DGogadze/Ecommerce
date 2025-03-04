package ge.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/authorization").setViewName("authorization");
        registry.addViewController("/profile").setViewName("profile");
        registry.addViewController("/registration").setViewName("registration");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/styles/**")
                .addResourceLocations("classpath:/styles");
    }
}
