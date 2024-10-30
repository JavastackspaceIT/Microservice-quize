package com.javastackspace.it.questionservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javastackspace.it.questionservice.bean.Error;
import com.javastackspace.it.questionservice.entities.Question;
import com.javastackspace.it.questionservice.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	
	@PostMapping
	public Question create(@RequestBody Question question) {
		
		return questionService.create(question);
	}
	
	
	@GetMapping(value="/all")
	public List<Question> all(){
		
		return questionService.get();
	}
	
	@GetMapping(value="/{questionId}")
	public ResponseEntity<?> findByQuestionId(@PathVariable Long questionId) {
		
		Question question=questionService.questionById(questionId);
		if(question!=null) {
			return new ResponseEntity<Question>(question, HttpStatus.OK);
		}else {
			
			return new ResponseEntity<Error>(new Error("SPCIT01", "Record not found for given id"),HttpStatus.OK);
		}
		
	}
	
	
}
