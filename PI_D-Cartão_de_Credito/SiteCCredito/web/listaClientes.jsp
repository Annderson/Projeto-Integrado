<%-- 
    Document   : listaClientes
    Created on : 04/11/2016, 16:32:31
    Author     : anderson
--%>
<
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        
        <script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="css/jquery.dataTables.css">
        <link rel="stylesheet" href="css/layout.listaClientes.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css"> 
        
        <script >
            
            function enviarr(r){
                window.location.href="InfoClienteServlet?id=" + r;
            }
            
        </script>
    </head>
    <body>
        <div class="container">
            <form action="ListaClienteServlet" method="get">
                
                    Ordenar por: <select class="fonteC espA1 input-lg" id="ordenarLi" name="ordenarL">
                        <option value="nomeL"> Nome </option>
                        <option value="cidadeL"> Cidade </option>
                        <option value="telefoneL"> Telefone </option>
                    </select>
                    <button class="btn-primary">Ordenar</button>
                
            </form>
            
            <form action="ListaClienteServlet" method="post">
                <p class="espA2 fonteC input-lg">
                    CPF: <input  type="text" value="${cpf}" id="buscaCpf" name="buscaCpf"/>  
                    <button class="btn-primary"> Buscar </button>
                </p>
            </form>
                    
            <div class="row">
                <div class="col-xs-12">
                    <table class="table table-hover" id="tbClientes" >
                        <thead border="1">
                            <tr>
                                <th> NUmero </th>
                                <th> Nome </th>
                                <th> CPF </th>
                                <th> Cidade </th>
                                <th> Data de Nascimento </th>
                                <th> Telefone </th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="cliente" items="${clientes}">  
                            <tr>
                                <td> ${cliente.idCliente} </td>
                                <td> ${cliente.nome} </td>
                                <td> ${cliente.cpf} </td>
                                <td> ${cliente.cidade} </td>
                                <td> ${cliente.nascimento} </td>
                                <td> ${cliente.telefone} </td>
                                <td> <button onclick="enviarr(${cliente.idCliente})">Informções</button> </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
    </body>
</html>
