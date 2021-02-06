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

@WebServlet("/updateTodo")
public class TodoTypeServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TodoDao todoDao = new TodoDao();
        TodoDto todoDto = new TodoDto();
        todoDto.setId(Long.valueOf(req.getParameter("id")));
        todoDto.setType(req.getParameter("type"));

        try {
            todoDao.updateTodo(todoDto);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
