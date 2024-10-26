<%-- 
    Document   : insertar
    Created on : 24/10/2024, 12:26:24 PM
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h2>Nuevo evento</h2>
        
         <form action="EventosController?accion=insert" method="POST" autocomplete="off">
             
             <p>
                  Evento:
                  <input id="evento" name="evento" type="text">
             </p>
             
             <p>
                  Cliente:
                  <input id="cliente" name="cliente" type="text">
             </p>
             
             <p>
                  Fecha:
                  <input id="date" name="date" type="text">
             </p>
             
             <p>
                  Hora:
                  <input id="hora" name="hora" type="text">
             </p>
             
             <button id="guardar" name="guardar" type="submit">Guardar</button>
                  
         </form>
         
    </body>
</html>
