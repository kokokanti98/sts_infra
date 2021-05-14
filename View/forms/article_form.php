<form action ="../Controller/article_controller.php" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Numero Article</label>
      <input type="number" class="form-control" id="id_article" name="id_article" placeholder="1">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Prix</label>
      <input type="number" class="form-control" id="prix_article"  name="prix_article" placeholder="1">
    </div>
  </div>
    <div class="form-group">
    <label for="inputAddress">Nom de l'article</label>
    <input type="text" class="form-control" id="nom_article" id="nom_article" name="nom_article" placeholder="T shirt Adidas">
  </div>
  <div class="form-group">
    <label for="inputAddress">Numero type article</label>
    <input type="number" class="form-control" id="id_t_article" id="id_t_article" name="id_t_article"  placeholder="1">
  </div>
  <button type="submit" name ="submit_btn" value="1" class="btn btn-primary">Enregistrer</button>
