package com.overmovies.api.services;

import java.util.List;

import com.overmovies.api.models.entities.Movie;
import com.overmovies.api.models.repositories.MovieRepo;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepo repository;

    public MovieService(MovieRepo repo) {
        this.repository = repo;
    }

    public List<Movie> getAllMovies() {
        return repository.findAll();
    }

    public Movie getMovieById(Long id) {

        return repository.findById(id).get();

    }

    public Movie save(Movie movie) {
        Movie entity =  repository.save(movie);
        return entity;
    }

    public List<Movie> getMoviesByName(String name) {
        List<Movie> resultList = repository.findByTitleIgnoreCaseContaining(name);
        return resultList;
    }

}
