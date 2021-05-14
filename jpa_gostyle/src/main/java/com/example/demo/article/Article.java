package com.example.demo.article;

import com.example.demo.qrcode.Qrcode;
import com.example.demo.type_article.Type_article;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Article {
    @Id
    int id;
    int prix;
    String name;
    @OneToOne
    public Qrcode qrcode;
    @JsonIgnore
    public Qrcode getQrcode() {
        return qrcode;
    }

    public void setQrcode(Qrcode qrcode) {
        this.qrcode = qrcode;
    }

    @ManyToOne
    public Type_article t_article;

    @JsonIgnore
    public Type_article getT_article() {
        return t_article;
    }

    public void setT_article(Type_article t_article) {
        this.t_article = t_article;
    }

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
