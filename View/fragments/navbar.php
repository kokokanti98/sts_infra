<?php session_start(); ?>

<html lang="en-US" xmlns:fb="https://www.facebook.com/2008/fbml" xmlns:addthis="https://www.addthis.com/help/api-spec" prefix="og: http://ogp.me/ns#" class="no-js">
	<div class="bg-light border-bottom shadow-sm sticky-top">
		<div class="container">
			<header class="blog-header py-1">
				<nav class="navbar navbar-expand-lg navbar-light bg-light"> 

				<a class="navbar-brand text-muted p-0 m-0" href="../View/index.php">
					<img src="../images/logo.gif" alt="scanqrode" width="60">
				</a>

					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav mr-auto">
							<li itemscope="itemscope" itemtype="https://www.schema.org/SiteNavigationElement" id="menu-item-17" class="active nav-item"><a title="Page d'accueil" href="../View/index.php" class="nav-link">Home</a></li>
							<li itemscope="itemscope" itemtype="https://www.schema.org/SiteNavigationElement" id="menu-item-16" class="nav-item"><a title="Scanner votre Qrcode" href="../View/scan.php" class="nav-link">Scan</a></li>
							<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Gestion
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="../View/qrcode.php">Qrcode</a>
							<a class="dropdown-item" href="../View/user.php">Utilisateur</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="../View/type_article.php">Type Article</a>
							<a class="dropdown-item" href="../View/article.php">Article</a>
							</div>
						</ul>
						<form action ="../Controller/connexion_controller.php" method="post" class="form-inline my-2 my-lg-0">
							<div class="input-group input-group-md">
								<input type="text" class="form-control search-width" name="s" id="search" value="" placeholder="Chercher..." aria-label="Search">
								<div class="input-group-append">
									<button type="submit" class="btn btn-primary" id="searchBtn"><i class="fa fa-search"></i></button>
									<?php
										if($_SESSION['connected'] == true){
											echo('<button type="submit" class="btn btn-warning" id="logout" name="logout" value="logout"><i class="fa fa-sign-out-alt"></i></button>');
										}
									?>
								</div>
							</div>
						</form>
					</div>
				</nav>
			</header>
		</div> <!--/.container-->
	</div>

	<body>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>