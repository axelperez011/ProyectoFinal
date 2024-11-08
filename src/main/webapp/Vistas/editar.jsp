<%-- 
    Document   : insertar
    Created on : 24/10/2024, 12:26:24 PM
    Author     : axel
--%>

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
    </style>
    <body>
        <div class="form-container">
        <h2>Registro de Evento</h2>
            <form action="Controlador" method="post">
                <label for="nombre">Nombre del Evento</label>
                <input type="text" id="nombre" name="nombreEvento" value="${ nombre }" required>
                <input type="hidden" id="nombre" name="id" value="${ idEvento }" required>
                <label for="cliente">Cliente</label>
                <select id="cliente" name="cliente">
                    <%
                        int id =(int) request.getAttribute("idCliente");
                        
                        item i = new item() ;
                        EventosDAO dao = new EventosDAO();
                        List<item> eventos = dao.obtenerOpciones("clientes");
                        Iterator<item> it = eventos.iterator();
                        while(it.hasNext()){
                            i = it.next();
                            if (id == i.getId()) {
                                    
                            %>
                                <option value="<%= i.getId() %>" selected="selected"><%= i.getDescripcion()%></option>
                            <%
                            }else{
                            %>
                                <option value="<%= i.getId() %>" ><%= i.getDescripcion()%></option>
                            <%
                            }
                        }
                    %>
                </select>

                <label for="fecha">Fecha</label>
                <input type="date" id="fecha" name="fecha" value="${fecha}"  disabled required>
                
                <label for="hora">Hora Inicio</label>
                <input type="time" id="hora" name="hora" value="${hora}" disabled required>
                
                <label for="hora_fin">Hora Termino</label>
                <input type="time" id="hora_fin" name="hora_fin" value="${horaFin}" disabled required>
                
                <label for="lugar">Lugar</label>
                  <select id="lugar" name="lugar" >
                    <option value="">--Seleccione un Lugar--</option>
                    <%
                        int idLugar = (int)request.getAttribute("lugar");
                        item iL = new item() ;
                        EventosDAO daoL = new EventosDAO();
                        List<item> eventosL = daoL.obtenerOpciones("lugar");
                        Iterator<item> itL = eventosL.iterator();
                        while(itL.hasNext()){
                            iL = itL.next();
                            if (idLugar == iL.getId()) {
                                    
                            %>
                                <option value="<%= iL.getId() %>" selected="selected"><%= iL.getDescripcion()%></option>
                            <%
                            }else{
                                %>
                                <option value="<%= iL.getId() %>"><%= iL.getDescripcion()%></option>
                                <%
                            }
                        }
                    %>
                </select>
                <a href="Controlador?accion=Volver" class="button2">Volver</a>
                <input type="submit" name="accion" value="Actualizar" class="button">
                 
            </form>
        </div>
    </body>
</html>
