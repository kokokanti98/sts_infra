<form action ="../Controller/qrcode_controller.php" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Numero Qrcode</label>
      <input type="text" class="form-control" id="id_qrcode" name="id_qrcode" placeholder="AZ23RDF">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Reduction(Si inférieur à 40 ca sera pris en pourcentage sinon en prix)</label>
      <input type="number" class="form-control" id="reduction"  name="reduction" placeholder="1">
    </div>
  </div>
    <div class="form-group">
    <label for="inputAddress">Numero de l'article</label>
    <input type="number" class="form-control" id="id_article" name="id_article" placeholder="20">
  </div>
  <button type="submit" name ="submit_btn" value="1" class="btn btn-primary">Enregistrer</button>
