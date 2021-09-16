package Practice.CustomExceptionExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CustomExceptionExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomExceptionExampleApplication.class, args);
	}

}

