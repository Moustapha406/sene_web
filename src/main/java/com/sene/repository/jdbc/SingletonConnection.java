package com.sene.repository.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnection {

    private static Connection connection;



    static {
        try {
            String protocole = "jdbc:mysql:";
            String ip="localhost";
            String port="3306";
            String user="root";
            String password="";
            String db_name="sene-web";
            Class.forName("com.mysql.cj.jdbc.Driver");
            String chaine = protocole + "//" + ip + ":" + port + "/" + db_name;
            connection = DriverManager.getConnection(chaine,user,password);
            System.out.println("connection reussi");
        } catch (Exception e) {
            System.err.println("Une erreur est survenue lors de la création de la connexion: ");
            e.printStackTrace();
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}
