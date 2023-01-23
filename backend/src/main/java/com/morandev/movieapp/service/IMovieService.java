package com.morandev.movieapp.service;

import com.morandev.movieapp.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public interface IMovieService {
    Collection<Movie> all();
    Optional<Movie> findById(String id);
}
