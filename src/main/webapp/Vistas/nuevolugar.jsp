<%-- 
    Document   : insertar
    Created on : 24/10/2024, 12:26:24 PM
    Author     : Antonio
--%>

<%@page import="modelo.ClientesLugarDAO"%>
<%@page import="modelo.ClientesLugar"%>
<%@page import="modelo.item"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.EventosDAO"%>
<%@page import="modelo.Eventos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <style>
        /* Reset básico */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        /* Contenedor del formulario */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f2f2f2;
        }

        .form-container {
            background-color: #fff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }

        .form-container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        /* Estilos para los elementos del formulario */
        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
            text-align: left;
        }

        input[type="text"],
        input[type="date"],
        input[type="time"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
        }

        input[type="text"]:focus,
        input[type="date"]:focus,
        input[type="time"]:focus
        seelct:focus{
            border-color: #007BFF;
            outline: none;
        }

        /* Estilo del botón */
        .button {
            width: 50%;
            padding: 12px;
            font-size: 16px;
            color: #fff;
            background-color: #007BFF;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            float:left; 
        }

        .button:hover {
            background-color: #0056b3;
        }
        .button2 {
            width: 20%;
            padding: 12px;
            font-size: 16px;
            color: #fff;
            background-color: #00cc33;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            float:left;
            margin-right: 40px;
           text-decoration: none;
        }

        .button2:hover {
            background-color: #009900;
        }
         /* Contenedor de la tabla */
        .table-container {
            width: 100%;
            max-width: 400px;
            max-width: 1000px;
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        .table-container h2 {
            margin-bottom: 20px;
            color: #333;
        }

        /* Estilos de la tabla */
        .event-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
            font-size: small;
        }

        .event-table thead {
            background-color: #007BFF;
            color: #fff;
        }

        .event-table th,
        .event-table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        .event-table tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .event-table tbody tr:hover {
            background-color: #f1f1f1;
        }

        .event-table th {
            font-weight: bold;
            text-align: left;
        }

        .event-table td {
            color: #333;
        }
    </style>
    <body>
        <div class="form-container">
        <h2>Registro de Lugares Nuevos</h2>
            <form action="Controlador" method="post">
                <input type="hidden" id="id" name="id" value="${id}">
                <label for="nombre">Nombre del Lugar</label>
                <input type="text" id="nombre" name="nombreLugar" value="${nombre}" required>
                <a href="Controlador?accion=Volver" class="button2">Volver</a>
                <input type="submit" name="accion" value="${valor}" class="button">
                 
            </form>
        </div>
         <div class="">
             <div class="table-container">
                <h2>Listado de Lugares</h2>
                <table class="event-table">
                    <thead >
                        <tr class="">
                            <td class="borde">Nombre</td>
                            
                            <td class="borde">Editar</td>
                            <td class="borde">Eliminar</td>
                        </tr>
                    </thead>
                     <tbody>
                    <%
                        ClientesLugar cl = new ClientesLugar();
                        ClientesLugarDAO dao = new ClientesLugarDAO();
                        List<ClientesLugar> cliL = dao.listarLugares();
                        Iterator<ClientesLugar> it = cliL.iterator();
                        while(it.hasNext()){
                                cl = it.next();
                    %>
                        <tr>
                            <td><%= cl.getNombre()%></td>
                            <td><a href="Controlador?accion=editarLugar&id=<%= cl.getId() %>&nombre=<%= cl.getNombre()%>" ><img src="img/editar.png" alt="Editar Evento"/></a></td>
                            <td><a href="Controlador?accion=eliminarLugar&id=<%= cl.getId() %>" ><img src="img/eliminar.png" alt="Eliminar"/></a></td>
                        </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
             </div>
        </div>
    </body>
</html>
