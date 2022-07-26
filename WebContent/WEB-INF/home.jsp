<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
    <jsp:userBean name="usuario" scope="session" class="br.com.java.model.Usuario" />

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>

<body>
    <div>
        Bem Vindo
        <b>
            <jsp:getProperty id="usuario" property="unome" name="" />
        </b>
    </div>
</body>

</html>