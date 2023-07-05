package com.example.myproject.service;

import com.example.myproject.model.QuestionAnswer;
import com.example.myproject.repository.QuestionAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionAnswerService {
    private final QuestionAnswerRepository questionAnswerRepository;

    @Autowired
    public QuestionAnswerService(QuestionAnswerRepository questionAnswerRepository) {
        this.questionAnswerRepository = questionAnswerRepository;
    }

    public List<QuestionAnswer> getAllQuestionAnswers() {
        return questionAnswerRepository.findAll();
    }

    public QuestionAnswer getQuestionAnswerById(String id) {
        return questionAnswerRepository.findById(id).orElse(null);
    }

    public QuestionAnswer createQuestionAnswer(QuestionAnswer questionAnswer) {
        return questionAnswerRepository.save(questionAnswer);
    }

    public QuestionAnswer updateQuestionAnswer(QuestionAnswer questionAnswer) {
        return questionAnswerRepository.save(questionAnswer);
    }

    public void deleteQuestionAnswerById(String id) {
        questionAnswerRepository.deleteById(id);
    }
}
