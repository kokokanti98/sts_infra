
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nom</th>
      <th scope="col">Prix</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <?php
      $url = "http://localhost:8089/articles";
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
              <th scope="row">'.$arr[$i]->id.'</th>
              <td>'.$arr[$i]->name.'</td>
              <td>'.$arr[$i]->prix.'</td>
              <td><button type="submit" name="btn_suppr" value="'.$arr[$i]->id.'" class="btn btn-danger">Supprimer</button</td>
             </tr>');
        $i++;
    }
  
  ?>
  </tbody>
</table>
</form>