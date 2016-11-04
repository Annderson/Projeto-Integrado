<%-- 
    Document   : index
    Created on : 04/11/2016, 15:17:04
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/estilo.css">
        
        <title>Login</title>
    </head>
    <body style="background-color:#4cae4c">
        <div class="modal-dialog">
            <form>
                <div class="form-group">
                    Login: <input type="text" class="form-control input-lg" name="login" placeholder="Login" autofocus/>
                </div>
             
                <div class="form-group">
                    Senha: <input type="text" class="form-control input-lg" name="senha" placeholder="Senha" required/> 
                </div>
                
                <div class="form-group">
                    <input type="submit" name="btnSalvar" value="Salvar" class="btn btn-block btn-lg btn-primary"/>
                </div>
            </form>
            <span class="pull-right"> <a href="" > Cadastra-se </a> </span>
        </div>
    </body>
</html>
