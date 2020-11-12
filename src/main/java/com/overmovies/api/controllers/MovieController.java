package com.overmovies.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.overmovies.api.dto.MovieDto;
import com.overmovies.api.models.entities.Movie;
import com.overmovies.api.services.MovieService;

import org.modelmapper.ModelMapper;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/movies")
public class MovieController {
    
    private ModelMapper modelMapper;
    private MovieService movieService;

    public MovieController(MovieService service, ModelMapper modelMapper) {
        this.movieService = service;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<MovieDto> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        List<MovieDto> result = mapList(movies, MovieDto.class);
        return result;
    }

    @GetMapping("{id}")
    public MovieDto getMovieById(@Nullable @PathVariable Long id) {
        Movie entity = movieService.getMovieById(id);
        MovieDto result = modelMapper.map(entity, MovieDto.class);
        return result;
    }

    @PostMapping
    @ResponseBody
    public Movie addMovie(@RequestBody MovieDto dto) {
        Movie entity = modelMapper.map(dto, Movie.class);
        return movieService.save(entity);
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
          .stream()
          .map(element -> modelMapper.map(element, targetClass))
          .collect(Collectors.toList());
    }

}
