package com.javastackspace.it.questionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javastackspace.it.questionservice.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	List<Question> findByQuizId(Long quizId);
}
