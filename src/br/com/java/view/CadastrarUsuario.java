package br.com.java.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import br.com.java.model.Usuario;

@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/cadastrarusuario"})
public class CadastrarUsuario extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/registro.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.println("POST - CADASTRAR USUARIO");
        Usuario u = new Usuario();
   
        u.setU(request.getParameter("uname"));
        u.setSenha(request.getParameter("senha"));
        u.setNome(request.getParameter("nome"));
        u.setCpf(request.getParameter("cpf"));
        u.setTelefone(request.getParameter("telefone"));
        u.setEndereco(request.getParameter("endereco"));

        UsuarioDAO dao = new UsuarioDAO();

        if (dao.cadastraUsuario(u)) {
            request.setAttribute("usuario", u);
            HttpSession ses = request.getSession();
            ses.setAttribute("usuario",u);
        } else {
            //enviar um atributo msg de erro
            request.setAttribute("erro", "Usuário ou senha inválida!");
        }
        
        response.sendRedirect("listarprodutos");

    }
}
