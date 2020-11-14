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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/query")
public class QueryController {

    private final ModelMapper modelMapper;
    private MovieService service;

    public QueryController(MovieService movieService, ModelMapper mapper) {
        this.service = movieService;
        this.modelMapper = mapper;
    }

    @GetMapping
    public String apiRouteTest() {
        return "Api its Work!";
    }

    @GetMapping("{queryValue}")
    public List<MovieDto> getMovieByname(@Nullable @PathVariable String queryValue) {
        List<Movie> entityList = service.getMoviesByName(queryValue);
        List<MovieDto> result = mapList(entityList, MovieDto.class);
        return result;
    }

    <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
    

}
