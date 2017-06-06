<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf"%>
        <h1>Listar Livros</h1>
        <table>
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Ano</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="livro" items="${livros}">
            <tr>
                <td><a href="editar.html?id=${livro.id}">${livro.id}</a></td>
                <td>${livro.titulo}</td>
                <td>${livro.autor}</td>
                <td>${livro.ano}</td>
                <td><a href="excluir.html?id=${livro.id}">&#128465;</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
