package net.sevecek.videoboss;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.http.*;
import org.springframework.boot.autoconfigure.jackson.*;
import org.springframework.boot.autoconfigure.web.embedded.*;
import org.springframework.boot.autoconfigure.web.servlet.*;
import org.springframework.boot.autoconfigure.web.servlet.error.*;
import org.springframework.boot.builder.*;
import org.springframework.boot.context.*;
import org.springframework.boot.web.servlet.support.*;
import org.springframework.context.annotation.*;

@SpringBootConfiguration
@ImportAutoConfiguration(classes = {
//        EmbeddedWebServerFactoryCustomizerAutoConfiguration.class,
//        ServletWebServerFactoryAutoConfiguration.class,
        HttpEncodingAutoConfiguration.class,
        MultipartAutoConfiguration.class,

        DispatcherServletAutoConfiguration.class,
        WebMvcAutoConfiguration.class,
        ErrorMvcAutoConfiguration.class,
        JacksonAutoConfiguration.class,
        HttpMessageConvertersAutoConfiguration.class,
})
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class)
})
public class VideoBossApp extends SpringBootServletInitializer {

/*
    public static void main(String[] args) {
        SpringApplication.run(VideoBossApp.class, args);
    }
*/

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VideoBossApp.class);
    }
}
