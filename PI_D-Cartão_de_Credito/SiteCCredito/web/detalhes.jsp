<%-- 
    Document   : detalhes
    Created on : 06/11/2016, 11:13:26
    Author     : anderson
--%>
<%@page import="classes_auxiliares.Cliente"%>
<%@page import="java.util.*"%>
<%@page import="servlets.ListaClienteServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/estilo_info.css">
        
        <title>Informações do Cliente</title>
    </head>
    <body>
        <div class="container">
            
            <div class="dropdown-header">
                <h2> Informações do Cliente </h2>
            </div>
            
            <form  class="" action="listaClientes.jsp">
                
                <h5>
                </h5>
                
                
                <div class="form-group">
                    Nome completo: <input type="text" disabled="disabled" name="nome" value=" ${cliente.nome}"
                                          style="width: 650px"/> 
                </div>
                    
                <div class="form-group">
                    CPF: <input value=" ${cliente.cpf}" type="text" disabled="disabled" name="cpfOp" />
                    RG: <input value=" ${cliente.rg}" type="text" disabled="disabled" name="rgOp" /> 
                    Data de nascimento: <input value=" ${cliente.nascimento}" type="text" disabled="disabled" name="nascOp"/> 
                </div>
                
                <div class="form-group">
                    Endereço: <input value=" ${cliente.endereco}" type="text" disabled="disabled" name="endereco" style="width: 700px"/> 
                </div>
                
                <div class="form-group">
                    Cidade: <input value=" ${cliente.cidade}" type="text" disabled="disabled" name="cidade"/> 
                </div>
                
                <div class="form-group">
                    E-mail: <input value=" ${cliente.email}" type="email" disabled="disabled" name="email" style="width: 700px"/> 
                </div>
                
                 <div class="form-group">
                     Telefone: <input value=" ${cliente.telefone}" type="tel" disabled="disabled" name="telefoneCli"/> 
                </div>
                
                <ul>
                    <hr style="height:1px; border:none; color:#000;
                        background-color:#000;"/>
                </ul>  
                
                <div class="form-group">
                    <c:forEach var="lista" items="${contas}">
                        Conta: <label name="conta">${lista}</label>
                        
                        <ul>
                            <hr style="height:1px; border:none; color:#000;
                                   background-color:#000;"/>
                        </ul> 
                    </c:forEach>
                        
                        <c:forEach var="lista2" items="${cartoes}">
                        <p class="posi form-horizontal">
                            Cartão:<label name="cartao">${lista2.numero_cartao}</label>
                            <input type="radio" class="radio-inline" name="estatos" value="ativo" /> Ativo
                            <input type="radio" class="radio-inline" name="estatos" value="bloqueado" /> Bloqueado
                        </p>
                        </c:forEach>
                </div>
                
                <div class="form-group ">
                    <input type="submit" name="btnVoltar" value="Voltar" class="btn btn-lg btn-success"/>
                </div>
                
            </form>
        </div>
    </body>
</html>
