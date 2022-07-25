<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>

<body>
    <h2>Consulta de Livros</h2>
    <form action="consultaLivro.jsp" method="post">
        <table>
            <tr>
                <td>
                    Categoria
                </td>
	                <select name="cat">
	                    <option value="todas">Todas Categorias</option>
	                    <option value="ora">Oracle</option>
	                    <option value=".net">.Net</option>
	                    <option value="java">Java</option>
	                </select>
	                T�tulo Cont�m
	                <input type="text" name="titulo" id="titulo" size="20">
            </tr>
            <tr>
                <td>
                    Nome do autor cont�m
                    <input type="text" name="autor" id="autor" size="10">
                    Para Pre�o
                    <input type="text" name="parapreco" id="" size="10">
                </td>
            </tr>
        </table>
        <p>
            <input type="submit" value="Consultar">
            <a href="irhome.jsp">Pagina inicial</a>
        </p>
    </form>
    <%
      String cat = request.getParameter("cat");

           if(cat ==null) return;

      String cond = "1=1"; 

           if(!cat.equals("todas")) cond = cond + " and cat = '" + cat + "'";
        
      String titulo = request.getParameter("titulo");
           if(!titulo.equals("")) cond = cond + " and titulo like '%" + titulo + "%'";

      String autor = request.getParameter("autor");
           if(!autor.equals("")) cond = cond + " and autor like '%" + autor + "%'";

      String dopreco = request.getParameter("dopreco");
           if(!dopreco.equals("")) cond = cond + " and preco >= " + dopreco;
        
      String parapreco = request.getParameter("parapreco");
           if(!parapreco.equals("")) cond = cond + " and preco <= " + parapreco;     
    %>
    <jsp:include page="listaLivro.jsp" flush="true" />
</body>

</html>