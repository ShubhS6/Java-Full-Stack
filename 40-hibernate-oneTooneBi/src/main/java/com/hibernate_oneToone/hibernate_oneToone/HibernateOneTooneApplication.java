package com.hibernate_oneToone.hibernate_oneToone;
import com.hibernate_oneToone.hibernate_oneToone.dao.instructorDao;
import com.hibernate_oneToone.hibernate_oneToone.model.instructor;
import com.hibernate_oneToone.hibernate_oneToone.model.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HibernateOneTooneApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneTooneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(instructorDao instructorDao){
		return runner->{
			//saveInstructor(instructorDao);
			//findById(instructorDao);
			//deleteById(instructorDao);
			instructorDetailById(instructorDao);
		};
	}

	public void saveInstructor(instructorDao instructorDao){
		instructor a=new instructor("sumi","vish","sumiVish@123");
		InstructorDetail ad=new InstructorDetail("http://sumi.com","coding");
		a.setInstructorDetail(ad);
		instructorDao.save(a);
	}

	public void findById(instructorDao instructorDao){
		System.out.println(instructorDao.findById(2));
	}

	public void deleteById(instructorDao instructorDao){
		instructorDao.deleteById(3);
	}

	public void instructorDetailById(instructorDao instructorDao){
		InstructorDetail inst=instructorDao.findInstructorDetailByid(2);
		System.out.println(inst);
		System.out.println(inst.getInstructor());
	}
}
