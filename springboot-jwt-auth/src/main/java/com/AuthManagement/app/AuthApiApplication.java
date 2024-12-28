package com.AuthManagement.app;

import com.AuthManagement.app.entities.User;
import com.AuthManagement.app.repositories.UserRepository;
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
						.setId(1L)
						.setFullName("John Doe")
						.setEmail("john.doe@example.com")
						.setPassword(passwordEncoder.encode("password123")); // Encode the password here

				User user2 = new User()
						.setId(2L)
						.setFullName("Jane Smith")
						.setEmail("jane.smith@example.com")
						.setPassword(passwordEncoder.encode("securepass456")); // Encode the password here

				User user3 = new User()
						.setId(3L)
						.setFullName("Michael Brown")
						.setEmail("michael.brown@example.com")
						.setPassword(passwordEncoder.encode("mypassword789")); // Encode the password here

				userRepository.save(user1);
				userRepository.save(user2);
				userRepository.save(user3);
				System.out.println("3 users initialized!");
			}
		};
	}

}
