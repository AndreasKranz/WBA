package com.example.notendurchschnitt.repository;

import com.example.notendurchschnitt.model.Noten;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotenRepository extends JpaRepository<Noten, Integer>{
}
