package com.example.final_api.Controllers;


import com.example.final_api.Model.Note;
import com.example.final_api.Services.NoteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Integer id) {
        return ResponseEntity.ok(noteService.getNoteById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Note>> getNotesByUserId(@PathVariable Integer userId) {
        List<Note> notes = noteService.getNotesByUserId(userId);
        if(notes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        Note savedNote = noteService.saveNote(note);
        return new ResponseEntity<>(savedNote, HttpStatus.CREATED);
    }
    @GetMapping("/user/{userId}/title")
    public ResponseEntity<Note> getNoteByTitleAndUserId(@PathVariable Integer userId, @RequestParam String title) {
        Note note = noteService.getNoteByTitleAndUserId(title, userId);
        return ResponseEntity.ok(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateNote(@PathVariable Integer id,@Valid @RequestBody Note note, BindingResult result) {
        if(result.hasErrors()){
            return ResponseEntity.badRequest().body("Invalid note data");
        }
        Note updatedNote = noteService.updateNote(id, note);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        noteService.deleteNote(id);
    }
}
