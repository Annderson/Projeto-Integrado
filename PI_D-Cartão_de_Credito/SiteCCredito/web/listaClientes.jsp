<%-- 
    Document   : listaClientes
    Created on : 04/11/2016, 16:32:31
    Author     : anderson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="lista" class="servlets.ListaClienteServlet"/>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Clientes</title>
        <script type="text/javascript" src="js/jquery.js"></script>
        
        <link rel="stylesheet" href="css/layout.listaClientes.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css"> 
        
        <script >
            
            function enviar(id){
                $.ajax({
                    url: 'ListaClienteServlet', 
                    type: 'GET',
                    data: {id: id},
                    success: function (r) {
                        window.location.href="detalhes.jsp?numero=" + r;
                         console.log(r);
                         alert(r);
                    },
                    error: function (e) {
                        console.log("ERRO:");
                        console.log(e);
                    }
                });
            }
            
            function enviarr(r){
                window.location.href="ListaClienteServlet?id=" + r;
            }
            
        </script>
    </head>
    <body>
        <div class="container">
            <p class="">
                <p class="fonteC espA1 input-lg">
                    Ordenar por: <select>
                        <option> Nome </option>
                        <option> Cidade </option>
                        <option> Telefone </option>
                    </select>
                
                    <button class="btn-primary">Ordenar</button>
                </p>
                <p class="espA2 fonteC input-lg">
                    CPF: <input  type="text" name="buscaCpf"/>  
                    <button class="btn-primary"> Buscar </button>
                </p>
            </p>
            <div class="row">
                <div class="col-xs-12">
                    <table class="table table-hover" >
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
                            <c:forEach var="cliente" items="${lista.clientesServlet}">  
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
