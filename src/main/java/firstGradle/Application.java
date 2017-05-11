package firstGradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Application {

	@RequestMapping("/hello")
	public String home() {
		return "Spring Boot Hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}