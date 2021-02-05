<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.github.suneogkwon.dto.TodoDto" %><%--
  Created by IntelliJ IDEA.
  User: kwon
  Date: 2021-02-02
  Time: 오후 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!

%>
<html>
<head>
    <title>To do list</title>
    <link rel="stylesheet" href="statics/css/common.css">
</head>
<body>
    <div class="wrapper">
        <div class="top-div">
            <h2 class="title">나의 해야할 일들</h2>
            <a href="/todoForm" class="add-button" >새로운 TODO 등록</a>
        </div>
        <div>
            <ul>
                <%
                    List<TodoDto> list = (List<TodoDto>) request.getAttribute("todoList");
                %>
                <li>
                    <p class="sub-title">TODO</p>
                </li>
                <li>
                    <p class="sub-title">TODO</p>
                </li>
                <li>
                    <p class="sub-title">TODO</p>
                </li>
            </ul>
            <%=list%>
        </div>
    </div>
</body>
</html>
