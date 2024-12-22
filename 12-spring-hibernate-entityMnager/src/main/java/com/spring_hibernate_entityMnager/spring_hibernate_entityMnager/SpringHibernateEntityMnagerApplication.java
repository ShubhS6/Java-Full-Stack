package com.spring_hibernate_entityMnager.spring_hibernate_entityMnager;

import com.spring_hibernate_entityMnager.spring_hibernate_entityMnager.dao.studentDao;
import com.spring_hibernate_entityMnager.spring_hibernate_entityMnager.madel.student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringHibernateEntityMnagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateEntityMnagerApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(studentDao studentDao){
		return runner->{
			//createStudent(studentDao);
			//findById(studentDao);
			//allStudent(studentDao);
			//findByLastName(studentDao);
			//updateLastNameById(studentDao);
			//updateLastName(studentDao);
			deleteById(studentDao);
		};
	}

	public String createStudent(studentDao studentDao){
		student st=new student("Akhi","Pal","email@abc");
		studentDao.save(st);
		return "Student Added";
	}

	public void findById(studentDao studentDao){
		System.out.println(studentDao.findById(1));
	}

	public void allStudent(studentDao studentDao){
		System.out.println(studentDao.allStudent());
	}

	public void findByLastName(studentDao studentDao){
		List<student> st=studentDao.findByLastName("Pal");
		for(student ts:st){
			System.out.println(ts);
		}
	}

	public void updateLastNameById(studentDao studentDao){
		student student=studentDao.findById(1);
		student.setLastName("hello");
		studentDao.updateStudent(student);
		allStudent(studentDao);
	}

	public void updateLastName(studentDao studentDao){
		studentDao.updateLastName("test");
		allStudent(studentDao);
	}

	public void deleteById(studentDao studentDao){
		studentDao.delete(1);
		allStudent(studentDao);
	}

}
