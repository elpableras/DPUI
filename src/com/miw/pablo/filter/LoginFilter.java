package com.miw.pablo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import com.miw.pablo.model.Usuario;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Se ha disparado el filtro dirigido a "
				+ ((HttpServletRequest) req).getRequestURI());
		Usuario usuario = (Usuario) ((HttpServletRequest) req).getSession()
				.getAttribute("usuario");
		if (usuario == null) {
			// El usuario no ha sido autentificado, le redirigimos a la página
			// de login,
			// A NO SER QUE ESTÉ INTENTANDO LOGUEARSE, EN CUYO CASO LE DEJAMOS
			// PASAR.
			System.out.println("Filtro: El usuario es nulo");
			System.out.println("Requested uri = "
					+ ((HttpServletRequest) req).getRequestURI());
			if (!((HttpServletRequest) req).getRequestURI().contains("Login")) {
				System.out
						.println("Acceso denegado, redirigiendl a página de login");
				RequestDispatcher dispatcher = req
						.getRequestDispatcher("login.jsp");
				dispatcher.forward(req, resp);
				return;
			}

		}
		chain.doFilter(req, resp);
		System.out.println("Se termina el filtro");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
