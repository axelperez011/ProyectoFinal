<%-- 
    Document   : index
    Created on : 30 oct 2024, 3:24:26 p.m.
    Author     : axel
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Eventos"%>
<%@page import="modelo.EventosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    session = request.getSession(false);
    if (session == null || session.getAttribute("usuario") == null) {
        
        String mensaje = "Debes Iniciar Sesion";
        request.setAttribute("mensaje", mensaje);
        RequestDispatcher reqVista = request.getRequestDispatcher("Vistas/noinicio.jsp");
        reqVista.forward(request, response);
        return;
    }
    String usuario = (String) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MI PAGINA DE EVENTOS</title>
    </head>
    <style>
          /* Reset básico */
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }
          body {
            display: flex;
            justify-content: center;
            align-items: center;
            background-color: #f2f2f2;
        }
        table{
            width: 50%;
            border: black 1px solid;
            font-size: small;
        }
        .button{
	padding:10px 15px;
	border:1px solid #ff0064;
	border-radius:5px;
	background-color:#ff0064;

	color:#fff;
	text-decoration:none;
	text-transform:uppercase;
	text-align:center;

	box-shadow:1px 1px 1px #000;

	display:inline-block;

        }

        .button:hover{
                cursor:pointer;
        }

        .button:active{
                box-shadow:2px 2px 1px #000;
        }
        /* Estilos generales */

        /* Contenedor de la tabla */
        .table-container {
            width: 100%;
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
         
        <div class="table-container">
            <h2>Bienvenido: <%= usuario %>
                <a class="" href="Controlador?accion=salir">
                    <img src="img/salir.png" alt="Cerrar Sesion" widt="24" height="24"/>
                </a>
            </h2>
            
            <a class="button" href="Controlador?accion=insertar">Nuevo Evento</a>
            <a class="button" href="Controlador?accion=nuevoCliente">Nuevo Cliente</a>
            <a class="button" href="Controlador?accion=nuevoLugar">Nuevo Lugar</a>
            
            <br/><br><!-- comment -->
           
            <h2>Listado de Eventos</h2>
            <table class="event-table">
                <thead >
                    <tr class="">
                        <td class="borde">Nombre</td>
                        <td class="borde">Cliente</td>
                        <td class="borde">Telefono</td>
                        <td class="borde">Fecha</td>
                        <td class="borde">Hora Inicio</td>
                        <td class="borde">Hora Termino</td>
                        <td class="borde">Lugar</td>
                        <td class="borde">Editar</td>
                        <td class="borde">Eliminar</td>
                    </tr>
                </thead>
                 <tbody>
                <%
                    Eventos e = new Eventos();
                    EventosDAO dao = new EventosDAO();
                    List<Eventos> eventos = dao.listarEventos();
                    Iterator<Eventos> it = eventos.iterator();
                    while(it.hasNext()){
                            e = it.next();
                %>
                    <tr>
                        <td><%= e.getNomEvento() %></td>
                        <td><%= e.getNomPersona() %></td>
                        <td><%= e.getTelefono() %></td>
                        <td><%= e.getFecha() %></td>
                        <td><%= e.getHora() %></td>
                        <td><%= e.getHoraFin()%></td>
                        <td><%= e.getNombreLugar() %></td>
                        <td><a href="Controlador?accion=editarEvento&id=<%= e.getId() %>&nomEvento=<%= e.getNomEvento() %>&cliente=<%= e.getId_cliente() %>&fecha=<%= e.getFecha()%>&hora=<%= e.getHora()%>&horaFin=<%= e.getHoraFin()%>&lugar=<%= e.getId_lugar()%>" ><img src="img/editar.png" alt="Editar Evento"/></a></td>
                        <td><a href="Controlador?accion=eliminarEvento&id=<%= e.getId() %>" ><img src="img/eliminar.png" alt="Eliminar"/></a></td>
                    </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </body>
</html>
