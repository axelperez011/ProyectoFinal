<%-- 
    Document   : index
    Created on : 24/10/2024, 12:26:45 PM
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@tablib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Eventos</h1>

        <a href="EventosController?accion=insertar">Nuevo Evento</a>
        
        <br /><br />

        <table border="1" width="80%">
          <thead>
              <tr>
                <th>Evento</th>
                <th>Cliente</th>
                <th>Fecha</th>
                <th>Hora</th>
                <th></th>
                <th></th>
             <tr>
          </thead>
          
          <tbody>
              
              <c:forEach var="evento" items="${lista}">
                  <tr>
                      <td><c:out value="${evento.nomEvento}" /></td>
                      <td><c:out value="${evento.nomPersona}" /></td>
                      <td><c:out value="${evento.fecha}" /></td> 
                      <td><c:out value="${evento.hora}" /></td> 
                      <td><a hre="EventosController?accion=editar&id=<c:out value="${evento.id}" />">Modificar</a></td> 
                      <td><a hre="EventosController?accion=eliminar&id=<c:out value="${evento.id}" />">Eliminar</a></td>
                      


                  </tr>
              
          
          </tbody>
          
          
        </table>
    </body>
</html>

