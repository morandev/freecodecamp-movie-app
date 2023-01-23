package com.morandev.movieapp.service;

import com.morandev.movieapp.model.Review;

public interface IReviewService {
    Review add(String reviewBody, String imdbId);
}
