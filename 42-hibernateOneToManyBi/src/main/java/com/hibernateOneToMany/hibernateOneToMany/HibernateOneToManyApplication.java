package com.hibernateOneToMany.hibernateOneToMany;
import com.hibernateOneToMany.hibernateOneToMany.dao.mainDao;
import org.springframework.boot.CommandLineRunner;
import com.hibernateOneToMany.hibernateOneToMany.model.instructor;
import com.hibernateOneToMany.hibernateOneToMany.model.course;
import com.hibernateOneToMany.hibernateOneToMany.model.review;
import com.hibernateOneToMany.hibernateOneToMany.model.instructorDetail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			addReview(mainDao);
		};
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
