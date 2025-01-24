package com.jpaH2Web.jpaH2Web;

import com.jpaH2Web.jpaH2Web.model.Student;
import com.jpaH2Web.jpaH2Web.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaH2WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaH2WebApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(StudentRepository repository) {
		return (args) -> {
			//repository.save();
			Student s=repository.findById(20001);
			System.out.println(s);
		};
	}

}
