package com.example.final_api.Repos;

import com.example.final_api.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepo extends JpaRepository<Note, Integer> {
    List<Note> findByUserUserId(Integer userId);
    Optional<Note> findByTitleAndUserUserId(String title, Integer userId);
}
