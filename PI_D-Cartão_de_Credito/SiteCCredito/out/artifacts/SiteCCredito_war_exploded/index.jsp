<%--
  Created by IntelliJ IDEA.
  User: anderson
  Date: 22/10/16
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Login</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/estilo.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <h1 class="text-center">Entre com sua conta</h1>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <input type="text" class="form-control input-lg" placeholder="Login" required autofocus/>
            </div>

            <div class="form-group">
                <input type="password" class="form-control input-lg" placeholder="Senha" required/>
            </div>

            <div class="form-group">
                <input type="submit" class="btn btn-block btn-lg btn-primary" value="Entrar"/>
                <span class="pull-right"><a href="#">Registre-se</a></span>
            </div>
        </div>
    </div>
</div>
</body>
</html>
