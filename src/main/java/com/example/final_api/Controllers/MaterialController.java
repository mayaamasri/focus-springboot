package com.example.final_api.Controllers;

import com.example.final_api.Model.Material;
import com.example.final_api.Services.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @GetMapping
    public ResponseEntity<List<Material>> getAllMaterials() {
        List<Material> materials = materialService.getAllMaterials();
        return ResponseEntity.ok(materials);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Material>> getMaterialsByCourseId(@PathVariable Integer courseId) {
        List<Material> materials = materialService.getMaterialsByCourseId(courseId);
        return ResponseEntity.ok(materials);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Integer id) {
        Material material = materialService.getMaterialById(id);
        return ResponseEntity.ok(material);
    }

    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        Material createdMaterial = materialService.createMaterial(material);
        return ResponseEntity.ok(createdMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Integer id, @RequestBody Material materialDetails) {
        Material updatedMaterial = materialService.updateMaterial(id, materialDetails);
        return ResponseEntity.ok(updatedMaterial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMaterial(@PathVariable Integer id) {
        Map<String, Boolean> response = materialService.deleteMaterial(id);
        return ResponseEntity.ok(response);
    }
}