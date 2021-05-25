package Projetos.proj1.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Projetos.proj1.domain.Localizacao;
import Projetos.proj1.domain.Ronda;
import Projetos.proj1.jpa.JpaUtil;

@WebServlet("/Privada/Localizacao/LocalizacaoServlet")
public class LocalizacaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LocalizacaoServlet() {
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
		em.remove(em.find(Localizacao.class, id));
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
		Localizacao lz = em.find(Localizacao.class, id); 
		List <Ronda> listaRonda = em.createQuery("from Ronda").getResultList();
		em.close();
		request.setAttribute("lz", lz); 
		request.setAttribute("listaRonda", listaRonda);
		request.getRequestDispatcher("LocalizacaoForm.jsp").forward(request, response);
	}


	private void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List <Ronda> listaRonda = em.createQuery("from Ronda").getResultList();
		em.close();
		request.setAttribute("listaRonda", listaRonda);
		request.getRequestDispatcher("LocalizacaoForm.jsp").forward(request, response);
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List <Localizacao> listaLocalizacao = em.createQuery("from Localizacao").getResultList();
		em.close();
		request.setAttribute("listaLocalizacao", listaLocalizacao);
		request.getRequestDispatcher("LocalizacaoList.jsp").forward(request, response);
	}

	
	private void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em  = JpaUtil.getEntityManager();
		try {
			Localizacao lz = inicilizarObjeto(request, em);
			em.getTransaction().begin();
			em.merge(lz);
			em.getTransaction().commit();
			List <Localizacao> listaLocalizacao = em.createQuery("from Localizacao").getResultList();
			request.setAttribute("listaLocalizacao", listaLocalizacao);
			request.getRequestDispatcher("LocalizacaoList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	
	private Localizacao inicilizarObjeto(HttpServletRequest request, EntityManager em) throws Exception {
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Ronda ronda = em.find(Ronda.class, Integer.parseInt(request.getParameter("ronda")));
		
		Localizacao lz = new Localizacao (
				request.getParameter("id").equals("") ? null : Integer.parseInt(request.getParameter("id")), 
				data.parse(request.getParameter("dataHora").replaceAll("T", " ")),
				Float.parseFloat(request.getParameter("latitude")),
				Float.parseFloat(request.getParameter("longitude")),
				ronda);
		return lz;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
