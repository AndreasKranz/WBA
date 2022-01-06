package com.example.jokeservice.repository;

import com.example.jokeservice.model.Joker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JokerRepository extends JpaRepository<Joker, Integer> {

    Optional<Joker> findByName(String name);

    //Joker findByName(String name);
}
