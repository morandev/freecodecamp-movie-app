package com.morandev.movieapp.service.implementation;

import com.morandev.movieapp.model.Movie;
import com.morandev.movieapp.repository.IMovieRepository;
import com.morandev.movieapp.service.IMovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {
    private final IMovieRepository movieRepository;

    @Autowired
    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Collection<Movie> all() {
        return this.movieRepository.findAll();
    }

    @Override
    public Optional<Movie> findById(String id) {
        return movieRepository.findByImdbId( id );
    }
}
