package com.quiz.controller;

import com.quiz.model.Quiz;
import com.quiz.service.QuizService;
import com.quiz.service.impl.QuizServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {
    private QuizService quizService = new QuizServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int questionNumber = Integer.parseInt(request.getParameter("questionNumber"));
        int answer = Integer.parseInt(request.getParameter("answer"));
        Quiz quiz = QuizServiceImpl.quizList.get(questionNumber);
        quiz.getQuestion().setSelected(answer);
        boolean check = quiz.checkAnswer(answer);

        HttpSession session = request.getSession();
        int point = 0;
        if (session.getAttribute("point")==null){
            session.setAttribute("point",point);
        }
        point = (int) session.getAttribute("point");
        if (check){
            point++;
            session.setAttribute("point",point);
        }

        request.setAttribute("description",
                quiz.getQuestion().getDescription());
        request.setAttribute("img", quiz.getQuestion().getImage());
        request.setAttribute("result", quiz.checkAnswer(answer));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/description.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        quizService.creteQuiz();
        List<Quiz> quizzes = QuizServiceImpl.quizList;
        Quiz quiz;
        int questionNumber = 0;
        do{
            quiz = quizzes.get(questionNumber);
            if (quiz.getQuestion().getSelected()!=0)
                questionNumber++;
        }while ((quiz.getQuestion().getSelected()!=0) && (questionNumber<quizzes.size()));

        if (questionNumber<quizzes.size()){
            request.setAttribute("question", quiz);
            request.setAttribute("questionNumber", questionNumber);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/quiz.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        else{
            response.sendRedirect("finish");
        }
    }
}
