package com.morandev.movieapp.controller;

import com.morandev.movieapp.model.Movie;
import com.morandev.movieapp.service.IMovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/movies")
class MovieController {
    private final IMovieService movieService;

    @Autowired
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Collection<Movie>> all() {
        return new ResponseEntity<>( movieService.all(), HttpStatus.OK );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> findById(@PathVariable String id) {
        if (movieService.findById(id).isPresent())
            return new ResponseEntity<>(movieService.findById(id).get(), HttpStatus.OK);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
