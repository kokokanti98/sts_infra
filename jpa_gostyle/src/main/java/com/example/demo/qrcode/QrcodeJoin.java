package com.example.demo.qrcode;

public class QrcodeJoin {
    String id_qrcode;
    int reduction;
    int id_article;
    int prix;
    String name;
    float prix_reduit;

    public QrcodeJoin(String id_qrcode, int reduction, int id_article, int prix, String name) {
        this.id_qrcode = id_qrcode;
        this.reduction = reduction;
        this.id_article = id_article;
        this.prix = prix;
        this.name = name;
        setPrix_reduit();
    }

    public String getId_qrcode() {
        return id_qrcode;
    }

    public void setId_qrcode(String id_qrcode) {
        this.id_qrcode = id_qrcode;
    }

    public int getReduction() {
        return reduction;
    }

    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrix_reduit() {
        return prix_reduit;
    }

    public void setPrix_reduit() {
        //Remise de 40 pourcent maximum
        if(this.reduction > 40){
            this.prix_reduit = this.prix - this.reduction;
        }
        else{
            this.prix_reduit = this.prix - ((this.prix * this.reduction)/100);
        }

    }
}
