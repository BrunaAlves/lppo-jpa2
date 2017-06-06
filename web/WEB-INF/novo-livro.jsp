<%-- 
    Document   : novo-livro
    Created on : 02/06/2017, 21:54:07
    Author     : alunoces
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="jspf/menu.jspf"%>
        <h1>Novo Livro</h1>
        <form method="post">
            <label>Título: <input name="titulo" /></label>
            <label> Ano: <input name="ano" /></label>
            <label>Autor: <input name="autor" /></label>
            <input type="submit" />
        </form>
    </body>
</html>
