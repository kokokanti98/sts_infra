package com.example.demo;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleRepository;
import com.example.demo.qrcode.Qrcode;
import com.example.demo.qrcode.QrcodeRepository;
import com.example.demo.type_article.Type_article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class QrcodeTest {
    //find me CardRepository and give me access
    @Autowired
    private QrcodeRepository qrcoderepo;
    //find me CardRepository and give me access
    @Autowired
    public ArticleRepository articlerepo;

    @Test
    void Test_Create_or_Modify() {
        //Arrange
        //Create a class to be implemented in database
        Article art1 = new Article();
        Qrcode qrcode_created = new Qrcode();

        //Act
        //Set data
        art1.setId(2);
        art1.setPrix(10);
        art1.setName("Mini Shirt");

        qrcode_created.setId("A15CFGH");
        //Link class
        qrcode_created.setArticle(art1);
        art1.setQrcode(qrcode_created);

        //Set reduction
        qrcode_created.setReduction(25);

        //Create the class in database
        qrcoderepo.save(qrcode_created);

        //Assert
        assert (qrcoderepo.save(qrcode_created) != null && qrcode_created.getId() != null && qrcode_created instanceof Qrcode) : "La classe de la variable n\'est pas une classe Qrcode ou il y a un problème sur le repository";
    }
    @Test
    void Test_see_all() {
        //Arrange
        var it = qrcoderepo.findAll();
        var qrcodes = new ArrayList<Qrcode>();
        boolean result = false;
        //Act
        it.forEach(e -> qrcodes.add(e));
        for(Qrcode qrcode : qrcodes){
            if(qrcode instanceof Qrcode){
                result = true;
            }
            else{
                result = false;
                break;
            }
        }
        //Assert
        assert (qrcodes != null && result == true): "La classe de la variable n\'est pas une liste classe Qrcode";
    }
    @Test
    void Test_see_one_byid() {
        //Arrange
        String id = "A15CFGH";
        boolean result = false;
        //Act
        var it = qrcoderepo.findById(id);
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
        String id = "A15CFGH";
        boolean result = false;
        //Act
        if(qrcoderepo != null){
            qrcoderepo.deleteById(id);
            result = true;
        }
        else{
            result = false;
        }
        //Assert
        assert (qrcoderepo != null && result == true) : "Le donnée n'a pas été supprimer car le donnée n'existe pas dans la bdd";
    }
}
