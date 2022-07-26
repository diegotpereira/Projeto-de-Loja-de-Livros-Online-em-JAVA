<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<jsp:useBean id="carrinho" class="br.com.java.model.Carrinho" scope="session" />
<jsp:useBean id="usuario" class="br.com.java.model.Usuario" scope="session" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
      //<!-- verifique se o usu�rio fez login, caso contrário, envie o usu�rio para a p�gina de login -->
      out.println(usuario.isLogado());

      if(!usuario.isLogado())
        response.sendRedirect("login.html");

        //<!-- ler dados sobre o item -->
        String isbn = request.getParameter("isbn");

        carrinho.adicionarItem(isbn);

        response.sendRedirect("index.jsp");
    %>
</body>
</html>