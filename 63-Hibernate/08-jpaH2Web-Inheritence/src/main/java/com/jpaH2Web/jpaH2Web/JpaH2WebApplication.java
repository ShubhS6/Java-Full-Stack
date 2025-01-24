package com.jpaH2Web.jpaH2Web;

import com.jpaH2Web.jpaH2Web.model.Employee;
import com.jpaH2Web.jpaH2Web.model.FullTimeEmployee;
import com.jpaH2Web.jpaH2Web.model.PartTimeEmployee;
import com.jpaH2Web.jpaH2Web.model.Student;
import com.jpaH2Web.jpaH2Web.repository.CourseRepository;
import com.jpaH2Web.jpaH2Web.repository.EmployeeRepository;
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
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {
			//repository.save();
			//Student s=repository.findById(20001);
			//System.out.println(s);
			//System.out.println(repository.addData()
			Employee e=new FullTimeEmployee(1,"A",10000);
			Employee e2=new PartTimeEmployee(2,"B",20);
			repository.insert(e);
			repository.insert(e2);
			System.out.println(repository.retrieveAllPartTimeEmployees());
			System.out.println(repository.retrieveAllFullTimeEmployees());
		};
	}

}
