package com.example.demo;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class UserTest {
    //find me CardRepository and give me access
    @Autowired
    public UserRepository userepo;

    //Test on the Controller class
    @Test
    void Test_Create_or_Modify() {
        //Arrange
        //Create a class to be implemented in database
        User user_created = new User();
        //Act
        //Set data
        user_created.setLogin("kanty");
        user_created.setPassword("admin");
        //Create the class in database
        userepo.save(user_created);
        //Assert
        assert (user_created != null && user_created.getLogin() != null && user_created instanceof User) : "La classe de la variable n\'est pas une classe User ou il y a un problème sur le repository";
    }

    @Test
    void Test_see_all() {
        //Arrange
        var it = userepo.findAll();
        var users = new ArrayList<User>();
        boolean result = false;
        //Act
        it.forEach(e -> users.add(e));
        for(User user : users){
            if(user instanceof User){
                result = true;
            }
            else{
                result = false;
                break;
            }
        }
        //Assert
        assert (users != null && result == true): "La classe de la variable n\'est pas une liste classe User";
    }
    @Test
    void Test_see_one_byid() {
        //Arrange
        String login = "kanty";
        boolean result = false;
        //Act
        var it = userepo.findById(login);
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
        String login = "kanty";
        boolean result = false;
        //Act
        if(userepo != null){
            userepo.deleteById(login);
            result = true;
        }
        else{
            result = false;
        }
        //Assert
        assert (userepo != null && result == true) : "Le donnée n'a pas été supprimer car le donnée n'existe pas dans la bdd";
    }
}
