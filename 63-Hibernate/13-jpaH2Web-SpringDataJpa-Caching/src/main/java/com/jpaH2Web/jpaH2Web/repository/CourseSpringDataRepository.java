package com.jpaH2Web.jpaH2Web.repository;

import com.jpaH2Web.jpaH2Web.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringDataRepository extends JpaRepository<Course,Integer> {
    List<Course> findByName(String name);
    List<Course> findByNameAndId(String name,int id);
    List<Course> findByNameOrderByIdDesc(String name);
    void deleteByName(String name);

    //or we can do is
    //@Query(value="select c from Course where c.name=?1",nativeQuery = true)
    //List<Course> findByName(String name);

}
