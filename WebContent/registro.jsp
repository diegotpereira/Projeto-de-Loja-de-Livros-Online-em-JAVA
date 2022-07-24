<!DOCTYPE html>
<%@page import="br.com.java.model.Usuario"%>
<%@page import="br.com.java.dao.UsuarioDao"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="css/registrojsp.css">
</head>
<body>
    

    <% 
    
    try {
    	Usuario ObjLivroDTO = new Usuario();
        
        
    	UsuarioDao  objLivroDAO = new UsuarioDao();
        objLivroDAO.registrarUsuario(ObjLivroDTO);
        
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
    

  
    %>
</body>
</html>