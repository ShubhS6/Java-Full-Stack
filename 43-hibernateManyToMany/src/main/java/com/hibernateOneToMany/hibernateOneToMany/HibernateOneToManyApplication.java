package com.hibernateOneToMany.hibernateOneToMany;
import com.hibernateOneToMany.hibernateOneToMany.dao.mainDao;
import com.hibernateOneToMany.hibernateOneToMany.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernateOneToManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateOneToManyApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(mainDao mainDao){
		return runner->{
			//saveData(mainDao);
			//findInstructorWithCourses(mainDao);
			//findInstructorWithCoursesWithJoinFetch(mainDao);
			//addReview(mainDao);
			//saveStudentAndCourse(mainDao);
			//findCourseAndStudentByCourseId(mainDao);
			findStudentAndCourseByStudentId(mainDao);
			//addMoreCoursesToStudentById(mainDao);
		};
	}

	private void addMoreCoursesToStudentById(mainDao mainDao) {
		student student=mainDao.findStudentAndCourseByStudentId(2);
		course courseOne=new course("Computer Network");
		course courseTwo=new course("Operating System");
		student.addCourse(courseOne);
		student.addCourse(courseTwo);
		mainDao.update(student);
	}

	private void findStudentAndCourseByStudentId(mainDao mainDao){
		student student=mainDao.findStudentAndCourseByStudentId(2);
		System.out.println(student);
		System.out.println(student.getCourseList());
	}

	private void findCourseAndStudentByCourseId(mainDao mainDao) {
		course course=mainDao.findCourseAndStudentByCourseId(12);
		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void saveStudentAndCourse(mainDao mainDao) {
		course tempCourse = new course("Pacman - How To Score One Million Points");

		// create the students
		student tempStudent1 = new student("John", "Doe", "john@luv2code.com");
		student tempStudent2 = new student("Mary", "Public", "mary@luv2code.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving the course: " + tempCourse);
		System.out.println("associated students: " + tempCourse.getStudents());

		mainDao.save(tempCourse);

	}

	public void saveData(mainDao mainDao){
		//instructor inst=new instructor("Ana","vish","ana@123");
		//instructorDetail a=new instructorDetail("anayoutube","study");
		//inst.setInstructorDetail(a);
		//mainDao.save(inst);
		instructor instructor=mainDao.findById(1);
		course courseOne=new course("DBMS Book");
		course courseTwo=new course("Java Reference Book");
		instructor.addCourse(courseOne);
		instructor.addCourse(courseTwo);
		mainDao.update(instructor);
	}

	public void findInstructorWithCourses(mainDao mainDao){
		instructor instructor=mainDao.findById(1);
		System.out.println(instructor.getFirstName());
		//System.out.println(instructor.getCourseList());
	}

	public void findInstructorWithCoursesWithJoinFetch(mainDao mainDao){
		instructor inst=mainDao.findinstructorByjoinFetch(1);
		System.out.println(inst);
		System.out.println(inst.getCourseList()
		);
	}

	public void addReview(mainDao mainDao){
		course course=mainDao.findCourseById(10);
		course.addReview(new review("good Book"));
		course.addReview(new review("Average Book"));
		course.addReview(new review("Execelant"));
		mainDao.addReview(course);
	}

}
