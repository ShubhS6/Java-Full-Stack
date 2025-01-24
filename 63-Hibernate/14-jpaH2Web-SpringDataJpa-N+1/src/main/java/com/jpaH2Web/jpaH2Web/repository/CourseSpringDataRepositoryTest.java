package com.jpaH2Web.jpaH2Web.repository;

import com.jpaH2Web.jpaH2Web.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;
@Repository
public class CourseSpringDataRepositoryTest {
    @Autowired
    private CourseSpringDataRepository csdr;

    //here we are using the first level cache and we use transactional thats why
    //when i run this query first time it goes to database but
    // second time it will fetch the data from the cache and not from the database
    //if I dont use transactional then it will go to database every time
    @Transactional
    public void findByIdFirstLevelCacheDemo() {
        Optional<Course> c=csdr.findById(10001);
        Optional<Course> c1=csdr.findById(10001);
        System.out.println(c);
        System.out.println(c1);
    }



    //for the second level cache we put that data which is comman in many transactions
    //for that we have to add the dependency in pom.xml that is hibernate-ehcache
    //Now we enable the cache in the application.properties file









    public void findById() {
        Optional<Course> c=csdr.findById(10001);
        System.out.println(c);
    }

    public void sort(){
        Sort sort=Sort.by(Sort.Direction.DESC,"id").
                and(sort=Sort.by(Sort.Direction.ASC,"name"));
        Iterable<Course> c=csdr.findAll(sort);
        c.forEach(System.out::println);
    }

    //when we want to devide the result into some parts then we use paggination.
    public void paggination(){
        PageRequest pr=PageRequest.of(0,3);
        Page<Course> c=csdr.findAll(pr);
        c.forEach(System.out::println);

        Pageable secondPage=c.nextPageable();
        Page<Course> c2=csdr.findAll(secondPage);
        c2.forEach(System.out::println);
    }

    public void findName(){
        csdr.findByName("JPA").forEach(System.out::println);
    }

    public void findByNameAndId(){
        csdr.findByNameAndId("JPA",10007).forEach(System.out::println);
    }

}
