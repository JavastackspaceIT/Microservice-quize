package com.javastackspaceIt.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javastackspaceIt.quiz.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
