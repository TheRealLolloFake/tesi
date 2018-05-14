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
	
	\end{lstlisting}
	
	\begin{lstlisting}[language=php]
	//reserved.php
	<?php
	
		$usr=isset($_POST["usr"])?$_POST["usr"]:null;
		$pwd=isset($_POST["pwd"])?$_POST["pwd"]:null;
		
		if(($usr==null || $pwd==null) || (strcmp($usr,"admin")!=0 || strcmp($pwd,"admin")!=0)){
		header("Location: http://localhost/login.php?err=true");
		exit();
	}
	?>
	
	<html>
		<head>
			<title>Reserved page</title>
		</head>
		<body>
			<b>Welcome admin</b>
			<div id="placer"></div>
			<script>
				var placer=document.getElementById("placer");
				var ws=new WebSocket("ws://localhost:8080/");
				ws.onmessage=function(event){
					var elem=document.createElement("b");
					elem.textContent=event.data;
					placer.appendChild(elem);
				}
			</script>
		</body>
	</html>