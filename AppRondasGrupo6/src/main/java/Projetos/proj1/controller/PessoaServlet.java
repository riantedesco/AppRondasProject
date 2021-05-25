package Projetos.proj1.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Projetos.proj1.domain.Pessoa;
import Projetos.proj1.jpa.JpaUtil;

@WebServlet("/Privada/Pessoa/PessoaServlet")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public PessoaServlet() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("gravar") != null) {
			gravar(request, response);
		} else if (request.getParameter("incluir") != null) {
			incluir(request, response);
		} else if (request.getParameter("alterar") != null) {
			alterar(request, response);
		} else if (request.getParameter("excluir") != null) {
			excluir(request, response);
		} else if (request.getParameter("cancelar") != null) {
			cancelar(request, response);
		} else { // default = consultar
			listar(request, response);
		}
	}

	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("excluir"));
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Pessoa.class, id));
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}


	private void cancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listar(request, response);
	}


	private void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("alterar"));
		EntityManager em = JpaUtil.getEntityManager();
		Pessoa p = em.find(Pessoa.class, id); 
		em.close();
		request.setAttribute("p", p); 
		request.getRequestDispatcher("PessoaForm.jsp").forward(request, response);
	}


	private void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("PessoaForm.jsp").forward(request, response);
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List <Pessoa> listaPessoa = em.createQuery("from Pessoa").getResultList();
		em.close();
		request.setAttribute("listaPessoa", listaPessoa);
		request.getRequestDispatcher("PessoaList.jsp").forward(request, response);
	}

	
	private void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pessoa p = inicilizarObjeto(request);
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();
		List <Pessoa> listaPessoa = em.createQuery("from Pessoa").getResultList();
		em.close();
		request.getRequestDispatcher("PessoaList.jsp").forward(request, response);
	}

	
	private Pessoa inicilizarObjeto(HttpServletRequest request) {
		Pessoa p = new Pessoa (
				request.getParameter("id").equals("") ? null : Integer.parseInt(request.getParameter("id")), 
				request.getParameter("nome"), 
				request.getParameter("loginApp"),
				request.getParameter("senha"));
		return p;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
