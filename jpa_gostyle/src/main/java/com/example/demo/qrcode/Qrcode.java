package com.example.demo.qrcode;

import com.example.demo.article.Article;

import javax.persistence.*;

@Entity
public class Qrcode {
    @Id
    String id;
    int reduction;
    //Article article;
    @OneToOne(mappedBy = "qrcode", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    public Article article;

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Qrcode() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        if(reduction <= article.getPrix()){
            System.out.println("Le prix de reduction est normal");
            this.reduction = reduction;
        }
        else{
            System.out.println("Le prix de reduction n est pas normal car elle est supétieur aux prix de vente");
            this.reduction = 20;
        }
    }
}
