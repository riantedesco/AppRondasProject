package Projetos.proj1.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Projetos.proj1.domain.Locomocao;
import Projetos.proj1.domain.Ronda;
import Projetos.proj1.jpa.JpaUtil;

@WebServlet("/Privada/Ronda/RondaServlet")
public class RondaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public RondaServlet() {
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
		em.remove(em.find(Ronda.class, id));
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
		Ronda r = em.find(Ronda.class, id); 
		List <Locomocao> listaLocomocao = em.createQuery("from Locomocao").getResultList();
		em.close();
		request.setAttribute("r", r); 
		request.setAttribute("listaLocomocao", listaLocomocao);
		request.getRequestDispatcher("RondaForm.jsp").forward(request, response);
	}


	private void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List <Locomocao> listaLocomocao = em.createQuery("from Locomocao").getResultList();
		em.close();
		request.setAttribute("listaLocomocao", listaLocomocao);
		request.getRequestDispatcher("RondaForm.jsp").forward(request, response);
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List <Ronda> listaRonda = em.createQuery("from Ronda").getResultList();
		em.close();
		request.setAttribute("listaRonda", listaRonda);
		request.getRequestDispatcher("RondaList.jsp").forward(request, response);
	}

	
	private void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em  = JpaUtil.getEntityManager();
		try {
			Ronda r = inicilizarObjeto(request, em);
			em.getTransaction().begin();
			em.merge(r);
			em.getTransaction().commit();
			List <Ronda> listaRonda = em.createQuery("from Ronda").getResultList();
			request.setAttribute("listaRonda", listaRonda);
			request.getRequestDispatcher("RondaList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	
	private Ronda inicilizarObjeto(HttpServletRequest request, EntityManager em) throws Exception {
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Locomocao locomocao = em.find(Locomocao.class, Integer.parseInt(request.getParameter("locomocao")));
		
		Ronda r = new Ronda (
				request.getParameter("id").equals("") ? null : Integer.parseInt(request.getParameter("id")), 
				data.parse(request.getParameter("dataHoraInicio").replaceAll("T", " ")),
				data.parse(request.getParameter("dataHoraFim").replaceAll("T", " ")),
				Float.parseFloat(request.getParameter("latUltima")),
				Float.parseFloat(request.getParameter("lonUltima")),
				data.parse(request.getParameter("dataHoraUltima").replaceAll("T", " ")),
				locomocao,
				null);
		return r;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
