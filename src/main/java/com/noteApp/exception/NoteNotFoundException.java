package com.noteApp.exception;



public class NoteNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoteNotFoundException(Long id) {
        super("Note with ID " + id + " not found");
    }

    public NoteNotFoundException(String shareId) {
        super("Note with shareId " + shareId + " not found");
    }
}


