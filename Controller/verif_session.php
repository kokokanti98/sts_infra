<?php

//Verify if the user is connected
  if($_SESSION['connected'] == false){
    	echo '<script language="JavaScript">
	    alert("Veuillez vous connécter afin d utiliser nos services");
	    window.location.replace("../View/connexion.php");//joue le role de header(php) en java
	    </script>';
  };
?>