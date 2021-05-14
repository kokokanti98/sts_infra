<?php
//
// A very simple PHP example that sends a HTTP POST to a remote site
//
$id_article=filter_input(INPUT_POST, 'id_article', FILTER_SANITIZE_NUMBER_INT);
$prix_article=filter_input(INPUT_POST, 'prix_article', FILTER_SANITIZE_NUMBER_INT);
$id_t_article=filter_input(INPUT_POST, 'id_t_article', FILTER_SANITIZE_NUMBER_INT);
$nom_article=filter_input(INPUT_POST, 'nom_article', FILTER_SANITIZE_STRING);

$btn_valide=filter_input(INPUT_POST, 'submit_btn', FILTER_SANITIZE_NUMBER_INT);

$btn_suppr=filter_input(INPUT_POST, 'btn_suppr', FILTER_SANITIZE_NUMBER_INT);



if($btn_valide){

    $ch = curl_init();

    curl_setopt($ch, CURLOPT_URL,'http://localhost:8089/articles/creer/'.$id_article.'/'.$prix_article.'/'.$nom_article.'/'.$id_t_article.'');
    curl_setopt($ch, CURLOPT_POST, 1);

    // In real life you should use something like:
    // curl_setopt($ch, CURLOPT_POSTFIELDS, 
    //          http_build_query(array('postvar1' => 'value1')));

    // Receive server response ...
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $server_output = curl_exec($ch);

    curl_close ($ch);

	echo '<script language="JavaScript">
	window.location.replace("../View/article.php");//joue le role de header(php) en java
	</script>';
    // Further processing ...
    #if ($server_output == "OK") { ... } else { ... }
}
else if($btn_suppr){
    echo($btn_suppr);
    $ch = curl_init();

    curl_setopt($ch, CURLOPT_URL,'http://localhost:8089//articles/supprimer/'.$btn_suppr.'');
    curl_setopt($ch, CURLOPT_POST, 1);

    // In real life you should use something like:
    // curl_setopt($ch, CURLOPT_POSTFIELDS, 
    //          http_build_query(array('postvar1' => 'value1')));

    // Receive server response ...
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $server_output = curl_exec($ch);

    curl_close ($ch);


    echo '<script language="JavaScript">
	window.location.replace("../View/article.php");//joue le role de header(php) en java
	</script>';

    // Further processing ...
    #if ($server_output == "OK") { ... } else { ... }
}

?>