package com.jpaH2Web.jpaH2Web.repository;

import com.jpaH2Web.jpaH2Web.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
@Repository
public class CourseSpringDataRepositoryTest {
    @Autowired
    private CourseSpringDataRepository csdr;

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
