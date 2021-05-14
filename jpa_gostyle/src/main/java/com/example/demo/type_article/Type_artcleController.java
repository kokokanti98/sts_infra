package com.example.demo.type_article;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Type_artcleController {
    //find me CardRepository and give me access
    @Autowired
    private Type_articleRepository type_article_repo;

    public Type_artcleController(Type_articleRepository type_article_repo) {
        this.type_article_repo = type_article_repo;
        //Create a class to be implemented in database
        Type_article t_article_created = new Type_article();
        t_article_created.setId(1);
        t_article_created.setLibelle("Jean");
        //Creation of class in database
        type_article_repo.save(t_article_created);
    }
    //Find by id
    @GetMapping("/t_article/{id}")
    @ResponseBody
    public Type_article findById(@PathVariable(value = "id") int id) {
        Type_article it = type_article_repo.findById(id).get();
        return it;
    }
    //find all
    @GetMapping("/t_articles")
    @ResponseBody
    public List<Type_article> findAll() {
        var it = type_article_repo.findAll();
        var type_articles = new ArrayList<Type_article>();
        it.forEach(e -> type_articles.add(e));
        return type_articles;
    }

    //Create or modify
    @PostMapping(value = "/t_articles/creer/{id}/{libelle}")
    public  Type_article Create_or_modify(@PathVariable (value = "id") int id,
                                           @PathVariable (value = "libelle") String libelle) {
        //Create a class to be implemented in database
        Type_article t_article_created = new Type_article();
        t_article_created.setId(id);
        t_article_created.setLibelle(libelle);

        Type_article t_article_enregistrer = type_article_repo.save(t_article_created);
        if(type_article_repo != null){
            System.out.println("Type article creer avec succès");
        }
        else{
            System.out.println("Creation impossible!! Erreur!");
        }
        return t_article_enregistrer;
    }

    //delete one by id
    @PostMapping(value = "/t_articles/supprimer/{id}")
    public  void  delete(@PathVariable (value = "id") int id) {
        if(type_article_repo != null){
            type_article_repo.deleteById(id);
            System.out.println("Article supprimer avec succès");
        }
        else{
            System.out.println("Suppresion impossible!! Erreur!");
        }
    }
}
