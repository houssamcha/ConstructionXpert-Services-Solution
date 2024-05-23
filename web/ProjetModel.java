package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Projet;

public class ProjetModel {
	private List<Projet> projet=new ArrayList<Projet>();

	public List<Projet> getProjet() {
		return projet;
	}

	public void setProjet(List<Projet> projet) {
		this.projet = projet;
	}
}
