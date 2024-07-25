package com.example.final_api.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="materials")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="material_id", nullable = false)
    private Integer materialId;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="document_path", nullable = false)
    private String documentPath;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Material() {

    }
    public Material(Integer materialId, String document) {
        this.materialId = materialId;
        this.documentPath = document;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getDocument() {
        return documentPath;
    }

    public void setDocument(String document) {
        this.documentPath = document;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialId=" + materialId +
                ", document='" + documentPath + '\'' +
                '}';
    }
}

