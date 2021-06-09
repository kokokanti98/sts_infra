package com.example.demo.article;

import com.example.demo.type_article.Type_article;
import com.example.demo.type_article.Type_articleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ArticleController {
    //find me CardRepository and give me access
    @Autowired
    public ArticleRepository articlerepo;
    //find me CardRepository and give me access
    @Autowired
    public Type_articleRepository type_article_repo;

    public ArticleController(ArticleRepository articlerepo,Type_articleRepository type_article_repo) {
        this.articlerepo = articlerepo;
        this.type_article_repo = type_article_repo;
        //Creation of class
        Article art1 = new Article();
        art1.setId(2);
        art1.setPrix(10);
        art1.setName("Mini Shirt");
        //Creation of class in database
        articlerepo.save(art1);

    }

    //Find by id
    //ex: http://localhost:8089/article/5
    @GetMapping("/article/{id}")
    @ResponseBody
    public Article findById(@PathVariable(value = "id") int id) {
        Article it = articlerepo.findById(id).get();
        return it;
    }
    //find all
    @GetMapping("/articles")
    @ResponseBody
    public List<Article> findAll() {
        var it = articlerepo.findAll();
        var articles = new ArrayList<Article>();
        it.forEach(e -> articles.add(e));
        return articles;
    }

    //Create or modify
    //ex: http://localhost:8089/articles/creer/5/20000/Hello/1
    @PostMapping(value = "/articles/creer/{id}/{prix}/{name}/{id_type_article}")
    public  Article Create_or_modify(@PathVariable (value = "id") int id,
                                     @PathVariable (value = "prix") int prix,
                                     @PathVariable (value = "name") String name,
                                     @PathVariable (value = "id_type_article") int id_type_article) {
        //Create a class to be implemented in database
        Article article_created = new Article();
        article_created.setId(id);
        article_created.setPrix(prix);
        article_created.setName(name);

        //Find by id the other class in database
        Type_article t_article = type_article_repo.findById(id_type_article).get();

        //Link class
        t_article.addArticle_TypeArticle(article_created);
        article_created.setT_article(t_article);

        //Create the class in database
        Type_article type_article_enregistrer = type_article_repo.save(t_article);

        if(articlerepo != null){
            System.out.println("Article creer avec succès");
        }
        else{
            System.out.println("Creation impossible!! Erreur!");
        }
        return article_created;
    }

    //delete one by id
    @PostMapping(value = "/articles/supprimer/{id}")
    public  void  delete(@PathVariable (value = "id") int id) {
        if(articlerepo != null){
            articlerepo.deleteById(id);
            System.out.println("Article supprimer avec succès");
        }
        else{
            System.out.println("Suppresion impossible!! Erreur!");
        }
    }
}
