package com.example.demo.user;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleRepository;
import com.example.demo.type_article.Type_article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    //find me CardRepository and give me access
    @Autowired
    public UserRepository userepo;

    public UserController(UserRepository userepo) {
        this.userepo = userepo;
        //Create a class to be implemented in database
        User user_created = new User();
        user_created.setLogin("kanty");
        user_created.setPassword("admin");

        //Create the class in database
        userepo.save(user_created);
    }
    //Find by id
    //ex: http://localhost:8089/user/5
    @GetMapping("/user/{id}")
    @ResponseBody
    public User findById(@PathVariable(value = "id") String login) {
        User it = userepo.findById(login).get();
        return it;
    }
    //find all
    @GetMapping("/users")
    @ResponseBody
    public List<User> findAll() {
        var it = userepo.findAll();
        var users = new ArrayList<User>();
        it.forEach(e -> users.add(e));
        return users;
    }
    //Create or modify
    //ex: http://localhost:8089/users/creer/mike22/admin
    @PostMapping(value = "/users/creer/{login}/{password}")
    public  User Create_or_modify(@PathVariable (value = "login") String login,
                                     @PathVariable (value = "password") String pwd) {
        //Create a class to be implemented in database
        User user_created = new User();
        user_created.setLogin(login);
        user_created.setPassword(pwd);

        //Create the class in database
        User user_enregistrer = userepo.save(user_created);

        if(userepo != null){
            System.out.println("Utilisateur creer avec succès");
        }
        else{
            System.out.println("Creation impossible!! Erreur!");
        }
        return user_enregistrer;
    }

    //delete one by id
    @PostMapping(value = "/users/supprimer/{id}")
    public  void  delete(@PathVariable (value = "id") String login) {
        if(userepo != null){
            userepo.deleteById(login);
            System.out.println("Article supprimer avec succès");
        }
        else{
            System.out.println("Suppresion impossible!! Erreur!");
        }
    }
}
