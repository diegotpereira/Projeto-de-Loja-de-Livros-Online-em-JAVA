package br.com.java.view;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.com.java.dao.UsuarioDao;
import br.com.java.model.Usuario;

@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/cadastrarusuario"})
public class CadastrarUsuario extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/registro.html");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("POST - CADASTRAR USUARIO");
        Usuario usuario = new Usuario();
        
        usuario.setUnome(request.getParameter("unome"));
        usuario.setPwd(request.getParameter("pwd"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setEndereco(request.getParameter("endereco"));
        usuario.setTelefone(request.getParameter("telefone"));
        //// Boolean.parseBoolean(request.getParameter("logado"));
        
        UsuarioDao dao = new UsuarioDao();

        if (dao.registrarUsuario(usuario)) {
            request.setAttribute("usuario", usuario);
            HttpSession ses = request.getSession();
            ses.setAttribute("usuario", usuario);
        } else {
            //enviar um atributo msg de erro
            request.setAttribute("erro", "Usuário ou senha inválida!");
        }
        
        response.sendRedirect("index.jsp");

    }
}
