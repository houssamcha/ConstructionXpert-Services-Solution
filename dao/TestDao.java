package dao;

import java.sql.Date;
import java.util.List;

import metier.entities.Projet;

public class TestDao {

	public static void main(String[] args) {
//		Date date =new Date(2011,10,20);
		ProjetDaoImpl dao=new ProjetDaoImpl();
//		Projet p1=dao.creer(new Projet("Building","Premier projet",date,date,12.2));
//		
//		System.out.println(p1.toString());
		
		
		List<Projet> projets = dao.Afficher();
		for(Projet p:projets) {
			System.out.println(p.toString());
		}
	}
}