<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<!--  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!--  -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>SGP App</title>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>


	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#"><img
			src="https://getbootstrap.com/docs/4.1/assets/img/bootstrap-stack.png"
			alt="bootstrap" style="width: 30px; height: 30px;"img-thumbnail"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			<div class="navbar-nav">
				<a class="nav-item nav-link active" href="#">Administration des
					messages <span class="sr-only">(current)</span>
				</a> <a class="nav-item nav-link disabled" href="#">Aide</a> <a
					class="nav-item nav-link disabled" href="#">Quitter</a>

			</div>
		</div>
	</nav>



	<H2>Administration des messages</H2>


	<div class="container">
		<div class="row" style="margin-top: 20px" data-target="#exampleModal">
			
			<a class="btn btn-default" href="http://localhost:8080/humancontact/admin/messages/new" role="button" ><span
				class="glyphicon glyphicon-plus" style="font-size: 22px;"></span></a>

		</div>

		<div class="row" style="margin-top: 20px">


			<table class="table table-striped">

				<thead class="thead-dark">
					<tr>
						<th scope="col">Expediteur</th>
						<th scope="col">Recepteur</th>
						<th scope="col">Date</th>
						<th scope="col">message</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${messages}" var="msg">
						<tr>
							<th scope="row">${msg.fromUser }</th>
							<td>${msg.toUser }</td>
							<td>${msg.eventTime }</td>
							<td>${msg.content }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>



</body>
</html>