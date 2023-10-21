package com.example.wiremock.movieapp.service;

import com.example.openapi.model.Movie;
import lombok.extern.slf4j.Slf4j;
import com.example.openapi.api.DefaultApi;

import java.util.List;

@Slf4j
public class MoviesRestClient {

    private final DefaultApi api;

    public MoviesRestClient(DefaultApi api) {
        this.api = api;
    }

    public List<Movie> retrieveAllMovies() {
        return api.movieserviceV1AllMoviesGet().getBody();
    }

    public Movie retrieveMovieById(Integer movieId) {
        return api.movieserviceV1MovieIdGet(String.valueOf(movieId)).getBody();
    }

    public List<Movie> retrieveMoviebyName(String name) {
        return api.movieserviceV1MovieNameGet(name).getBody();
    }

    public List<Movie> retrieveMoviebyYear(Integer movieYear) {
        return api.movieserviceV1MovieYearGet(movieYear).getBody();
    }

    public Movie addMovie( Movie newMovie){
        return api.movieserviceV1MoviePost(newMovie).getBody();
    }

    public Movie updateMovie(Integer movieId, Movie movie){
        return api.movieserviceV1MovieIdPut(String.valueOf(movieId), movie).getBody();
    }

    public void deleteMovie(Integer movieId){
        api.movieserviceV1MovieIdDelete(String.valueOf(movieId)).getBody();
    }
}
