package com.overmovies.api.models.repositories;

import java.util.List;

import com.overmovies.api.models.entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleIgnoreCaseContaining(String name);
}
