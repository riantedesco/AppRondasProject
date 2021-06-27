package Projetos.proj1.relatorios;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RelPessoaServlet
 */
@WebServlet("/Privada/Relatorios/RelPessoaServlet")
public class RelPessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelPessoaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HashMap<String, Object> parameters = new HashMap();
			/*Exemplo de filtro
			 * String filtro = "where pessoa.loginapp like '1234%'";
			 * parameters.put("filtro", filtro);
			 * */
			RelatorioUtil.rodarRelatorioPDF("WEB-INF/Relatorios/Pessoa/Pessoa.jasper", parameters, "RelPessoa.pdf",
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().append("Não foi possível executar o relatório. Erro:" + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
