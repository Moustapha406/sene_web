package com.sene.repository.jdbc;

import com.sene.entities.User;
import com.sene.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserJdbcRepository implements UserRepository {
    @Override
    public User addUser(User user) {
        Connection connection=SingletonConnection.getConnection();
        String query="INSERT INTO user (nom,prenom,username,email,password,telephone,role VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(query);
            ps.setString(1,user.getNom());
            ps.setString(2,user.getPrenom());
            ps.setString(3,user.getUsername());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getPassword());
            ps.setString(6,user.getTelephone());
            ps.setString(7,user.getRole());
            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User login(String username,String password) {
        Connection connection=SingletonConnection.getConnection();
        String query="SELECT * FROM user WHERE username="+username+" AND password="+password;
        User user =new User();
        try{
            PreparedStatement ps=connection.prepareStatement(query);
            ResultSet rs=ps.executeQuery();

            while (rs.next()){
                int id=rs.getInt("id");
                String nom=rs.getString("nom");
                String prenom=rs.getString("prenom");
                String usern=rs.getString("username");
                String email=rs.getString("email");
                String pass=rs.getString("password");
                String telephone=rs.getString("telephone");
                String role=rs.getString("role");

                user=new User(id,nom,prenom,usern,email,pass,telephone,role);
            }
            return user;
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
            return new User();
        }

    }
}
