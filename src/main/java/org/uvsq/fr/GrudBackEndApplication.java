package org.uvsq.fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.uvsq.fr.entities.User;
import org.uvsq.fr.repositories.UserRepository;

@SpringBootApplication
public class GrudBackEndApplication implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GrudBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new User("Abdel","idouhammou"));
		userRepository.save(new User("Myriam","idouhammou"));
		userRepository.save(new User("Oussama","idouhammou"));

	}
}
