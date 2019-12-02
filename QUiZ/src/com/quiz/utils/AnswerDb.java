package com.quiz.utils;

import com.quiz.model.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDb {
    private static String findAnswerByQuestionId = "SELECT id_answer,aswer_content, state FROM Quiz.answer WHERE id_question = ?;";
    public static List<Answer> findByQuestionId(int id) throws SQLException, ClassNotFoundException {
        Connection connection = ConnectionQuiz.getSqlConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(findAnswerByQuestionId);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Answer> answers = new ArrayList<>();

        while (resultSet.next()){
            Answer answer = new Answer();
            answer.setId_answer(resultSet.getInt("id_answer"));
            answer.setAswer_content(resultSet.getString("aswer_content"));
            answer.setState(resultSet.getBoolean("state"));
            answers.add(answer);
        }
        connection.close();
        return answers;
    }
}
