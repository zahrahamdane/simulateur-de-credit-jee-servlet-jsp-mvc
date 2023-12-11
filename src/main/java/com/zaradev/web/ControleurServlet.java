package com.zaradev.web;

import java.io.IOException;

import com.zaradev.metier.CreditMetierImpl;
import com.zaradev.metier.ICreditMetier;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculerMensualite.fr")
public class ControleurServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ICreditMetier metier;

	@Override
	public void init() throws ServletException {
		
		metier = new CreditMetierImpl();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("creditModel", new CreditModel());
		
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * Lire les donnees de la requête
		 */
		
		double montant = Double.parseDouble(request.getParameter("montant")) ;
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		
		/*
		 * Valider les données coté serveur
		 */
		
		/*
		 * Stocker les données saisies dans le modèle
		 */
		
		CreditModel model = new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		
		/*
		 * Faire appel à la couche métier pour effectuer les traitements
		 */
		double resultat = metier.calculerMensualiteCredit(montant, taux, duree);
		
		/*
		 * Stocker les resultats dans le modèle
		 */
		model.setMensualite(resultat);
		
		/*
		 * Stocker le modele dans l'objet request
		 */
		request.setAttribute("creditModel", model);
	
		/*
		 * Faire un forward vers la vue JSP
		 */
		request.getRequestDispatcher("VueCredit.jsp").forward(request, response);
	}

}
