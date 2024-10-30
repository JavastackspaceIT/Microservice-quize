package com.javastackspaceIt.quiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javastackspaceIt.quiz.dto.QuizeDTO;
import com.javastackspaceIt.quiz.entity.Quiz;
import com.javastackspaceIt.quiz.service.QuizService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@PostMapping(value = "/save")
	private String saveQuiz(@RequestBody Quiz quiz) {

		quizService.addQuiz(quiz);

		return "success";
	}

	@GetMapping(value = "/{quizId}")
	private Quiz quize(@PathVariable String quizId) {

		return quizService.findByQuizId(quizId);
	}

	@GetMapping(value = "/all")
	private List<Quiz> saveQuiz() {

		return quizService.findAll();
	}

	@PostMapping(value = "/quizeDto")
	private ResponseEntity<?> quize(@Valid @RequestBody QuizeDTO quizeDTO) {
		quizService.save(quizeDTO);
		return new ResponseEntity<>("User registered Successfully!", HttpStatus.OK);
	}
}
