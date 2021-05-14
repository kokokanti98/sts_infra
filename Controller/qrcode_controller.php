<?php
//
// A very simple PHP example that sends a HTTP POST to a remote site
//
$id_article=filter_input(INPUT_POST, 'id_article', FILTER_SANITIZE_NUMBER_INT);
$reduction=filter_input(INPUT_POST, 'reduction', FILTER_SANITIZE_NUMBER_INT);
$id_qrcode=filter_input(INPUT_POST, 'id_qrcode', FILTER_SANITIZE_STRING);

$btn_valide=filter_input(INPUT_POST, 'submit_btn', FILTER_SANITIZE_NUMBER_INT);

$btn_suppr=filter_input(INPUT_POST, 'btn_suppr', FILTER_SANITIZE_STRING);

$btn_download=filter_input(INPUT_POST, 'btn_download', FILTER_SANITIZE_STRING);


if($btn_valide){

    $ch = curl_init();

    curl_setopt($ch, CURLOPT_URL,'http://localhost:8089/qrcodes/creer/'.$id_qrcode.'/'.$reduction.'/'.$id_article.'');
    curl_setopt($ch, CURLOPT_POST, 1);

    // In real life you should use something like:
    // curl_setopt($ch, CURLOPT_POSTFIELDS, 
    //          http_build_query(array('postvar1' => 'value1')));



    // Receive server response ...
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $server_output = curl_exec($ch);

    curl_close ($ch);

    //Gonna construct the image qrcode 
    include('../librairie/phpqrcode/qrlib.php'); //On inclut la librairie au projet
    //$lien='https://www.243tech.com'; // Vous pouvez modifier le lien selon vos besoins
    $name_image = ''.$id_qrcode.'_qrcode.png';
    QRcode::png($id_qrcode, '../images/'.$name_image.''); // On crée notre QR Code

	echo '<script language="JavaScript">
	window.location.replace("../View/qrcode.php");//joue le role de header(php) en java
	</script>';
    // Further processing ...
    #if ($server_output == "OK") { ... } else { ... }
}
else if($btn_suppr){
    echo($btn_suppr);
    $ch = curl_init();

    curl_setopt($ch, CURLOPT_URL,'http://localhost:8089//qrcodes/supprimer/'.$btn_suppr.'');
    curl_setopt($ch, CURLOPT_POST, 1);

    // In real life you should use something like:
    // curl_setopt($ch, CURLOPT_POSTFIELDS, 
    //          http_build_query(array('postvar1' => 'value1')));

    // Receive server response ...
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

    $server_output = curl_exec($ch);

    curl_close ($ch);


    echo '<script language="JavaScript">
	window.location.replace("../View/qrcode.php");//joue le role de header(php) en java
	</script>';

    // Further processing ...
    #if ($server_output == "OK") { ... } else { ... }
}
else if($btn_download){
    echo($btn_download);
    $name_image = ''.$btn_download.'_qrcode.png'; 
    $filepath = './images/' .$name_image;

    header('Content-disposition: attachment; filename='.$name_image.'');
    header('Content-type: image/png');
    readfile($filepath);
    // Further processing ...
    #if ($server_output == "OK") { ... } else { ... }
}

?>