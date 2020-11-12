package com.overmovies.api.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    
    private Long id;
    @NotEmpty
    private String title;
    private String posterPath;
    @NotEmpty
    private String genre;
    @NotEmpty
    private String synopsis;
    private String releaseDate;
    private String classification;
    private String producer;
    private String duration;
    private String budget;
    private String gateMoney;

}
