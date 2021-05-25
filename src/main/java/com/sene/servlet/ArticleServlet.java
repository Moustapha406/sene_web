package com.sene.servlet;


import com.sene.entities.Article;
import com.sene.repository.ArticleRepository;
import com.sene.repository.jdbc.ArticleJdbcRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class ArticleServlet extends HttpServlet {
    private ArticleRepository articleRepository;
    @Override
    public void init() throws ServletException {
        articleRepository=new ArticleJdbcRepository();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path=request.getServletPath();
        if(path.equals("/articles/detail")){
            int id=Integer.parseInt(request.getParameter("id"));
            Article article=articleRepository.getArticle(id);
            request.setAttribute("article",article);
            this.getServletContext().getRequestDispatcher("/articles/index").forward(request,response);
        }if(path.equals("/articles.delete")){
            int id=Integer.parseInt(request.getParameter("id"));
            articleRepository.deleteArticle(id);
            response.sendRedirect("home/home.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titre=request.getParameter("titre");
        String contenu=request.getParameter("contenu");
        Date date=new Date();
        String image=request.getParameter("image");
        Article article=articleRepository.addArticle(new Article(titre,contenu,date,image),1);
        response.sendRedirect("home/home.jsp");
    }
}
