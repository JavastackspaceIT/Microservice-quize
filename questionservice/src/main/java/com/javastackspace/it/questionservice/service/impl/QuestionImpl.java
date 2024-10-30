package com.javastackspace.it.questionservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javastackspace.it.questionservice.entities.Question;
import com.javastackspace.it.questionservice.repository.QuestionRepository;
import com.javastackspace.it.questionservice.service.QuestionService;

@Service
public class QuestionImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question create(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> get() {

		return questionRepository.findAll();
	}

	@Override
	public Question questionById(Long id) {
		try {
			Optional<Question> question = questionRepository.findById(id);
			return question.get();
		} catch (Exception e) {

			return null;
		}
	}

	@Override
	public List<Question> getQuestionOfQuize(Long quizId) {
		// TODO Auto-generated method stub
		return questionRepository.findByQuizId(quizId);
	}

}
