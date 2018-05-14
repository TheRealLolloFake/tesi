	<?php
	session_start();
	?>
	
	<html>
		<head>
			<title>Login page</title>
		</head>
		<body>
			<form method="POST" action="reserved.php">
			<?php
			if(isset($_GET["err"]))echo "<div>Invalid username or password.</div>";
			?>
			<input type="text" id="usr" name="usr">
			<input type="password" id="pwd" name="pwd">
			<input type="submit" id="sub" value="Login">
			</form>
		</body>
	</html>