package com.example.demo;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleRepository;
import com.example.demo.type_article.Type_article;
import com.example.demo.type_article.Type_articleRepository;
import com.example.demo.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ArticleTest {
    //find me CardRepository and give me access
    @Autowired
    public ArticleRepository articlerepo;
    //find me CardRepository and give me access
    @Autowired
    public Type_articleRepository type_article_repo;

    //Test on the Controller class
    @Test
    void Test_Create_or_Modify() {
        //Arrange
        //Create a class to be implemented in database
        Article art1 = new Article();
        Type_article t_article_created = new Type_article();

        //Act
        //Set data
        art1.setId(2);
        art1.setPrix(10);
        art1.setName("Mini Shirt");

        t_article_created.setId(1);
        t_article_created.setLibelle("Jean");
        //Link class
        t_article_created.addArticle_TypeArticle(art1);
        art1.setT_article(t_article_created);
        //Create the class in database
        Type_article type_article_enregistrer = type_article_repo.save(t_article_created);

        //Assert
        assert (type_article_repo.save(t_article_created) != null && art1.getName() != null && art1 instanceof Article) : "La classe de la variable n\'est pas une classe Article ou il y a un problème sur le repository";
    }
    @Test
    void Test_see_all() {
        //Arrange
        var it = articlerepo.findAll();
        var articles = new ArrayList<Article>();
        boolean result = false;
        //Act
        it.forEach(e -> articles.add(e));
        for(Article article : articles){
            if(article instanceof Article){
                result = true;
            }
            else{
                result = false;
                break;
            }
        }
        //Assert
        assert (articles != null && result == true): "La classe de la variable n\'est pas une liste classe Article";
    }
    @Test
    void Test_see_one_byid() {
        //Arrange
        int id = 2;
        boolean result = false;
        //Act
        var it = articlerepo.findById(id);
        if(it == null){
            result = false;
        }
        else{
            result = true;
        }
        //Assert
        assert (it != null && result == true) : "Le donnée n'existe pas dans la base de donnée donc la valeur trouvé est null";
    }
    @Test
    void Test_delete_one_byid() {
        //Arrange
        int id = 2;
        boolean result = false;
        //Act
        if(articlerepo != null){
            articlerepo.deleteById(id);
            result = true;
        }
        else{
            result = false;
        }
        //Assert
        assert (articlerepo != null && result == true) : "Le donnée n'a pas été supprimer car le donnée n'existe pas dans la bdd";
    }
}
