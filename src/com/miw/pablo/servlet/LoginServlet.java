package com.miw.pablo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miw.pablo.model.Usuario;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Entrando en login servlet");
		String login = req.getParameter("login");
		String password = req.getParameter("password");
		if ((!(login == null)) && (!(password == null))) {

			if (login.equals("admin") && password.equals("admin")) {
				System.out.println("Logueado el usuario Admin");
				Usuario usuario = new Usuario();
				usuario.setId("Admin");
				usuario.setNombre("Administrador del sistema");
				req.getSession().setAttribute("usuario", usuario);
				resp.sendRedirect("mejoras.jsp");
				return;
			}
		}
		resp.sendRedirect("login.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}