<%-- 
    Document   : cadastro_funcionario
    Created on : 14/11/2016, 11:55:01
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/estilo_cad.css">
        <title>Cadastro de Operador</title>
        
    </head>
    <body>
        
        <div class="container">
            
            <div class="dropdown-header" >
                <span class="pull-right"> <a href="index.jsp" > Voltar</a> </span>
                <h3 style="color: #fff"> Cadastro de Operadores </h3>
            </div>
            
            <form method="post" action="CadastroOpServlet">
                
                <div class="form-group">
                    Numero de registro: <input type="text" class="form-inline input-lg"
                                               name="roOp" placeholder="Registro do Operador" required autofocus/>
                </div>
             
                <div class="form-group">
                    Nome completo: <input type="text" class="form-control input-lg" name="nomeOp" required/> 
                </div>
                    
                <div class="form-group">
                    CPF: <input type="text" class="input-lg " name="cpfOp" placeholder="XXX.XXX.XXX-XX" required/>
                    RG: <input type="text" class="input-lg" name="rgOp" placeholder="XX.XXX.XXX-X" required/> 
                    Data de nascimento: <input type="text" class="input-lg" name="nascOp" placeholder="Data de nascimento" required/> 
                </div>
                
                <div class="form-group">
                    Endereço: <input type="text" class="form-control input-lg" name="enderecoOp" required/> 
                </div>
                
                <div class="form-group">
                    Cidade: <input type="text" class="input-lg" name="cidadeOp" required/> 
                </div>
                
                <div class="form-group">
                    E-mail: <input type="email" class="form-control input-lg" name="emailOp" placeholder="exemplo@exemĺo.com" required/> 
                </div>
                
                <div class="form-group">
                     Telefone: <input type="tel" class="input-lg" name="telefoneOp" placeholder="(99) 9999-9999" required/> 
                </div>
                
                <div class="form-group">
                    Senha: <input type="password" class=" input-lg" name="senha" required/> 
                </div>
                
                <div>
                    <h4>
                        <%
                            String msn = (String) request.getAttribute("msn");
                            if (msn != null)
                                out.print(msn);
                        %>
                    </h4> 
                </div>
                
                <div class="form-group">
                    Confirme a senha: <input type="password" class="input-lg" name="confSenha" required/> 
                </div>
                
                <div class="form-group ">
                    <input type="submit" name="btnSalvar" value="Salvar" class="btn btn-lg btn-primary"/>
                </div>
            </form>
        </div>
    </body>
</html>
