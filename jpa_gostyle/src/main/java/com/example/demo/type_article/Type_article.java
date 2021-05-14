package com.example.demo.type_article;

import com.example.demo.article.Article;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Type_article {
    @Id
    int id;
    String libelle;
    @OneToMany(mappedBy = "t_article", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Collection<Article> articles = new ArrayList<Article>();

    public Collection<Article> getArticles() {
        return articles;
    }

    public void setArticles(Collection<Article> articles) {
        this.articles = articles;
    }

    public void addArticle_TypeArticle(Article article ){
        this.getArticles().add(article);
        article.t_article = this;
    }

    public Type_article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
