<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Pedido</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<% HashMap<Integer,String> jspFPago = (HashMap<Integer,String>)request.getAttribute("DataFPago");


%>
<body>
<div style="width:60%;margin-left:auto;margin-right:auto;">
<h1 style="text-align:center;">Nuevo Pedido</h1>
<form action="pedidos" method="post">
<input type="hidden" name="accion" value="GM">
<input type="hidden" name="pid" value=<%=request.getAttribute("pid") %>>
<div style="margin-left:auto;margin-right:auto;">
<label>Descripcion Pedido:</label><input class="w3-input w3-border" type="text" name="descrip" value="<%=request.getAttribute("descrip") %>" required/>
<label>Fecha:</label><input class="w3-input w3-border" type="date" name="fecha" value="<%=request.getAttribute("fecha") %>" required/>
<label>Importe Total:</label><input class="w3-input w3-border" type="text" name="imptotal" value="<%=request.getAttribute("imptotal") %>" required/>

<label>Cliente:</label><input class="w3-input w3-border" type="text" name="icliente"/>

<label>Forma de Pago:</label>
<select  class="w3-input w3-border" name="fpago" value="<%=request.getAttribute("fpago") %>">
<% for(Map.Entry<Integer,String> e : jspFPago.entrySet()) { %>
  <option value="<%=e.getKey() %>"><%=e.getValue() %></option>
<% } %>
</select>


<label>Contrato:</label><input class="w3-input w3-border" type="text" name="icontrato"/>
<label>Servicio:</label><input class="w3-input w3-border" type="text" name="iservicio"/>

<button type="submit" class="w3-button w3-block w3-black w3-margin-bottom">Grabar Pedido</button>
</div>
</form>
</div>
</body>
</html>