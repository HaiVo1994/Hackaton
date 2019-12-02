package com.quiz.controller;

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

@WebServlet(name = "resultServlet")
public class resultServlet extends HttpServlet {
    private QuizService quizService = new QuizServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "":
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/result.jsp");
                try {
                    dispatcher.forward(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "reset":
                quizService.getQuiz();
                HttpSession session = request.getSession();
                session.setAttribute("point", 0);
                response.sendRedirect("question");
                break;
        }

    }
}
