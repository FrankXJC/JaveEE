<%--
  Created by IntelliJ IDEA.
  User: ZT
  Date: 2020/6/26
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/iconfont.css"/>
    <title>管理员登录界面</title>

</head>
<body>
<<form action="${pageContext.request.contextPath}/adminLoginServlet" method="post">
    <div id="bigBox">
        <h1>管理员登录</h1>
        <div class="inputBox">
            <div class="inputText">
                <span class="iconfont icon-nickname"></span>
                <input type="text" name="a_name" placeholder="请输入账号"/>
            </div>
            <div class="inputText">
                <span class="iconfont icon-visible"></span>
                <input type="password" name="a_password" placeholder="请输入密码"/>
            </div>
        </div>
        <input class="loginButton" type="submit" value="登   录"/>
        <br>
        <br>
        <C:if test="${error != null}">
            <font color="red">用户名或密码错误</font>
        </C:if>


    </div>
</form>
</body>
</html>