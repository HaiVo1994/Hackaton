<%--
  Created by IntelliJ IDEA.
  User: haivo1994
  Date: 30/11/2019
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Description</title>
    <%@include file="/main-css.jsp" %>
</head>
<body>
    <jsp:include page="/title.jsp"/>
    <div class="container">
        <div class="row text-center">
            <div class="col-12 m-2 img-block">
                <img class="shadow p-3 mb-5 bg-white rounded"
                     src="${requestScope['img']}" alt="No Image">
            </div>
            <div class="col-12 m-2">
                ${requestScope['description']}
            </div>
            <div class="col-12 m-2 text-center">
                <c:choose>
                    <c:when test="${requestScope['result']}">
                        <p class="text-info">
                            Câu trả lời chính xác!
                        </p>
                    </c:when>
                    <c:otherwise>
                        <p class="text-danger">
                            Câu trả lời sai!
                        </p>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="col-12 m-2 text-center">
                <a href="question" class="btn btn-success">Tiếp Tục ></a>
            </div>
        </div>
    </div>
</body>
</html>
