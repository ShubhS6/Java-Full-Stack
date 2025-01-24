package com.jpaH2Web.jpaH2Web.repository;

import com.jpaH2Web.jpaH2Web.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSpringDataRepository extends JpaRepository<Course,Integer> {
}
