<%@page import="com.zaradev.web.CreditModel"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Crédit bancaire</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>

	<%
	CreditModel model = (CreditModel) request.getAttribute("creditModel");
	%>
	<%
	DecimalFormat df = new DecimalFormat("0.00");
	%>

	<div class="container spacer">
		<div class="col-md-6 col-xs-12 col-sm-6 offset-md-3">

			<div class="card">
				<div class="card-header bg-primary text-white">Simulation du crédit</div>
				<div class="card-body">

					<form action="calculerMensualite.fr" method="Post">

						<div class="form-group">
							<label class="control-label">Montant :</label> 
							<input class="form-control" type="text" name="montant" value="<%=df.format(model.getMontant()) %>">
						</div>

						<div class="form-group">
							<label class="control-label">Taux :</label> 
							<input class="form-control" type="text" name="taux" value="<%=model.getTaux()%>"> 
						</div>

						<div class="form-group">
							<label class="control-label">Durée :</label> 
							<input class="form-control" type="text" name="duree" value="<%=model.getDuree()%>">
						</div>

						<button class="btn btn-primary" type="submit">Calculer</button>

					</form>
				</div>

				<div class="card-footer text-body-secondary">
					<label>
						Mensualité :</label> <label> <% out.println(df.format(model.getMensualite())); %>
					</label>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
