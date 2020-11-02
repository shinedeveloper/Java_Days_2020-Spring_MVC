package net.sevecek.videoboss;

import javax.servlet.*;
import org.springframework.context.annotation.*;
import org.springframework.web.*;
import org.springframework.web.context.*;
import org.springframework.web.context.support.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import net.sevecek.util.spring.contextdump.*;

@Configuration
@ComponentScan
@EnableWebMvc
public class VideoBossApp implements WebApplicationInitializer, WebMvcConfigurer {

    @Override
    public void onStartup(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext applicationContext =
                new AnnotationConfigWebApplicationContext();
        applicationContext.register(VideoBossApp.class);
        ContextLoader contextLoader = new ContextLoader(applicationContext);
        contextLoader.initWebApplicationContext(servletContext);
    }

    @Bean
    public DispatcherServlet dispatcherServlet(WebApplicationContext applicationContext) {
        DispatcherServlet frontController = new DispatcherServlet(applicationContext);
        ServletContext servletContainer = applicationContext.getServletContext();
        ServletRegistration.Dynamic reg = servletContainer.addServlet(
                "springMvcServlet", frontController);
        reg.addMapping("/");
        return frontController;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
    }

    @Bean
    public Dumper dumper() {
        return new Dumper();
    }
}
