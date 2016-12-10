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
            
            <form  class="form-control-static" method="post" action="InfoClienteServlet" >
                
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
                        
                        Conta: <label name="conta">${lista}</label><br>
                        
                        <c:forEach var="cartao"  items="${cartoes}">
                            
                            <c:if test="${lista == cartao.numero_conta}">
                                <p class="posi form-horizontal">
                                    Cartão: <label name="cartao">${cartao.numero_cartao}  :</label>
                                    <input type="text" name="estado" value="${cartao.estado}"/>
                                </p>
                            </c:if>
                                
                        </c:forEach>
                        <ul>
                            <hr style="height:1px; border:none; color:#000;
                                   background-color:#000;"/>
                        </ul> 
                    </c:forEach>          
                        
                </div>
                
                <div class="form-group ">
                    <input type="submit" name="btnSalvar" id="V" value="Voltar" class="btn btn-lg btn-success"/>
                    <input type="submit" name="btnSalvar" id="S" value="Salvar" class="btn btn-lg btn-success posiBs"/>
                </div>
                
            </form>
        </div>
    </body>
</html>
