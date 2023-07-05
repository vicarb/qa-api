package com.example.myproject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questions")
public class QuestionAnswer {
    @Id
    private String id;

    private String question;
    private String answer;
    private String category;

    public QuestionAnswer() {
        // Default constructor
    }

    public QuestionAnswer(String question, String answer, String category) {
        this.question = question;
        this.answer = answer;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
