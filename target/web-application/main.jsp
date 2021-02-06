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
    <link rel="stylesheet" href="statics/css/normalize.css">
    <link rel="stylesheet" href="statics/css/common.css">
</head>
<body>
<div class="wrapper">
    <div class="top-div">
        <h2 class="title">My Todo List</h2>
        <a href="/todoForm" class="add-button">Add new work to do</a>
    </div>
    <ul id="todo-list">
        <li>
            <h2 class="sub-title">TODO</h2>
            <%
                List<TodoDto> todoList = (List<TodoDto>) request.getAttribute("todoList");

                if (todoList != null) {
                    for (TodoDto todoDto : todoList) { %>
            <div class="todo-content-wrap">
                <h3 class="todo-title"><%=todoDto.getTitle()%>
                </h3>
                <p class="todo-content">
                    등록날짜:<%=todoDto.getRegdate()%>, <%=todoDto.getName()%>, 우선순위 <%=todoDto.getSequence()%>
                    <button class="update-btn" onclick="updateTodo(<%=todoDto.getId()%>, '<%=todoDto.getType()%>', this)">→</button>
                </p>
            </div>
            <% }
            }
            %>
        </li>
        <li>
            <h2 class="sub-title">DOING</h2>
            <%
                List<TodoDto> doingList = (List<TodoDto>) request.getAttribute("doingList");

                if (doingList != null) {
                    for (TodoDto todoDto : doingList) { %>
            <div class="todo-content-wrap">
                <h3 class="todo-title"><%=todoDto.getTitle()%>
                </h3>
                <p class="todo-content">
                    등록날짜:<%=todoDto.getRegdate()%>, <%=todoDto.getName()%>, 우선순위 <%=todoDto.getSequence()%>
                    <button class="update-btn" onclick="updateTodo(<%=todoDto.getId()%>, '<%=todoDto.getType()%>', this)">→</button>
                </p>
            </div>
            <% }
            }
            %>
        </li>
        <li>
            <h2 class="sub-title">DONE</h2>
            <%
                List<TodoDto> doneList = (List<TodoDto>) request.getAttribute("doneList");

                if (doneList != null) {
                    for (TodoDto todoDto : doneList) { %>
            <div class="todo-content-wrap">
                <h3 class="todo-title"><%=todoDto.getTitle()%>
                </h3>
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
<script>
    let httpRequest;

    function updateTodo(id, type, object) {
        let parentDiv = object.closest('div');
        let parentLi = object.closest('li');
        let parentUl = document.getElementById('todo-list');

        httpRequest = new XMLHttpRequest();

        httpRequest.onreadystatechange = function(){
            if (httpRequest.readyState === XMLHttpRequest.DONE) {
                if(httpRequest.status === 200){
                    parentLi.removeChild(parentDiv);
                    parentLi.nextElementSibling.appendChild(parentDiv);
                    if(parentUl.lastChild.previousSibling === parentLi.nextElementSibling) {
                        console.log(parentUl.lastChild.previousSibling)
                        parentUl.lastChild.previousSibling.removeChild(object);
                    }
                }
            }
        }

        httpRequest.open('POST', '/updateTodo?id=' + id + '&type=' + type);
        httpRequest.send();
    }

    function refreshTable() {
        let table = document.getElementById('todo-list');
    }

</script>
</body>
</html>
