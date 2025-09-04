package com.noteApp.service;



import java.util.List;
import com.noteApp.model.Note;

public interface NoteService {
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note createNote(Note note);
    Note updateNote(Long id, Note note);
    void deleteNote(Long id);
    Note getNoteByShareId(String shareId);
}
