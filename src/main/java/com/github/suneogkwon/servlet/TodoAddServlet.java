package com.github.suneogkwon.servlet;

import com.github.suneogkwon.dao.TodoDao;
import com.github.suneogkwon.dto.TodoDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet("/todoAdd")
public class TodoAddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDao todoDao = new TodoDao();
        TodoDto todoDto = new TodoDto();
        String title = req.getParameter("title");
        String name = req.getParameter("name");
        String sequence = req.getParameter("sequence");
        String regdate = String.valueOf(LocalDate.now());

        todoDto.setTitle(title);
        todoDto.setName(name);
        todoDto.setSequence(Integer.parseInt(sequence));
        todoDto.setRegdate(regdate);

        try {
            todoDao.addTodo(todoDto);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        resp.sendRedirect("/main");
    }
}
