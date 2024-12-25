package com.AuthManagement.app;

import com.AuthManagement.app.entities.User;
import com.AuthManagement.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			// Initialize some users here
			if (userRepository.count() == 0) {
				User user1 = new User()
						.setFullName("John Doe")
						.setEmail("john.doe@example.com")
						.setPassword(passwordEncoder.encode("password123")); // Encode the password here

				User user2 = new User()
						.setFullName("test")
						.setEmail("testUser")
						.setPassword(passwordEncoder.encode("test")); // Encode the password here

				userRepository.save(user1);
				userRepository.save(user2);
				System.out.println("Users initialized!");
			}
		};
	}
}
