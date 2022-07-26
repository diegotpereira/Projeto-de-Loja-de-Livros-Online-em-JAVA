<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<jsp:useBean id="usuario" scope="session" class="br.com.java.model.Usuario" />
<jsp:useBean id="carrinho" scope="session" class="br.com.java.model.Carrinho" />

<%@ page import="java.util.*" %>

<%
    String act = request.getParameter("act");

    if(act != null) {
        if(act.equals("Finalizar Pedido")) {

            String pedidoid;
            pedidoid =  carrinho.finalizarPedido(usuario.getUsuarioid());

            if(pedidoid == null) {
                out.println("Desculpe! Pedido não pode ser finalizado.");

                return;
            } else {
                out.println("O pedido foi finalizado. Código do pedido: " + pedidoid);
                out.println("<a href=index.jsp>Continuar...</a>");

                carrinho.limparTudo();

                return;
            }
        }
        if(act.equals("remover")) {
            carrinho.removerItem(request.getParameter("isbn"));
        } else {
            if(act.equals("Atualizar Carrinho")) {

                String isbn[] = (String[]) request.getParameterValues("isbn");
                String qtd[] = (String[]) request.getParameterValues("qtd");

                for(int i = 0; i < isbn.length; i++) 
                    carrinho.atualizarQtd(isbn[i], Integer.parseInt(qtd[i]));
                    
            } else if(act.equals("Limpar Carrinho"))
                carrinho.limparTudo();
        }
    }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/estilo.css">
</head>
<body>
    <table id="tabela1">
        <tr style="font:700 11pt verdana;background-color:green;color:white">
            <td>
                Bem vindo 
                <b>
                    <jsp:getProperty name="usuario" property="unome" />
                </b>
            </td>
        </tr>
        <tr style="font:10pt verdana">
            <td>
                <h2>Carrinho de Compras</h2>
                <table width="100%" id="tabela2">
                    <tr>
                        <td width="100%">
                            <form action="index.jsp" method="get">
                                                <table id="tabela3">
                                                    <tr>
                                                        <th>T�tulo do Livro</th>
                                                        <th>Pre�o</th>
                                                        <th>Quantidade</th>
                                                        <th>Total</th>
                                                        <th>&nbsp;</th>
                                                    </tr>
                                                    <%
                                                    br.com.java.model.Item item;

                                                    ArrayList itens = carrinho.getItens();

                                                    Iterator iterator = itens.iterator();

                                                    int total = 0;

                                                    while(iterator.hasNext()) {
                                                        item = (br.com.java.model.Item) iterator.next();

                                                        total += item.getQtd() * item.getPreco();
                                                    
                                                    %>
                                                    <tr>
                                                        <td>
                                                            <input type="hidden" name="isbn" value=<%=item.getIsbn()%> name=isbn>
                                                            <%=item.getTitulo()%>
                                                        </td>
                                                        
                                                        <td id="tdDireito">
                                                            <%=item.getPreco()%>
                                                        </td>
                                                        <td id="tdCentro">
                                                            <input type="text" name="qtd" id="" size="5" value=<%=item.getQtd()%>>
                                                        </td>
                                                        
                                                        <td id="tdDireito">
                                                            <%=item.getQtd() * item.getPreco()%>
                                                        </td>
                                                        <td id="tdCentro">
                                                            <a href="index.jsp?act=remover&isbn=<%item.getIsbn();%>">Remover</a>
                                                        </td>
                                                    </tr>

                                                    <%
                                                        }
                                                    %>
                                                    <tr>
                                                        <td colspan=5 style="text-align:center;font:700 12pt verdana;color:navy">
                                                            Valor total: <%=total%>
                                                        </td>
                                                    </tr>
                                                </table>
                                        </td>
                                        <td>
                                            <p>
                                                <input type="submit" value="Atualizar Carrinho" name="act">
                                            </p>
                                            <p>
                                                <input type="submit" value="Limpar Carrinho" name="act">
                                            </p>
                                            <p>
                                                <input type="submit" value="Finalizar Pedido" name="act">
                                            </p>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                            <td>
                                [<a href="">Alterar detalhes do usu�rio</a>] &nbsp;&nbsp;
                                [<a href="navegacaoLivros.jsp">Lista de Livros</a>] &nbsp;&nbsp;
                                [<a href="consultaLivro.jsp">Pesquisar Livros</a>] &nbsp;&nbsp;
                                [<a href="">Hist�rico de pedidos</a>] &nbsp;&nbsp;
                                [<a href="">Sair</a>]
                            </td>
            </td>
        </tr>
    </table>
</body>
</html>