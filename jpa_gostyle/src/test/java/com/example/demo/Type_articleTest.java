package com.example.demo;

import com.example.demo.type_article.Type_article;
import com.example.demo.type_article.Type_articleRepository;
import com.example.demo.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class Type_articleTest {
    //find me CardRepository and give me access
    @Autowired
    private Type_articleRepository type_article_repo;

    //Test on the Controller class
    @Test
    void Test_Create_or_Modify() {
        //Arrange
        //Create a class to be implemented in database
        Type_article t_article_created = new Type_article();
        //Act
        //Set data
        t_article_created.setId(1);
        t_article_created.setLibelle("Jean");
        //Create the class in database
        type_article_repo.save(t_article_created);
        //Assert
        assert (type_article_repo.save(t_article_created) != null && t_article_created.getLibelle() != null && t_article_created instanceof Type_article) : "La classe de la variable n\'est pas une classe Type_article ou il y a un problème sur le repository";
    }
    @Test
    void Test_see_all() {
        //Arrange
        var it = type_article_repo.findAll();
        var t_articles = new ArrayList<Type_article>();
        boolean result = false;
        //Act
        it.forEach(e -> t_articles.add(e));
        for(Type_article t_article : t_articles){
            if(t_article instanceof Type_article){
                result = true;
            }
            else{
                result = false;
                break;
            }
        }
        //Assert
        assert (t_articles != null && result == true): "La classe de la variable n\'est pas une liste classe Type_article";
    }
    @Test
    void Test_see_one_byid() {
        //Arrange
        int id = 1;
        boolean result = false;
        //Act
        var it = type_article_repo.findById(id);
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
        int id = 1;
        boolean result = false;
        //Act
        if(type_article_repo != null){
            type_article_repo.deleteById(id);
            result = true;
        }
        else{
            result = false;
        }
        //Assert
        assert (type_article_repo != null && result == true) : "Le donnée n'a pas été supprimer car le donnée n'existe pas dans la bdd";
    }
}
