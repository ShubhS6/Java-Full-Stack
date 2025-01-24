package com.jpaH2Web.jpaH2Web;

import com.jpaH2Web.jpaH2Web.model.Course;
import com.jpaH2Web.jpaH2Web.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaH2WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaH2WebApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CourseRepository repository) {
		return (args) -> {
			//Course course=repository.findById(1);
			//System.out.println(course);

			//Show all data
			//repository.showAll().forEach(System.out::println);


			//delete By id
			//System.out.println(repository.deleteById(1));
			//repository.showAll().forEach(System.out::println);

			//save the data
			//System.out.println(repository.save(new Course(100,"Java")));
			//repository.showAll().forEach(System.out::println);

			System.out.println(repository.search());



		};
	}

}
