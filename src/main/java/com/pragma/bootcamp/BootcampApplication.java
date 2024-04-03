package com.pragma.bootcamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}

	@Controller
	public class SwaggerController {

		@GetMapping("/swagger-ui/index.htm")
		public String redirectToSwaggerUi() {
			return "redirect:/swagger-ui.htm";
		}
	}
}
