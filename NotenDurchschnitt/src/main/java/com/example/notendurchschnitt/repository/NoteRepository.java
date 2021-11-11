package com.example.notendurchschnitt.repository;

import com.example.notendurchschnitt.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

}
