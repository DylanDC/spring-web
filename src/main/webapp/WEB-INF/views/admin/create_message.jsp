<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Ajout Message</title>
</head>
<body>
	<div class="container">
		<h1>Ajout d'un message</h1>
		<form:form method="POST" modelAttribute="message">

			<div class="form-group" style="margin-top: 30px">

				<form:input path="fromUser" class="form-control" id="fromUser"
					placeholder="Utilisateur Expéditeur"></form:input>
				<form:errors path="fromUser" />
			</div>

			<div class="form-group" style="margin-top: 30px">

				<form:input path="toUser" type="text" class="form-control"
					id="toUser" placeholder="Utilisateur Destinataire"></form:input>
				<form:errors path="toUser" />
			</div>

			<div class="form-group" style="margin-top: 50px">
				<form:textarea path="content" class="form-control" id="content"
					rows="3" placeholder="Entrer le Message"></form:textarea>
				<form:errors path="content" />
			</div>

			<div class="form-group" style="margin-top: 30px">


				<button type="submit" value="Submit" class="btn btn-primary">Ajouter</button>

			</div>
		</form:form>


	</div>
</body>
</html>