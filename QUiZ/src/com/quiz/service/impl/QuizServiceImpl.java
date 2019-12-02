package com.quiz.service.impl;

import com.quiz.model.Quiz;
import com.quiz.service.QuizService;
import com.quiz.utils.AnswerDb;
import com.quiz.utils.QuestionDb;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuizServiceImpl implements QuizService {
    public static List<Quiz> quizList;

    @Override
    public void getQuiz() {
        List<Quiz> quizzes = new ArrayList<>();

        try {
            quizzes = QuestionDb.findAll();
            for (Quiz quiz: quizzes){
                quiz.setAnswers(AnswerDb.findByQuestionId(quiz.getQuestion().getId_question()));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        quizList = quizzes;
    }

    @Override
    public void creteQuiz() {
        if (quizList==null){
            getQuiz();
        }
    }
}
