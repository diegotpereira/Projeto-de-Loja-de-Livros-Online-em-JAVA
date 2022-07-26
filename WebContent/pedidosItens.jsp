<%@page import="br.com.java.connection.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>

<body>
    <h1>Itens do Pedido</h1>

    <%
       String pedidoid = request.getParameter("pedidoid");
       String status = request.getParameter("status");
       String SQL = "SELECT oi.isbn, titulo, oi.preco, qtd, oi.preco * qtv quantia FROM pedidoitem oi, livros b WHERE b.isbn = oi.isbn and pedidoid = " + pedidoid;
       
       Connection con = DbConnect.getConexao();
       Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(SQL);
       
       
    %>
    <table>
        <tr>
            <th>ISBN</th>
            <th>Titulo</th>
            <th>Preco</th>
            <th>Quantidade</th>
            <th>Valor Total</th>
        </tr>

        <% while (rs.next()) { %>

            <tr>
                <td>
                    <%=rs.getInt(1)%>
                </td>
                <td>
                    <%=rs.getString(2)%>
                </td>
                <td>
                    <%=rs.getInt(3)%>
                </td>
                <td>
                    <%=rs.getString(4)%>
                </td>
                <td>
                    <%=rs.getString(5)%>
                </td>
            </tr>

        <%
        }
           rs.close();
           st.close();
           con.close();
        %>
    </table>
</body>
</html>