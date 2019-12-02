<%--
  Created by IntelliJ IDEA.
  User: haivo1994
  Date: 30/11/2019
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
    <%@include file="/main-css.jsp" %>
</head>
<body>
    <jsp:include page="/title.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-12 text-center" style="margin-top: 100px;">
                <div>
                    <img
                        src="https://st2.depositphotos.com/1031330/9334/i/950/depositphotos_93348750-stock-photo-congratulation-3d-image.jpg"
                        alt="Not Found Image">
                </div>
                <div>
                    <h2 class="btn-success">
                        Your Point
                    </h2>
                    <h2 class="text-info mt-4">
                         ${sessionScope["point"]}
                    </h2>
                </div>
            </div>
            <div class="col-12 mt-4 text-center">
                <a href="finish?action=reset" class="btn btn-warning">Chơi Lại</a>
            </div>
        </div>
    </div>
</body>
</html>
