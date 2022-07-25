<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>


<jsp:useBean id="usuario" scope="session" class="br.com.java.model.Usuario" />
<%@ page import="java.sql.*" %>
<%@ page import="br.com.java.connection.DbConnect" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>

<body>
    <h3>Lista de Livros</h3>
    <table>
        <tr>
            <th>&nbsp;</th>
            <th>N� de S�rie</th>
            <th>ISBN</th>
            <th>Titulo</th>
            <th>Pre�o</th>
            <th>Autor</th>
            <th>Categoria</th>
            <th>Editora</th>
        </tr>

        <%
          String cond = (String) request.getAttribute("cond");

          if(cond == null) cond = "1=1";

          String SQL = ("SELECT rownum, isbn, Titulo, autor, preco, cat, pub, FROM livros WHERE " + cond);
          PreparedStatement pstm;
          
          pstm = DbConnect.getConexao().prepareStatement(SQL);
          ResultSet rs = pstm.executeQuery();

          while(rs.next()) {
        	  
        %>

        <tr>
            <td>
                <a href="addLivro.jsp?isbn=<%=rs.getString("isbn")%>>">Adicionar ao Carrinho</a>
            </td>
            <td>
                <%=rs.getInt(1)%>
            </td>
            <td>
                <%=rs.getInt(2)%>
            </td>
            <td>
                <%=rs.getInt(3)%>
            </td>
            <td>
                <%=rs.getInt(4)%>
            </td>
            <td>
                <%=rs.getInt(5)%>
            </td>
            <td>
                <%=rs.getInt(6)%>
            </td>
            <td>
                <%=rs.getInt(7)%>
            </td>
        </tr>
        <%} rs.close();
            pstm.close();
            //con.close();
        %>
    </table>
</body>

</html>