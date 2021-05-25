package com.sene.repository.jdbc;

import com.sene.entities.Article;
import com.sene.repository.ArticleRepository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ArticleJdbcRepository implements ArticleRepository {
    @Override
    public Article addArticle(Article article, int id) {
        SimpleDateFormat formater=new SimpleDateFormat("yyyy-MM-dd");
        Connection connection=SingletonConnection.getConnection();
        String query="INSERT INTO Article(titre,contenu,date,image,user_id) VALUES(?,?,?,?,?)";
        System.out.println("add aticle 1");
        try{
            PreparedStatement ps=connection.prepareStatement(query);

            ps.setString(1,article.getTitre());
            ps.setString(2,article.getContenu());
            //ps.setDate(3, Date.valueOf(formater.format(article.getDate())));
            ps.setDate(3,Date.valueOf(formater.format(article.getDate())));
            ps.setString(4,article.getImage());
            ps.setInt(5,id);
            //on excute la requete preparer
            ps.executeUpdate();
            //on ferme le statement
            ps.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public Article[] getAll() {
        List<Article> articles=new ArrayList<>();
        Connection connection = SingletonConnection.getConnection();
        String query="SELECT * FROM Article";
        try {

            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){

                int id=rs.getInt("id");
                String titre=rs.getString("titre");
                String contenu=rs.getString("contenu");
                Date date=rs.getDate("date");
                String image=rs.getString("image");
                int user_id=rs.getInt("user_id");
                Article article=new Article(id,titre,contenu,date,image,user_id);

                articles.add(article);
            }
            return articles.toArray(new Article[0]);
        } catch (SQLException throwables) {
            return new Article[0];
        }

    }

    @Override
    public Article getArticle(int id) {
        Connection connection=SingletonConnection.getConnection();
        String query="SELECT * FROM Article WHERE id="+id;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs=preparedStatement.executeQuery();
            Article article=new Article();
            while(rs.next()){
                int idArticle=rs.getInt("id");
                String titre=rs.getString("titre");
                String contenu=rs.getString("contenu");
                Date date=rs.getDate("date");
                String image=rs.getString("image");
                int user_id=rs.getInt("user_id");

                article=new Article(idArticle,titre,contenu,date,image,user_id);

            }
            return article;
        } catch (SQLException throwables) {
            return new Article();
        }

    }

    @Override
    public Article updateArticle(Article article) {
        return null;
    }

    @Override
    public void deleteArticle(int id) {
        Connection connection=SingletonConnection.getConnection();
        String query="DELETE FROM Article WHERE id=?";

        try {
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
