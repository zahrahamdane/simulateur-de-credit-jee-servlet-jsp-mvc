<%@page import="com.zaradev.web.CreditModel"%>
<%@page import="java.text.DecimalFormat"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crédit bancaire</title>
</head>
<body>
	<div>
		<%
			CreditModel model = (CreditModel) request.getAttribute("creditModel");
		
		%>
		<form action="calculerMensualite.fr" method="Post">
			<table>
				<tr>
					<td>Montant :</td>
					<td><input type="text" name="montant" value="<%= model.getMontant() %>" /></td>
					<td>DH</td>
				</tr>
				
				<tr>
					<td>Taux :</td>
					<td><input type="text" name="taux" value="<%= model.getTaux() %>" /></td>
					<td>%</td>
				</tr>
				
				<tr>
					<td>Durée :</td>
					<td><input type="text" name="duree" value="<%= model.getDuree() %>" /></td>
					<td>Mois</td>
				</tr>
			</table>
			
			<button type="submit">Calculer</button>
		
		</form>
		<hr />
		<div>
			<p>
				<% DecimalFormat df = new DecimalFormat("0.00"); %>
				Monsualité = <% out.println(df.format(model.getMensualite())); %>
			</p>
		
		</div>
	
	</div>
</body>
</html>