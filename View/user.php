
 <?php include './fragments/scan_head.php'; ?>


 <?php include './fragments/navbar.php'; ?>

 <?php include './forms/user_form.php'; ?>

  <!--Can only see data if only user is connected-->
<?php
	if($_SESSION['connected'] == true){
		include './table/user_table.php';
	}
?>


	
	<div class="container-fluid">
		<div class="row">
<?php include './fragments/extras.php'; ?>
			
<!--See if the user is connected if not go to index page-->		
 <?php include '../Controller/verif_session.php'; ?>

</body>




<div id="detach-button-host" style="top: 184px; left: 650px;">
</div>
</html>

<!--
<script type="text/javascript" src="../Static/js/scan1.js"></script>
-->