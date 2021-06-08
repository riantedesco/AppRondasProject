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

import Projetos.proj1.domain.Ocorrencia;
import Projetos.proj1.domain.Pessoa;
import Projetos.proj1.domain.Ronda;
import Projetos.proj1.jpa.JpaUtil;
import Projetos.proj1.uteis.Upload;
import net.iamvegan.multipartrequest.HttpServletMultipartRequest;

@WebServlet("/Privada/Ocorrencia/OcorrenciaServlet")
public class OcorrenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OcorrenciaServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request = new HttpServletMultipartRequest(
    			request,
    			HttpServletMultipartRequest.MAX_CONTENT_LENGTH,
    			HttpServletMultipartRequest.SAVE_TO_TMPDIR,
    			HttpServletMultipartRequest.IGNORE_ON_MAX_LENGTH,
    			HttpServletMultipartRequest.DEFAULT_ENCODING);

    	
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
		} else if (request.getParameter("alterarFoto") != null) {
			alterarFoto(request, response);
		} else if (request.getParameter("gravarFoto") != null) {
			gravarFoto(request, response);
		} else { // default = consultar
			listar(request, response);
		}
	}
    
    private void gravarFoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		Ocorrencia o = em.find(Ocorrencia.class, Integer.parseInt(request.getParameter("id")));
		//colocar a foto na pasta uploads
		if (request.getParameter("foto") != null) {
			String nomeArquivo = "Foto"+o.getId()+".jpg";
			// pegar o caminho de contexto de execução da aplicação para a pasta uploads
			String caminho = getServletConfig().getServletContext().getRealPath("/") + "Privada/uploads";
			// copiar arquivo de upload para a pasta
			Upload.copiarArquivo((HttpServletMultipartRequest) request, "foto", caminho, nomeArquivo);
			}
		
		em.merge(o);
		em.getTransaction().commit();
		em.close();
		listar(request, response);
	}

    private void alterarFoto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("alterarFoto"));
		EntityManager em = JpaUtil.getEntityManager();
		Ocorrencia o = em.find(Ocorrencia.class, id); 
		em.close();
		request.setAttribute("o", o); //repassamos o obj para o form inicializar os dados
		request.getRequestDispatcher("OcorrenciaFoto.jsp").forward(request, response);
	}
	
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("excluir"));
		EntityManager em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Ocorrencia.class, id));
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
		Ocorrencia o = em.find(Ocorrencia.class, id); 
		List <Ronda> listaRonda = em.createQuery("from Ronda").getResultList();
		em.close();
		request.setAttribute("o", o); 
		request.setAttribute("listaRonda", listaRonda);
		request.getRequestDispatcher("OcorrenciaForm.jsp").forward(request, response);
	}


	private void incluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List <Ronda> listaRonda = em.createQuery("from Ronda").getResultList();
		em.close();
		request.setAttribute("listaRonda", listaRonda);
		request.getRequestDispatcher("OcorrenciaForm.jsp").forward(request, response);
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em = JpaUtil.getEntityManager();
		List <Ocorrencia> listaOcorrencia = em.createQuery("from Ocorrencia").getResultList();
		em.close();
		request.setAttribute("listaOcorrencia", listaOcorrencia);
		request.getRequestDispatcher("OcorrenciaList.jsp").forward(request, response);
	}

	
	private void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManager em  = JpaUtil.getEntityManager();
		try {
			Ocorrencia o = inicilizarObjeto(request, em);
			em.getTransaction().begin();
			em.merge(o);
			em.getTransaction().commit();
			List <Ocorrencia> listaOcorrencia = em.createQuery("from Ocorrencia").getResultList();
			request.setAttribute("listaOcorrencia", listaOcorrencia);
			request.getRequestDispatcher("OcorrenciaList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
	}

	
	private Ocorrencia inicilizarObjeto(HttpServletRequest request, EntityManager em) throws Exception {
		SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		Ronda ronda = em.find(Ronda.class, Integer.parseInt(request.getParameter("ronda")));
		
		Ocorrencia o = new Ocorrencia (
				request.getParameter("id").equals("") ? null : Integer.parseInt(request.getParameter("id")), 
				data.parse(request.getParameter("dataHora").replaceAll("T", " ")),
				request.getParameter("titulo"),
				request.getParameter("descricao"),
				Float.parseFloat(request.getParameter("latitude")),
				Float.parseFloat(request.getParameter("longitude")),
				ronda);
		return o;
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}
}
