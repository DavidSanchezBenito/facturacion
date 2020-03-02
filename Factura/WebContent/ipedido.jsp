<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuevo Pedido</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<div style="width:60%;margin-left:auto;margin-right:auto;">
<h1 style="text-align:center;">Nuevo Pedido</h1>
<form action="pedidos" method="post">
<input type="hidden" name="accion" value="GN">
<div style="margin-left:auto;margin-right:auto;">
<label>Descripcion Pedido:</label><input class="w3-input w3-border" type="text" name="descrip" required/>
<label>Fecha:</label><input class="w3-input w3-border" type="date" name="fecha" required/>
<label>Importe Total:</label><input class="w3-input w3-border" type="text" name="imptotal" required/>

<label>Id Cliente:</label><input class="w3-input w3-border" type="text" name="icliente" required/>
<label>Id Forma de Pago:</label><input class="w3-input w3-border" type="text" name="fpago" required/>
<label>Id Contrato:</label><input class="w3-input w3-border" type="text" name="icontrato" required/>
<label>Id Servicio:</label><input class="w3-input w3-border" type="text" name="iservicio" required/>

<button type="submit" class="w3-button w3-block w3-black w3-margin-bottom">Grabar Pedido</button>
</div>
</form>
</div>
</body>
</html>