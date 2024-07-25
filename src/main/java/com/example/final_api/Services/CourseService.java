package com.example.final_api.Services;

import com.example.final_api.Exception.ResourceNotFoundException;
import com.example.final_api.Model.Course;
import com.example.final_api.Repos.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseService {

    private CourseRepo courseRepository;

    @Autowired
    public CourseService(CourseRepo courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
    public List<Course> getCoursesByUserId(Integer userId) {
        return courseRepository.findByUserUserId(userId);
    }
    public Course updateCourse(Integer id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course does not exist with id : " + id));

        course.setCourseName(courseDetails.getCourseName());
        course.setStartTime(courseDetails.getStartTime());
        course.setEndTime(courseDetails.getEndTime());

        return courseRepository.save(course);
    }
    public Course getCourseByNameAndUserId(String name, int userId) {
        return courseRepository.findByCourseNameAndUserUserId(name, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with name " + name + " and userId " + userId));
    }
    public Map<String, Boolean> deleteCourse(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found."));

        courseRepository.delete(course);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}