package co.edu.glm.librarium;

import co.edu.glm.librarium.controller.Controller;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibrariumApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibrariumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		new Controller();
	}

}
