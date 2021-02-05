<%@ page import="com.github.suneogkwon.dto.TodoDto" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: kwon
  Date: 2021-02-02
  Time: 오후 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
            <ul id="todo-list">
                <li>
                    <div class="sub-title">
                        <h2>TODO</h2>
                    </div>
                    <%
                        List<TodoDto> todoList = (List<TodoDto>) request.getAttribute("todoList");

                        if(todoList != null){
                        for (TodoDto todoDto : todoList) { %>
                            <div class="todo-content-wrap">
                                <h3 class="todo-title"><%=todoDto.getTitle()%></h3>
                                <p class="todo-content">
                                    등록날짜:<%=todoDto.getRegdate()%>, <%=todoDto.getName()%>, 우선순위 <%=todoDto.getSequence()%>
                                </p>
                                <button class="update-btn" onclick="updateTodo()">→</button>
                            </div>
                        <% }
                        }
                    %>
                </li>
                <li>
                    <div class="sub-title">
                        <h2>DOING</h2>
                    </div>
                    <%
                    List<TodoDto> doingList = (List<TodoDto>) request.getAttribute("doingList");

                    if(doingList != null){
                    for (TodoDto todoDto : doingList) { %>
                    <div class="todo-content-wrap">
                        <h3 class="todo-title"><%=todoDto.getTitle()%></h3>
                        <p class="todo-content">
                            등록날짜:<%=todoDto.getRegdate()%>, <%=todoDto.getName()%>, 우선순위 <%=todoDto.getSequence()%>
                        </p>
                        <button class="update-btn" onclick="updateTodo()">→</button>
                    </div>
                    <% }
                    }
                    %>
                </li>
                <li>
                    <div class="sub-title">
                        <h2>DONE</h2>
                    </div>
                    <%
                        List<TodoDto> doneList = (List<TodoDto>) request.getAttribute("doneList");

                        if(doneList != null){
                        for (TodoDto todoDto : doneList) { %>
                    <div class="todo-content-wrap">
                        <h3 class="todo-title"><%=todoDto.getTitle()%></h3>
                        <p class="todo-content">
                            등록날짜:<%=todoDto.getRegdate()%>, <%=todoDto.getName()%>, 우선순위 <%=todoDto.getSequence()%>
                        </p>
                    </div>
                    <% }
                    }
                    %>
                </li>
            </ul>
        </div>
    </div>
<script>
    function updateTodo(){

    }
</script>
</body>
</html>
