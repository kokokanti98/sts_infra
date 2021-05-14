<?php header('Access-Control-Allow-Origin: *'); ?>


 <?php include './fragments/scan_head.php'; ?>


 <?php include './fragments/navbar.php'; ?>
	
	<div class="container-fluid">
		<div class="row">
<?php include './fragments/extras.php'; ?>
			
			<div class="col">
				<h1><a href="https://learncodeweb.com/phonegap/how-to-use-instascan-an-html5-qr-scanner/">Scanner Votre Qr code</a></h1>
				<div class="col-sm-12">
					<video id="preview" class="p-1 border active" style="width:100%;" autoplay="autoplay"></video>
				</div>

				<div class="btn-group btn-group-toggle mb-5" data-toggle="buttons">
				  <label class="btn btn-primary active">
					<input type="radio" name="options" value="1" autocomplete="off" checked=""> Camera du Devant
				  </label>
				  <label class="btn btn-secondary">
					<input type="radio" name="options" value="2" autocomplete="off">Camera du Derrière 
				  </label>
				</div>
			</div>
			<form action ="../Controller/scan_controller.php" method="post">
      <div class="form-group">
        <label for="qrcode_id">Numero de Qr code</label>
        <input type="text" class="form-control" id="qrcode_id" name="qrcode_id" aria-describedby="qrcodeHelp" placeholder="Scan et click button">
        <small id="emailHelp" class="form-text text-muted">Apres avoir scanner le qr code cliquez sur le bouton</small>
      </div>
      <button type="submit" class="btn btn-primary" id="btn_voir">Voir</button>
    </form>
			
			<div class="col-sm-3" style="height:100vh">
				<script async="" src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
				<!-- demo left sidebar -->
				<ins class="adsbygoogle" style="display:block" data-ad-client="ca-pub-6724419004010752" data-ad-slot="7706376079" data-ad-format="auto" data-full-width-responsive="true"></ins>

			</div>
		
		</div>
	</div>


</body>




<div id="detach-button-host" style="top: 184px; left: 650px;">
</div>
</html>

<script type="text/javascript" src="../Static/js/scan1.js"></script>