
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Login</th>
      <th scope="col">Mot de passe</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <?php
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
    $arr = json_decode($result);-
    $arrayLength = count($arr);
    $i = 0;
    while ($i < $arrayLength)
    {
	        	//Hashage CR32 of password for security messure
            //ex: so not all user can see other user password
            $pwd_hash = crc32($arr[$i]->password);
            echo('<tr>
              <th scope="row">'.$arr[$i]->login.'</th>
              <td>'.$pwd_hash.'</td>
              <td><button type="submit" name="btn_suppr" value="'.$arr[$i]->login.'" class="btn btn-danger">Supprimer</button</td>
             </tr>');
        $i++;
    }
  
  ?>
  </tbody>
</table>
</form>