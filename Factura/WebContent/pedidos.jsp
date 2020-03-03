<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.vipper.modelo.Pedido" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedidos</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<% List<Pedido> jspPedido = (ArrayList<Pedido>)request.getAttribute("OutData"); %>
<div style="width:100%;margin-left:auto;margin-right:auto;">
<h1 style="text-align:center;">Pedidos</h1>
<div style="margin-left:auto;margin-right:auto;">
<table class="w3-table-all">
<tr class="w3-light-grey">
<th>Pedido</th><th>Fecha</th>
<th>Importe<br/>Total</th><th>Importe<br/>Facturado</th>
<th>ID1</th><th>ID2</th><th>ID3</th><th>ID4</th>
<th>Eli.</th><th>Mod.</th>
</tr>
<% if (!jspPedido.isEmpty()) { %>
<% for(Pedido e:jspPedido) { %>
	<tr>
	<td><%=e.getDescrip() %></td><td><%=e.getFecha() %></td>
	<td><%=String.format("%.0f",e.getTotal()) %></td><td><%=String.format("%.0f",e.getImporte_facturado()) %></td>

	<td></td><td></td><td></td><td></td>

	<td style="text-align:center;">
	<a href="pedidos?accion=D&id=<%=e.getId_pedido() %>">
	<img alt="Quitar Pedido" src="images/quitar.svg" width="20px" height="20px"/>
	</a>
	</td>
	<td style="text-align:center;">
	<a href="pedidos?accion=M&id=<%=e.getId_pedido() %>">
	<img alt="Modificar Pedido" src="images/modificar.svg" width="20px" height="20px"/>
	</a>
	</td>
	</tr>
<% } } %>
	<tr>
	<td colspan="11">
		<form action="pedidos" method="post">
		<div style="margin-left:auto;margin-right:auto;">
		<input type="hidden" name="accion" value="N">
		<button type="submit" class="w3-button w3-block w3-black w3-margin-bottom">Nuevo Pedido</button>
		</div>
		</form>
	</td>
</table>
</div>
<p style="text-align:center;"><a href="/Factura/menu.html">-- Volver Al Menu --</a></p>
</div>
</body>
</html>