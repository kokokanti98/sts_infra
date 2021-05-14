
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Numero Qrcode</th>
      <th scope="col">Réduction</th>
      <th scope="col">Numero Article</th>
      <th scope="col">Prix Avant réduction</th>
      <th scope="col">Nom de l'article</th>
      <th scope="col">Prix Après réduction</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <?php
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
    $arr = json_decode($result);-
    $arrayLength = count($arr);
    $i = 0;
    while ($i < $arrayLength)
    {
	        	//var_dump($arr[$i]->name);
            echo('<tr>
              <th scope="row">'.$arr[$i]->id_qrcode.'</th>
              <td>'.$arr[$i]->reduction.'</td>
              <td>'.$arr[$i]->id_article.'</td>
              <td>'.$arr[$i]->prix.'</td>
              <td>'.$arr[$i]->name.'</td>
              <td>'.$arr[$i]->prix_reduit.'</td>
              <td>
                <button type="submit" name="btn_suppr" value="'.$arr[$i]->id_qrcode.'" class="btn btn-danger">Supprimer</button>
                <button type="submit" name="btn_download" value="'.$arr[$i]->id_qrcode.'" class="btn btn-warning">Télécharger</button>
              </td>
             </tr>');
        $i++;
    }
  
  ?>
  </tbody>
</table>
</form>