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
        <tr style="background-color:green;color:beige;font:700 10pt verdana">
            <th>ISBN</th>
            <th>Titulo</th>
            <th>Autor</th>
            <th>Preço</th>
            <th>Categoria</th>
            <th>Editora</th>
            <th>Ação</th>
        </tr>

        <%
          String cond = (String) request.getAttribute("cond");

          if(cond == null) cond = "1=1";

          //String SQL = ("SELECT rownum, isbn, Titulo, autor, preco, cat, pub, FROM livros WHERE " + cond);
          Connection con = DbConnect.getConexao();
          
          Statement pstm = con.createStatement();
          
         
          ResultSet rs = pstm.executeQuery("SELECT isbn, Titulo, autor, preco, cat, pub FROM livros WHERE " + cond);

          while(rs.next()) {
        	  
        %>

        <tr>
            <td>
                <%=rs.getInt(1)%>
            </td>
            <td>
                <%=rs.getString(2)%>
            </td>
            <td>
                <%=rs.getString(3)%>
            </td>
            <td>
                <%=rs.getInt(4)%>
            </td>
            <td>
                <%=rs.getString(5)%>
            </td>
            <td>
                <%=rs.getString(6)%>
            </td>
            <td>
                <a href="addLivro.jsp?isbn=<%=rs.getString("isbn")%>>">Adicionar ao Carrinho</a>
            </td>
        </tr>
        <%} rs.close();
            pstm.close();
            con.close();
        %>
    </table>
</body>

</html>