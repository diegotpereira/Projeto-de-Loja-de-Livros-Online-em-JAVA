<%@page import="br.com.java.dao.UsuarioDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <jsp:useBean id="usuario" class="br.com.java.model.Usuario" scope="session" />
     <jsp:setProperty  name="usuario" property="*" />
     
     <% int i = UsuarioDao.salvarUsuario(usuario); 
     
     if (i > 0) 
         response.sendRedirect("index.jsp"); 
     else
         out.println("<h3>Sorry! Registration Failed With Error : <p> " + i + "</h3> <p> <a href=register.html>Try Again </a> ");
     %>
</body>
</html>