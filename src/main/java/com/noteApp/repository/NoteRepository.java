package com.noteApp.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noteApp.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findByShareId(String shareId);
}

