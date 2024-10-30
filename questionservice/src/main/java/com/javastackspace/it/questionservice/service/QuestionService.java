package com.javastackspace.it.questionservice.service;

import java.util.List;

import com.javastackspace.it.questionservice.entities.Question;

public interface QuestionService {

	Question create(Question question);

	List<Question> get();

	Question questionById(Long id);

	List<Question> getQuestionOfQuize(Long quizId);

}
