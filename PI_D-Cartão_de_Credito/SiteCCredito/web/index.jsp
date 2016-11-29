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
        <link rel="stylesheet" href="css/estilo_login.css"/>
        
        <title>Login</title>
    </head>
    <body>
        <div class="modal-dialog">
            
            <div class="dropdown-header">
                    <h3 style="color: #ee5543"><% 
                        String msn = (String) request.getAttribute("msn");
                        if (msn != null)
                            out.print(msn);
                        else{
                          //  out.print("R.O ou senha invalidos");
                        }
                    %>
                    </h3>
            </div>
            
            <form method="post" action="LoginServlet">
                
                <div class="form-group">
                    R.O: <input type="text" class="form-control input-lg" name="logar" placeholder="Numero do registro" autofocus/>
                </div>
             
                <div class="form-group">
                    Senha: <input type="password" class="form-control input-lg" name="senha" placeholder="Senha" required/> 
                </div>
                
                <div class="form-group">
                    <input type="submit" name="btnLogar" value="Logar" class="btn btn-block btn-lg btn-primary"/>
                </div>
            </form>
            <span class="pull-right"> <a href="cadastro_funcionario.jsp" > Cadastra-se </a> </span>
        </div>
    </body>
</html>
