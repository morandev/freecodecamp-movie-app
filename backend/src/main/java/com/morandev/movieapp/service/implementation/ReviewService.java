package com.morandev.movieapp.service.implementation;

import com.morandev.movieapp.model.Movie;
import com.morandev.movieapp.model.Review;
import com.morandev.movieapp.repository.IReviewRepository;
import com.morandev.movieapp.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService implements IReviewService {
    private final IReviewRepository repository;
    private final MongoTemplate template;

    @Autowired
    public ReviewService(IReviewRepository repository, MongoTemplate template) {
        this.repository = repository;
        this.template = template;
    }

    @Override
    public Review add(String reviewBody, String imdbId) {
        Review _review = repository.insert(new Review(reviewBody ));

        template.update(Movie.class)
                .matching(Criteria.where("imdbId")
                .is(imdbId))
                .apply(new Update().push("reviewIds").value(_review))
                .first();

        return _review;
    }
}
