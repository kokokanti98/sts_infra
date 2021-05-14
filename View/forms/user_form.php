<form action ="../Controller/qrcode_controller.php" method="post">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Login</label>
      <input type="text" class="form-control" id="login" name="login" placeholder="AZ23RDF">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Mot de passe</label>
      <input type="password" class="form-control" id="mdp"  name="mdp" placeholder="1">
    </div>
  </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Confirmer mot de passe(tapez à nouveau le même)</label>
      <input type="password" class="form-control" id="mdp2"  name="mdp2" placeholder="1">
    </div>
  </div>
  <button type="submit" name ="submit_btn" value="create_modify" class="btn btn-primary">Enregistrer</button>
