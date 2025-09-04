package com.noteApp.service;



import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.noteApp.exception.NoteNotFoundException;
import com.noteApp.model.Note;
import com.noteApp.repository.NoteRepository;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    @Override
    public Note createNote(Note note) {
        note.setShareId(UUID.randomUUID().toString());
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Long id, Note updatedNote) {
        return noteRepository.findById(id).map(note -> {
            note.setTitle(updatedNote.getTitle());
            note.setContent(updatedNote.getContent());
            note.setCreatorName(updatedNote.getCreatorName()); 
            return noteRepository.save(note);
        }).orElseThrow(() -> new NoteNotFoundException(id));
    }
    @Override
    public void deleteNote(Long id) {
        if(!noteRepository.existsById(id)) {
            throw new NoteNotFoundException(id);
        }
        noteRepository.deleteById(id);
    }

    @Override
    public Note getNoteByShareId(String shareId) {
        return noteRepository.findByShareId(shareId)
                .orElseThrow(() -> new NoteNotFoundException(shareId));
    }
}

