package com.sene.entities;

import java.util.Date;

public class Commentaire {
    private long id;
    private String libelle;
    private Date date;
    private Article article;

    public Commentaire() {
    }

    public Commentaire(String libelle, Date date, Article article) {
        this.libelle = libelle;
        this.date = date;
        this.article = article;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
