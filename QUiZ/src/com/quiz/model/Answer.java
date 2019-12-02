package com.quiz.model;

public class Answer {
    int id_answer;
    String aswer_content;
    boolean state;

    public Answer() {
    }

    public Answer(int id_answer, String aswer_content, boolean state) {
        this.id_answer = id_answer;
        this.aswer_content = aswer_content;
        this.state = state;
    }

    public int getId_answer() {
        return id_answer;
    }

    public void setId_answer(int id_answer) {
        this.id_answer = id_answer;
    }

    public String getAswer_content() {
        return aswer_content;
    }

    public void setAswer_content(String aswer_content) {
        this.aswer_content = aswer_content;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
