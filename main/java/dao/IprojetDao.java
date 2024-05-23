package dao;

import java.util.List;

import metier.entities.Projet;

public interface IprojetDao {
	public Projet creer(Projet p);
	public List<Projet> Afficher();
	public Projet Mise_a_jour(Projet p);
	public void Supprimer(Long id);
}