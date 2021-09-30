package Practice.CustomExceptionExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableJpaAuditing
@SpringBootApplication
public class CustomExceptionExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomExceptionExampleApplication.class, args);
	}

}

