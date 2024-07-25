package com.example.final_api.Repos;

import com.example.final_api.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {
    List<Course> findByUserUserId(Integer userId);
    Optional<Course> findByCourseNameAndUserUserId(String name, int userId);
}
