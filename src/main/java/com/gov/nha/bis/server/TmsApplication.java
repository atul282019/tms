package com.gov.nha.bis.server;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@CrossOrigin
@ServletComponentScan(basePackages="com.gov.nha.*")
@SpringBootApplication(scanBasePackages="com.gov.nha.*", exclude = { SecurityAutoConfiguration.class })
public class TmsApplication {

	private static final Logger LOGGER = LogManager.getLogger(TmsApplication.class);
	 
	
	public static void main(String[] args) {
		SpringApplication.run(TmsApplication.class, args);
		LOGGER.info("Starting application TMS Application");
	}

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                .addMapping("/**")
                .allowedOrigins("*","*")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");// list all domains
            }
        };
    }
	
}
