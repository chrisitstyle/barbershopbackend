package pl.barbershopproject.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BarbershopApplication {

	public static final String LOCALHOST = "http://localhost:3000";

	public static void main(String[] args) {
		SpringApplication.run(BarbershopApplication.class, args);
	}



	@Bean // bean, zeby to bylo widoczne dla Springa
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/customers").allowedOrigins(LOCALHOST);
				registry.addMapping("/login").allowedOrigins(LOCALHOST);
				registry.addMapping("/posts").allowedOrigins(LOCALHOST);
			}
		};
	}


}
