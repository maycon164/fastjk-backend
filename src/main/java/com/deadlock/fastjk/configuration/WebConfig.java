package com.deadlock.fastjk.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private Environment env;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept")
                .allowCredentials(true);
    }

    @Bean
    public GoogleSecretsDTO googleSecretsDTO(@Value("${app.client-id}") String CLIENT_ID, @Value("${app.secret}") String SECRET ) {
        return new GoogleSecretsDTO(CLIENT_ID, SECRET);
    }
}
