<%-- 
    Document   : editar
    Created on : 25/10/2024, 12:35:20 PM
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@tablib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h2>Modificar evento</h2>
        
         <form action="EventosController?accion=actualizar" method="POST" autocomplete="off">
             
              <input id="id" name="id" type="hidden" value="<c:out value="${evento.id}" />"/>
             
             <p>
                  Eento:
                  <input id="evento" name="evento" type="text" value="<c:out value="${evento.nomEvento}" />"/>
             </p>
             
             <p>
                  Cliente:
                  <input id="cliente" name="cliente" type="text" value="<c:out value="${evento.nomPersona}" />"/>
             </p>
             
             <p>
                  Fecha:
                  <input id="date" name="date" type="text" value="<c:out value="${evento.fecha}" />"/>
             </p>
             
             <p>
                  Hora:
                  <input id="hora" name="hora" type="text" value="<c:out value="${evento.hora}" />"/>
             </p>
             
             <button id="guardar" name="guardar" type="submit">Guardar</button>
                  
         </form>
    </body>
</html>
