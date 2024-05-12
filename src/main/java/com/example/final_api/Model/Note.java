package com.example.final_api.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="note_ID", nullable = false)
    private Integer noteID;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="content", nullable = false)
    private String content;
    @Column(name="is_collaborative", nullable = false)
    private Boolean isCollab;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ID", nullable = false)
    private User user;

//    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<CollabNote> collabNotes;

    public Note() {
    }

    public Note(Integer noteID, String title, String content, Boolean isCollab) {
        this.noteID = noteID;
        this.title = title;
        this.content = content;
        this.isCollab = isCollab;
    }

    public Integer getNoteID() {
        return noteID;
    }

    public void setNoteID(Integer noteID) {
        this.noteID = noteID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getCollab() {
        return isCollab;
    }

    public void setCollab(Boolean collab) {
        isCollab = collab;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public Set<CollabNote> getCollabNotes() {
//        return collabNotes;
//    }
//
//    public void setCollabNotes(Set<CollabNote> collabNotes) {
//        this.collabNotes = collabNotes;
//    }

    @Override
    public String toString() {
        return "Note{" +
                "noteID=" + noteID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", isCollab=" + isCollab +
                '}';
    }
}
