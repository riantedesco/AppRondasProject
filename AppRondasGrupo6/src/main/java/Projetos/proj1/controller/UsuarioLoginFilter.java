package Projetos.proj1.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Projetos.proj1.domain.Usuario;


@WebFilter(urlPatterns={"/Privada/*"})
public class UsuarioLoginFilter implements Filter {

	
    public UsuarioLoginFilter() {
    }

    
	public void destroy() {
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request; 
		HttpServletResponse httpResponse = (HttpServletResponse) response; 
		HttpSession sessao = httpRequest.getSession(); 
		String contextPath = httpRequest.getContextPath(); 
		Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuarioLogado"); 
		if (usuarioLogado == null){ 
		    httpResponse.sendRedirect(contextPath + "/UsuarioLogin.jsp"); 
		} else {
		   chain.doFilter(request, response);
		}
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
