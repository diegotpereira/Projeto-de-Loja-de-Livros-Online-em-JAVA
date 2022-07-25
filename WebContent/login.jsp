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

   <jsp:setProperty name="usuario" property="*" />

   <%

      UsuarioDao.login();
      if(!usuario.isLogado())
   %>
   <h3>Longin Inválido. Clique <a href="login.html">aqui</a> e tente novamente!</h3>
   <% 
      else

         response.sendRedirect("home.jsp");
   %>
</body>
</html>