package com.hibernate_H2console.hibernate_H2console;

import com.hibernate_H2console.hibernate_H2console.model.Person;
import com.hibernate_H2console.hibernate_H2console.repositoryJdbc.PersonJdbc;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class HibernateH2consoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateH2consoleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(PersonJdbc personJdbc){
		return args -> {
			List<Person> p=personJdbc.findAll();
			System.out.println(p);
			Person p1=personJdbc.findById(10002);
			System.out.println(p1);
			int i=personJdbc.deleteById(10002);
			System.out.println(i);
			List<Person> pall=personJdbc.findAll();
			System.out.println(pall);

			Person inp=new Person(10002,"Adam","New York",new Date());
			personJdbc.insert(inp);
			List<Person> palla=personJdbc.findAll();
			System.out.println(palla);
		};
		}
	}


