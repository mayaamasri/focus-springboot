package com.example.final_api.Repos;

import com.example.final_api.Model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepo extends JpaRepository<Material, Integer> {
    List<Material> findByCourseCourseId(Integer courseId);
}
