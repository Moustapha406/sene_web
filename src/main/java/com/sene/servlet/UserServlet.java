package com.sene.servlet;

import com.sene.entities.User;
import com.sene.repository.UserRepository;
import com.sene.repository.jdbc.UserJdbcRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserServlet extends HttpServlet {
    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        userRepository=new UserJdbcRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.getServletContext().getRequestDispatcher("/user/login").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String username=request.getParameter("username");
            String password=request.getParameter("password");
        User user=userRepository.login(username,password);
        if(user != null){
            this.getServletContext().getRequestDispatcher("/user/index").forward(request,response);
        }else{
            this.getServletContext().getRequestDispatcher("/user/login").forward(request,response);
        }
    }
}
