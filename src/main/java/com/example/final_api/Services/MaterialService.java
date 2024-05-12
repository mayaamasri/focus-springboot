package com.example.final_api.Services;

import com.example.final_api.Exception.ResourceNotFoundException;
import com.example.final_api.Model.Material;
import com.example.final_api.Repos.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MaterialService {

    private MaterialRepo materialRepository;

    @Autowired
    public MaterialService(MaterialRepo materialRepository) {
        this.materialRepository = materialRepository;
    }

    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }
    public Material getMaterialById(Integer id) {
        return materialRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("material not found"));
    }

    public List<Material> getMaterialsByCourseId(Integer courseId) {
        return materialRepository.findByCourseCourseId(courseId);
    }

    public Material createMaterial(Material material) {
        return materialRepository.save(material);
    }

    public Material updateMaterial(Integer id, Material materialDetails) {
        Material material = materialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("material does not exist with id : " + id));

        material.setMaterialId(materialDetails.getMaterialId());
        material.setTitle(materialDetails.getTitle());
        material.setDocument(materialDetails.getDocument());

        return materialRepository.save(material);
    }

    public Map<String, Boolean> deleteMaterial(Integer id) {
        Material material = materialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("material not found."));

        materialRepository.delete(material);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}