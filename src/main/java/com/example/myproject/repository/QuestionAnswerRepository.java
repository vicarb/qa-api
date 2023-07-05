package com.example.myproject.repository;

import com.example.myproject.model.QuestionAnswer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionAnswerRepository extends MongoRepository<QuestionAnswer, String> {
    // Custom query methods, if needed
}
