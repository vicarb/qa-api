package com.example.myproject.controller;

import com.example.myproject.model.QuestionAnswer;
import com.example.myproject.service.QuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question-answers")
public class QuestionAnswerController {
    private final QuestionAnswerService questionAnswerService;

    @Autowired
    public QuestionAnswerController(QuestionAnswerService questionAnswerService) {
        this.questionAnswerService = questionAnswerService;
    }

    @GetMapping
    public List<QuestionAnswer> getAllQuestionAnswers() {
        return questionAnswerService.getAllQuestionAnswers();
    }

    @PostMapping
    public ResponseEntity<QuestionAnswer> createQuestionAnswer(@RequestBody QuestionAnswer questionAnswer) {
        QuestionAnswer createdQuestionAnswer = questionAnswerService.createQuestionAnswer(questionAnswer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQuestionAnswer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionAnswer> getQuestionAnswerById(@PathVariable("id") String id) {
        QuestionAnswer questionAnswer = questionAnswerService.getQuestionAnswerById(id);
        if (questionAnswer != null) {
            return ResponseEntity.ok(questionAnswer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionAnswer> updateQuestionAnswer(@PathVariable("id") String id, @RequestBody QuestionAnswer questionAnswer) {
        questionAnswer.setId(id);
        QuestionAnswer updatedQuestionAnswer = questionAnswerService.updateQuestionAnswer(questionAnswer);
        if (updatedQuestionAnswer != null) {
            return ResponseEntity.ok(updatedQuestionAnswer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionAnswer(@PathVariable("id") String id) {
        questionAnswerService.deleteQuestionAnswerById(id);
        return ResponseEntity.noContent().build();
    }
    
    // CORS configuration
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().build();
    }
}
