<%-- 
    Document   : index
    Created on : 24/10/2024, 12:26:45 PM
    Author     : Antonio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <style>
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
            background-color: #ff3333;
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
         /* Estilo del botón */
        .button {
            width: 100%;
            padding: 12px;
            font-size: 16px;
            color: #fff;
            background-color: #007BFF;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .button:hover {
            background-color: #0056b3;
        }
    </style>
    <body>
         <div class="form-container">
            <h2>Al Parecer El Evento ya Se Encuentra Reservado en Esa HORA</h2>
            <form action="Controlador" method="get">
                 <input type="submit" name="accion" value="Volver" class="button">
            </form>
        </div>
    </body>
</html>

