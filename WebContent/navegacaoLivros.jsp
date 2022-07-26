<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>

    <link rel="stylesheet" href="css/navegacaoLivros.css">
</head>

<body>
    <h2>Procurar livros disponíveis</h2>
    <form action="navegacaoLivros.jsp" method="post">
        Selecione a Categoria: 
        <select name="cat" id="">
            <option value="todas">Todas Categorias</option>
            <option value="ora">Oracle</option>
            <option value=".net">.Net</option>
            <option value="java">Java</option>
        </select>
        <input type="submit" value="Navegar">

        <a href="consultaLivro.jsp">Consultar Livros</a> &nbsp;&nbsp; <a href="irHome.jsp">Home</a>
    </form>
    <%
       String cat = request.getParameter("cat");
          if(cat == null) request.setAttribute("cond", "1=1");
          else if (!cat.equals("todas")) request.setAttribute("cond", "cat = '" + cat + "'");
    %>

    <jsp:include page="listaLivro.jsp" flush="true" />
</body>

</html>