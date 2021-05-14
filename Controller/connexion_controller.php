<?php
session_start();

$login=filter_input(INPUT_POST, 'login', FILTER_SANITIZE_STRING);
$mdp=filter_input(INPUT_POST, 'password', FILTER_SANITIZE_STRING);
$btnvalid=filter_input(INPUT_POST,'valide', FILTER_SANITIZE_STRING);
$btndeco=filter_input(INPUT_POST,'logout', FILTER_SANITIZE_STRING);


if($btnvalid){
    $url = "http://localhost:8089/users";
    //  Initiate curl
    $ch = curl_init();
    // Will return the response, if false it print the response
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    // Set the url
    curl_setopt($ch, CURLOPT_URL,$url);
    // Execute
    $result=curl_exec($ch);
    // Closing
    curl_close($ch);
    $arr = json_decode($result);
    $arrayLength = count($arr);
    $i = 0;
    while ($i < $arrayLength)
    {
        if($arr[$i]->login == $login AND $arr[$i]->password == $mdp){
            $_SESSION['connected']=true;
            $_SESSION['login']=$arr[$i]->login;
			echo '<script language="JavaScript">';
			echo 'alert("Bienvenue ';
			echo $_SESSION['login'];
			echo '");
			window.location.replace("../View/article.php")';//joue le role de header(php) en java
            echo'</script>';
            break;
        }
        $_SESSION['connected']=false;
        $i++;
    }
	echo '<script language="JavaScript">
	alert("Le login et le mot de passe que vous avez saisie sont erronée. Recommencer");
	window.location.replace("../View/index.php");//joue le role de header(php) en java
	</script>';

}
if($btndeco){
  echo($_SESSION['connected']);
  $_SESSION['connected'] = false;
	echo '<script language="JavaScript">
	alert("Voulez vous vous déconnecter?");
	window.location.replace("../View/index.php");//joue le role de header(php) en java
  </script>';
}

?>