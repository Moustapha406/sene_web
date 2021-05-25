package com.sene.entities;

import java.util.Date;

public class Article {
    private int id;
    private String titre;
    private String contenu;
    private Date date;
    private String image;
    private int user;

    public Article() {
    }

    public Article(int id, String titre, String contenu, Date date, String image, int user) {
        this.id = id;
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
        this.image = image;
        this.user = user;
    }

    public Article(String titre, String contenu, Date date, String image) {
        this.titre = titre;
        this.contenu = contenu;
        this.date = date;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", contenu='" + contenu + '\'' +
                ", date=" + date +
                ", image='" + image + '\'' +
                ", user=" + user +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
