<%--
  Created by IntelliJ IDEA.
  User: Hoang
  Date: 5/22/2021
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/stylesheets/login.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/stylesheets/responsive/login-resp.css" />
</head>
<body>
<div id="sign_up-link">
    <p>Bạn đã có tài khoản chưa?
        <a href="sign-up" class="sign_up-btn">Đăng kí</a>
    </p>
</div>

<div id="content">
    <h2>Travello</h2>
    <h3>Chào bạn!</h3>
    <div class="form-control">
        <form action="log-in" method="post">
            <div class="form-email">

                <label for="email">Email</label>
                <input type="email" placeholder="bruce@wayne.com" name="email" id="email" required>
            </div>
            <div class="form-pass">

                <label for="password">Mật khẩu</label>
                <input type="password" placeholder="Gồm ít nhất 6 kí tự" name="password" id="password" minlength="6" maxlength="25" required>
            </div>
            <a href="">Quên mật khẩu</a>
            <c:if test="${error}">
                <p>Email hoặc mật khẩu không đúng.</p>
            </c:if>
            <input type="submit" value="Đăng nhập">
        </form>
    </div>
</div>
</body>
</html>
