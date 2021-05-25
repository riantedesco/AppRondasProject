package Projetos.proj1.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Projetos.proj1.domain.Locomocao;
import Projetos.proj1.jpa.JpaUtil;

@WebServlet("/Privada/Locomocao/LocomocaoServlet")
public class LocomocaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
    public LocomocaoServlet() {
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
		em.remove(em.find(Locomocao.class, id));
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
		Locomocao lm = em.find(Locomocao.class, id); 
		em.close();
		request.setAttribute("lm", lm); 
		request.getRequestDispatcher("LocomocaoForm.jsp").forward(request, response);
	}
	
	
	private void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("LocomocaoForm.jsp").forward(request, response);
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List <Locomocao> listaLocomocao = em.createQuery("from Locomocao").getResultList();
		em.close();
		request.setAttribute("listaLocomocao", listaLocomocao);
		request.getRequestDispatcher("LocomocaoList.jsp").forward(request, response);
	}
	
	
	private void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Locomocao lm = inicilizarObjeto(request);
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(lm);
		em.getTransaction().commit();
		List <Locomocao> listaLocomocao = em.createQuery("from Locomocao").getResultList();
		em.close();
		request.setAttribute("listaLocomocao", listaLocomocao);
		request.getRequestDispatcher("LocomocaoList.jsp").forward(request, response);
	}

	
	private Locomocao inicilizarObjeto(HttpServletRequest request) {
		Locomocao lm = new Locomocao (
				request.getParameter("id").equals("") ? null : Integer.parseInt(request.getParameter("id")), 
				request.getParameter("descricao"), 
				request.getParameter("placa"));
		return lm;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
