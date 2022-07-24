<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="css/registrojsp.css">
</head>
<body>
    <jsp:useBean id="usuario" class="obs.user" scope="session" />
    <jsp:setProperty  name="usuario" property="*" />

    <% 

    String resultado = usuario.registrarUsuario()

    if(resultado == null) 
        response.sendRedirect("home.jsp");
    else 
      out.println("<h3>Desculpe! Falha no registro com erro: <p> " + resultado + </p>"</h3> <p><a href=register.html>Tente novamente </a> "</p> ")
    %>
</body>
</html>