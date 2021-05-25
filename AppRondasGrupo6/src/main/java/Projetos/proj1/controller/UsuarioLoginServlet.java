package Projetos.proj1.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Projetos.proj1.domain.Usuario;
import Projetos.proj1.jpa.JpaUtil;

@WebServlet("/UsuarioLoginServlet")
public class UsuarioLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public UsuarioLoginServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		Query qry = em.createQuery("from Usuario where email = :email and senha = :senha");
		qry.setParameter("email", request.getParameter("inputEmail"));
		qry.setParameter("senha", request.getParameter("inputPassword"));
		Usuario usuarioLogado = null;
		try {
			usuarioLogado = (Usuario) qry.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		if (usuarioLogado == null) {
			request.setAttribute("mensagemLogin", "Login ou Senha inválida!");
			request.getRequestDispatcher("UsuarioLogin.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("usuarioLogado", usuarioLogado);
			response.sendRedirect("Privada/Home/Home.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
