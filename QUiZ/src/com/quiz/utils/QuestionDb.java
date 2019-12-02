package com.quiz.utils;

import com.quiz.model.Question;
import com.quiz.model.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDb {
    private static String getQuestion = "SELECT id_question,content,image,description FROM question " +
            "ORDER BY RAND();";
    public static List<Quiz> findAll() throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionQuiz.getSqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(getQuestion);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Quiz> quizzes = new ArrayList<>();

        while (resultSet.next()){
            Question question = new Question();
            question.setId_question(resultSet.getInt("id_question"));
            question.setContent(resultSet.getString("content"));
            question.setImage(resultSet.getString("image"));
            question.setDescription(resultSet.getString("description"));
            Quiz quiz = new Quiz();
            quiz.setQuestion(question);
            quizzes.add(quiz);
        }
        connection.close();
        return quizzes;
    }
}
