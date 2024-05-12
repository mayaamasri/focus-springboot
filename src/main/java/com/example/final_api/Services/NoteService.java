package com.example.final_api.Services;


import com.example.final_api.Exception.ResourceNotFoundException;
import com.example.final_api.Model.Note;
import com.example.final_api.Repos.NoteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {

    private NoteRepo noteRepository;

    @Autowired
    public NoteService(NoteRepo noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }
    public Note getNoteById(Integer id) {
        return noteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Note not found"));
    }

    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }
    public List<Note> getNotesByUserId(Integer userId) {
        return noteRepository.findByUserUserId(userId);
    }
    public Note updateNote(Integer id, Note noteDetails) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note does not exist with id : " + id));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        note.setCollab(noteDetails.getCollab());

        return noteRepository.save(note);
    }

    public Map<String, Boolean> deleteNote(Integer id) {
        Note course = noteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found."));

        noteRepository.delete(course);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}