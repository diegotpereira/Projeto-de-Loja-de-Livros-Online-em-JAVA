<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table id="tabela1">
        <tr style="font:700 11pt verdana;background-color:green;color:white">
            <td>
                bem vindo <b></b>
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
                                        <th>Quantidade</th>
                                        <th>&nbsp</th>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <input type="hidden">
                                        <td id="tdDireito"></td>
                                        <td id="tdCentro"></td>
                                        <td id="tdDireito"></td>
                                        <td id="tdCentro">Remove</td>
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
                <input type="submit" value="">
                <p>
                    <input type="submit" value="">
                </p>
                <input type="submit" value="">
            </td>
        </tr>
        <tr>
            <td>
                <a href="">Alterar detalhes do usuário</a> &nbsp;&nbsp;
                <a href="">Procurar livros</a> &nbsp;&nbsp;
                <a href="">Livros de consulta</a> &nbsp;&nbsp;
                <a href="">Histórico de pedidos</a> &nbsp;&nbsp;
                <a href="">Sair</a> &nbsp;&nbsp;
            </td>
        </tr>
    </table>
</body>
</html>