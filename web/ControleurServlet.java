package web;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Date;
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

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = request.getServletPath();

		if(path.equals("/ajouter")) {

			String nom = request.getParameter("nomProjet");
			String description = request.getParameter("description");
			Date dateDebut = Date.valueOf(request.getParameter("DateDebut"));
			Date dateFin = Date.valueOf(request.getParameter("DateFin"));
			double budget = Double.parseDouble(request.getParameter("budget"));

			Projet newProject = new Projet(nom, description, dateDebut, dateFin, budget);
			metier.creer(newProject);
			response.sendRedirect(request.getContextPath() + "/home");

			//request.getRequestDispatcher("Formulaire.jsp").forward(request, response);
		}

	}

	private void Delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		long id = Integer.parseInt(req.getParameter("id"));
		metier.Supprimer(id);
		resp.sendRedirect(req.getContextPath() + "/home");
	}

}
