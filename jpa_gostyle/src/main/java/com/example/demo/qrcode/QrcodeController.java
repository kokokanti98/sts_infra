package com.example.demo.qrcode;

import com.example.demo.article.Article;
import com.example.demo.article.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QrcodeController {
    //find me CardRepository and give me access
    @Autowired
    private QrcodeRepository qrcoderepo;
    //find me CardRepository and give me access
    @Autowired
    public ArticleRepository articlerepo;

    public QrcodeController(QrcodeRepository qrcoderepo) {
        this.qrcoderepo = qrcoderepo;
        //Create a class to be implemented in database
        Qrcode qrcode_created = new Qrcode();
        qrcode_created.setId("A15CFGH");

        //Create another class
        Article art1 = new Article();
        art1.setId(4);
        art1.setPrix(10000);
        art1.setName("Minisy Shirt");

        //Link between them
        qrcode_created.setArticle(art1);
        art1.setQrcode(qrcode_created);

        //Set reduction
        qrcode_created.setReduction(25);

        qrcoderepo.save(qrcode_created);

    }
    //Find by id
    @GetMapping("/qrcode/{id}")
    @ResponseBody
    public Qrcode findById(@PathVariable(value = "id") String id) {
        Qrcode it = qrcoderepo.findById(id).get();
        return it;
    }
    //Find by id with price reduction
    @GetMapping("/qrcode_r/{id}")
    @ResponseBody
    public QrcodeJoin findWithRedById(@PathVariable(value = "id") String id) {
        QrcodeJoin it = qrcoderepo.findWithRedById(id).get();
        return it;
    }
    //find all with price reduction
    @GetMapping("/qrcodes_r")
    @ResponseBody
    public List<QrcodeJoin> findAllQrcodeWithReduction() {
        var it = qrcoderepo.findAllQrcodeWithReduction();
        var qrcodes = new ArrayList<QrcodeJoin>();
        it.forEach(e -> qrcodes.add(e));
        return qrcodes;
    }
    //find all
    @GetMapping("/qrcodes")
    @ResponseBody
    public List<Qrcode> findAll() {
        var it = qrcoderepo.findAll();
        var qrcodes = new ArrayList<Qrcode>();
        it.forEach(e -> qrcodes.add(e));
        return qrcodes;
    }
    //Create or modify
    @PostMapping(value = "/qrcodes/creer/{id}/{reduction}/{id_article}")
    public  Qrcode Create_or_modify(@PathVariable (value = "id") String id,
                                    @PathVariable (value = "reduction") int reduction,
                                    @PathVariable (value = "id_article") int id_article) {
        //Create a class to be implemented in database
        Qrcode qrcode_created = new Qrcode();
        qrcode_created.setId(id);

        //Find by id the other class in database
        Article article = articlerepo.findById(id_article).get();

        //Link class
        article.setQrcode(qrcode_created);
        qrcode_created.setArticle(article);
        //Set reduction
        qrcode_created.setReduction(reduction);

        Qrcode article_enregistrer = qrcoderepo.save(qrcode_created);

        if(qrcoderepo != null){
            System.out.println("Qrcode creer avec succès");
        }
        else{
            System.out.println("Creation impossible!! Erreur!");
        }
        return qrcode_created;
    }
    //delete one by id
    @PostMapping(value = "/qrcodes/supprimer/{id}")
    public  void  delete(@PathVariable (value = "id") String id) {
        if(qrcoderepo != null){
            qrcoderepo.deleteById(id);
            System.out.println("Qrcode supprimer avec succès");
        }
        else{
            System.out.println("Suppresion impossible!! Erreur!");
        }
    }

}
