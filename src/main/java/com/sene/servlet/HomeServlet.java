package com.sene.servlet;

import com.sene.entities.Article;
import com.sene.repository.ArticleRepository;
import com.sene.repository.jdbc.ArticleJdbcRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeServlet extends HttpServlet {
    private ArticleRepository articleRepository;

    @Override
    public void init() throws ServletException {
        articleRepository=new ArticleJdbcRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        if(path.equals("/") || path.equals("/home")){
            Article[] articles=articleRepository.getAll();

            request.setAttribute("articles",articles);
            request.getRequestDispatcher("home/home.jsp").forward(request,response);
        }

    }
}
