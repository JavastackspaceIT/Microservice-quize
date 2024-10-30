package com.javastackspaceIt.quiz.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javastackspaceIt.quiz.entity.Question;

@FeignClient(name="QUESTION-SERVICE")
public interface QuestionClient {

	@GetMapping("/question/{questionId}")
	Question find(@PathVariable Long questionId);
	@GetMapping("/question/all")
	List<Question> findAll();
}
