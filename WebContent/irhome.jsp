<jsp:useBean id="usuario" class="br.com.java.model.Usuario" scope="session"/>

<%
  if(usuario.isLogado())
	  response.sendRedirect("index.jsp");

  else 
	  response.sendRedirect("login.html");
%>