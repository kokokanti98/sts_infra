<?php

$num_qrcode=filter_input(INPUT_POST, 'qrcode_id', FILTER_SANITIZE_STRING);
include '../View/fragments/scan_head.php';
include '../View/fragments/navbar.php';
    $url = "http://localhost:8089/qrcodes_r";
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
		//var_dump($arr[$i]->id_qrcode);
		if($arr[$i]->id_qrcode == $num_qrcode){

			echo('<table class="table table-striped">
			<thead>
				<tr>
				<th scope="col">id_qrcode</th>
				<th scope="col">reduction</th>
				<th scope="col">id_article</th>
				<th scope="col">prix</th>
				<th scope="col">name</th>
				<th scope="col">prix_reduit</th>
				</tr>
			</thead>
			<tbody id ="tableau_info">
				<tr>
				<td>'.$arr[$i]->id_qrcode.'</td>
				<td>'.$arr[$i]->reduction.'</td>
				<td>'.$arr[$i]->id_article.'</td>
				<td>'.$arr[$i]->prix.' Euros</td>
				<td>'.$arr[$i]->name.'</td>
				<td>'.$arr[$i]->prix_reduit.' Euros</td>
				</tr>
			</tbody>
			</table>');
			#header('Location: scan.php'); 
            break;
		}
        $i++;
    }
include '../View/fragments/extras.php';


?>