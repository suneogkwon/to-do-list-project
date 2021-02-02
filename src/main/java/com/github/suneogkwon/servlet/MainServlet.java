package com.github.suneogkwon.servlet;

import com.github.suneogkwon.dao.TodoDao;
import com.github.suneogkwon.dto.TodoDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDao todoDao = new TodoDao();
        try {
            List<TodoDto> list = todoDao.getTodo();
            req.setAttribute("todoList", list);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("main.jsp");

        requestDispatcher.forward(req,resp);
    }
}
