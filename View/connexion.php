 <?php include './fragments/navbar.php'; ?>
 
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="../Static/css/connexion.css">
<!------ Include the above in your HEAD tag ---------->

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

<!-- Icon -->
    <div class="fadeIn first">
      <img src="../images/user.png" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
    <form action ="../Controller/connexion_controller.php" method="post">
      <input type="text" id="login" class="fadeIn second" name="login" placeholder="Identifiant">
      <input type="password" id="password" class="fadeIn third" name="password" placeholder="Mot de passe">
      <input type="submit" name = "valide" class="fadeIn fourth" value="Se connecter">
    </form>


  </div>
</div>