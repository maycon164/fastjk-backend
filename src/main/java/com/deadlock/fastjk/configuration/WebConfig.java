package com.deadlock.fastjk.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {
    @Value("${app.url-frontend}")
    private String frontendUrl;
    @Value("${app.client-id}")
    private String clientId;
    @Value("${app.client-secret}")
    private  String clientSecret;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        log.info("Cors url %s is allowed".formatted(frontendUrl));

        registry.addMapping("/**")
                .allowedOrigins(frontendUrl)
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization")
                .allowCredentials(true);
    }

    @Bean
    public GoogleSecretsDTO googleSecretsDTO() {
        return new GoogleSecretsDTO(clientId, clientSecret);
    }
}
