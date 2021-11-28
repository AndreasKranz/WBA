package com.example.notendurchschnitt2.Note.repository;

import com.example.notendurchschnitt2.Note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}
