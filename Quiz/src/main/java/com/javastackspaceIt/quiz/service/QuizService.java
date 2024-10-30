package com.javastackspaceIt.quiz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javastackspaceIt.quiz.dto.QuizeDTO;
import com.javastackspaceIt.quiz.entity.Question;
import com.javastackspaceIt.quiz.entity.Quiz;
import com.javastackspaceIt.quiz.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
	private QuizRepository repository;

	@Autowired
	private QuestionClient questionClient;
	public Quiz addQuiz(Quiz quiz) {

		try {
			repository.save(quiz);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return quiz;
	}

	public Quiz findByQuizId(String quizId) {

		Optional<Quiz> quiz = repository.findById(Long.parseLong(quizId));
		if (quiz.isPresent()) {
			Question questions=questionClient.find(quiz.get().getId());
			List<Question> questio=new ArrayList<>();
			questio.add(questions);
			quiz.get().setQuestions(questio);
			return quiz.get();
		}
		return null;
	}

	public List<Quiz> findAll() {

		List<Question> questions=questionClient.findAll();
		
		List<Quiz> quize=repository.findAll();
		
		System.out.println("questions"+ questions);
		
		return quize;
		
		
	}

	public String save(QuizeDTO quizeDTO) {

		ObjectMapper objectMapper = new ObjectMapper();
		Quiz quiz = objectMapper.convertValue(quizeDTO, Quiz.class);

		System.out.println("quize date : " + quiz);

		return quiz.getTitle();
	}
}
