package cl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
@EnableAutoConfiguration
public class ApiCreacionUsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCreacionUsuariosApplication.class, args);
	}

}
