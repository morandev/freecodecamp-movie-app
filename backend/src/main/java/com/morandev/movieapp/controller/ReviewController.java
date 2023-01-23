package com.morandev.movieapp.controller;

import com.morandev.movieapp.model.Review;
import com.morandev.movieapp.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private final IReviewService service;

    @Autowired
    public ReviewController(IReviewService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Review> add(@RequestBody Map<String, String> _review) {
        return new ResponseEntity<>(service.add(_review.get("reviewBody"), _review.get("imdbId")), HttpStatus.OK);
    }
}
