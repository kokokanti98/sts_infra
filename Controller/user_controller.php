<?php
session_start();

$login=filter_input(INPUT_POST, 'login', FILTER_SANITIZE_STRING);
$mdp=filter_input(INPUT_POST, 'mdp', FILTER_SANITIZE_STRING);
$btnvalid=filter_input(INPUT_POST,'submit_btn', FILTER_SANITIZE_STRING);
$mdp2=filter_input(INPUT_POST,'mdp2', FILTER_SANITIZE_STRING);
$btn_suppr=filter_input(INPUT_POST, 'btn_suppr', FILTER_SANITIZE_STRING);


if($btnvalid && $mdp == $mdp2){
    $ch = curl_init();

    curl_setopt($ch, CURLOPT_URL,'http://localhost:8089/users/creer/'.$login.'/'.$mdp.'');
    curl_setopt($ch, CURLOPT_POST, 1);

    // In real life you should use something like:
    // curl_setopt($ch, CURLOPT_POSTFIELDS, 
    //          http_build_query(array('postvar1' => 'value1')));

    // Receive server response ...
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $server_output = curl_exec($ch);

    curl_close ($ch);

	echo '<script language="JavaScript">
	window.location.replace("../View/user.php");//joue le role de header(php) en java
	</script>';
    // Further processing ...
    #if ($server_output == "OK") { ... } else { ... }

}

else if($btn_suppr){
    echo($btn_suppr);
    $ch = curl_init();

    curl_setopt($ch, CURLOPT_URL,'http://localhost:8089//users/supprimer/'.$btn_suppr.'');
    curl_setopt($ch, CURLOPT_POST, 1);

    // In real life you should use something like:
    // curl_setopt($ch, CURLOPT_POSTFIELDS, 
    //          http_build_query(array('postvar1' => 'value1')));

    // Receive server response ...
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $server_output = curl_exec($ch);

    curl_close ($ch);


    echo '<script language="JavaScript">
	window.location.replace("../View/type_article.php");//joue le role de header(php) en java
	</script>';
    
    // Further processing ...
    #if ($server_output == "OK") { ... } else { ... }
}

else{
	echo '<script language="JavaScript">
	alert("Les mot de passe ne correspondent pas. Veuillez recommencer");
	window.location.replace("../View/user.php");//joue le role de header(php) en java
	</script>';
}

?>