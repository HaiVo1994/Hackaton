package com.quiz.model;

import java.util.List;

public class Quiz {
    Question question;
    List<Answer> answers;

    public Quiz() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean checkAnswer(int answerId){
        for (Answer answer : this.answers){
            if (answer.getId_answer() == answerId){
                return answer.isState();
            }
        }
        return false;
    }
}
