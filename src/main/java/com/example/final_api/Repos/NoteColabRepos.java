package com.example.final_api.Repos;

import com.example.final_api.Model.NoteColab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface NoteColabRepos extends JpaRepository<NoteColab, Integer> {
    List<NoteColab> findByNote_NoteID(Integer noteId);
}
