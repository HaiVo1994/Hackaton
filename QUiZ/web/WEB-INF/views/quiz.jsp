<%--
  Created by IntelliJ IDEA.
  User: haivo1994
  Date: 30/11/2019
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quiz</title>
    <%@include file="/main-css.jsp" %>
    <style>
        label:active{
            background-color: rgba(103,24,15,0.76);
            color: rgba(103,101,99,0.76);
        }
    </style>
</head>
<body>
    <jsp:include page="/title.jsp"/>
    <div class="container">
        <div class="row text-center">
            <div class="col-12 m-2 img-block mt-5">
                <img class="shadow p-3 mb-5 bg-white rounded"
                    src="${requestScope["question"].getQuestion().getImage()}" alt="No Image">
            </div>
            <div class="col-12 m-2">
                <p>${requestScope["question"].getQuestion().getContent()}</p>
            </div>
        </div>
        <div class="row text-center">
            <div class="col-12">
                <form method="post">
                    <input type="number" name="questionNumber" hidden
                           value="${requestScope['questionNumber']}">
                    <div class="btn-group btn-group-toggle" data-toggle="buttons">
                        <input type="radio" name="answer" autocomplete="off"
                               value="0" checked hidden>
                        <c:forEach items="${requestScope['question'].getAnswers()}" var="answerList">
                            <label class="btn btn-info ml-1">
                                <input type="radio" name="answer"
                                       value="${answerList.getId_answer()}"> ${answerList.getAswer_content()}
                            </label>
                        </c:forEach>
                    </div>
                    <div class="m-5">
                        <input type="submit" value="Xem Câu Trả Lời" class="btn btn-warning">
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
