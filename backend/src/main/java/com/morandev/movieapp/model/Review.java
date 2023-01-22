package com.morandev.movieapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reviews")
@NoArgsConstructor
public class Review {
    @Id
    private ObjectId id;
    private String body;
}