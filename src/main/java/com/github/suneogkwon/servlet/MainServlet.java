package com.github.suneogkwon.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.suneogkwon.dao.TodoDao;
import com.github.suneogkwon.dto.TodoDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDao todoDao = new TodoDao();
        List<TodoDto> list = new ArrayList<>();
        List<TodoDto> todoList = new ArrayList<>();
        List<TodoDto> doingList = new ArrayList<>();
        List<TodoDto> doneList = new ArrayList<>();

        try {
            list = todoDao.getTodo();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        list.forEach(todoDto -> {
            switch (todoDto.getType()){
                case "TODO":
                    todoList.add(todoDto);
                    break;
                case "DOING":
                    doingList.add(todoDto);
                    break;
                default:
                    doneList.add(todoDto);
            }
        });

        req.setAttribute("todoList", todoList);
        req.setAttribute("doingList", doingList);
        req.setAttribute("doneList", doneList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");

        requestDispatcher.forward(req,resp);
    }
}
