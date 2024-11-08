<%-- 
    Document   : login
    Created on : 4 nov 2024, 7:24:33 p.m.
    Author     : axel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión</title>
    <style>
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
            height: 100vh;
            background-color: #f2f2f2;
        }
        /* Contenedor del formulario de login */
.login-container {
    max-width: 400px;
    margin: 5rem auto;
    padding: 2rem;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center;
}

.login-container h2 {
    font-size: 1.8rem;
    color: #333;
    margin-bottom: 1.5rem;
}

.login-container label {
    display: block;
    font-size: 1rem;
    color: #333;
    margin: 0.5rem 0 0.2rem;
    text-align: left;
}

.login-container input {
    width: 100%;
    padding: 0.8rem;
    font-size: 1rem;
    margin-bottom: 1rem;
    border: 1px solid #ddd;
    border-radius: 5px;
}

.button {
    width: 100%;
    padding: 0.8rem;
    font-size: 1rem;
    color: #fff;
    background-color: #4CAF50;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-weight: bold;
}

.button:hover {
    background-color: #45a049;
}

/* Mensaje de error */
.error-message {
    color: red;
    font-size: 0.9rem;
    margin-top: 1rem;
}

    </style>
</head>
<body>
    <div class="login-container">
        <h2>Iniciar Sesión</h2>
        <form id="loginForm" action="Controlador" method="post">
            <label for="usuario">Usuario</label>
            <input type="text" id="usuario" name="usuario" required>

            <label for="clave">Contraseña</label>
            <input type="password" id="clave" name="clave" required>

            <input type="submit" value="ingresar" name="accion" class="button"/>
        </form>
        <p id="loginError" class="error-message"></p>
    </div>

</body>
</html>
