package com.example.final_api.Services;

import com.example.final_api.Model.NoteColab;
import com.example.final_api.Repos.NoteColabRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NoteColabService {

    private NoteColabRepos noteColabRepos;

    @Autowired
    public NoteColabService(NoteColabRepos noteColabRepos) {
        this.noteColabRepos = noteColabRepos;
    }

    public NoteColab saveParticipant(NoteColab participant) {
        return noteColabRepos.save(participant);
    }

    public List<NoteColab> getParticipantsByNoteId(Integer noteId) {
        return noteColabRepos.findByNote_NoteID(noteId);
    }

    public void deleteParticipant(Integer participantId) {
        noteColabRepos.deleteById(participantId);
    }
}
