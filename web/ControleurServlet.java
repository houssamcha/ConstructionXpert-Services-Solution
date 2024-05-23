package web;

import java.io.IOException;
import java.util.List;

import dao.IprojetDao;
import dao.ProjetDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metier.entities.Projet;

@WebServlet(name = "Servlet", value = "/Servlet")

public class ControleurServlet extends HttpServlet {
	private ProjetDaoImpl metier;
	
	@Override
	public void init() throws ServletException {
		metier=new ProjetDaoImpl();
	}
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/home")) {
			List<Projet> projets = metier.Afficher();
			request.setAttribute("model", projets);
			request.getRequestDispatcher("projet.jsp").forward(request, response);	
		}
	}
}