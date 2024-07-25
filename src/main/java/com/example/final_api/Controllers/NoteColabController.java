package com.example.final_api.Controllers;

import com.example.final_api.Model.NoteColab;
import com.example.final_api.Services.NoteColabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/colab-participants")
public class NoteColabController {

    @Autowired
    private NoteColabService noteColabService;

    @PostMapping
    public ResponseEntity<NoteColab> addParticipant(@RequestBody NoteColab participant) {
        NoteColab savedParticipant = noteColabService.saveParticipant(participant);
        return ResponseEntity.ok(savedParticipant);
    }

    @GetMapping("/note/{noteId}")
    public ResponseEntity<List<NoteColab>> getParticipantsByNoteId(@PathVariable Integer noteId) {
        List<NoteColab> participants = noteColabService.getParticipantsByNoteId(noteId);
        return ResponseEntity.ok(participants);
    }

    @DeleteMapping("/{participantId}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Integer participantId) {
        noteColabService.deleteParticipant(participantId);
        return ResponseEntity.ok().build();
    }
}