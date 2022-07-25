<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>

<jsp:useBean id="usuario" scope="session" class="br.com.java.model.Usuario" />
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
                            <form action="">
                                <table id="tabela3">
                                    <tr>
                                        <th>Titulo do Livro</th>
                                        <th>Preço</th>
                                        <th>Quantidade</th>
                                        <th>Total</th>
                                        <th>&nbsp;</th>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input type="hidden">
                                        </td>
                                         
                                        <td id="tdDireito">

                                        </td>
                                        <td id="tdCentro">
                                            <input type="text" name="" id="">
                                        </td>
                                        
                                        <td id="tdDireito">

                                        </td>
                                        <td id="tdCentro">
                                            <a href="">Remover</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan=5 style="text-align:center;font:700 12pt verdana;color:navy">
                                            Valor total
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
            </td>
            <td>
                <input type="submit" value="Atualizar Carrinho">
                <p>
                    <input type="submit" value="Limpar Carrinho">
                </p>
                <input type="submit" value="Finalizar Pedido">
            </td>
        </tr>
        <tr>
            <td>
                [<a href="">Alterar detalhes do usuário</a>] &nbsp;&nbsp;
                [<a href="">Procurar livros</a>] &nbsp;&nbsp;
                [<a href="">Livros de consulta</a>] &nbsp;&nbsp;
                [<a href="">Histórico de pedidos</a>] &nbsp;&nbsp;
                [<a href="">Sair</a>]
            </td>
        </tr>
    </table>
</body>
</html>