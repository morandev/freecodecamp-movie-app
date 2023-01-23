package com.morandev.movieapp.repository;

import com.morandev.movieapp.model.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReviewRepository extends MongoRepository<Review, ObjectId> {}
