package metier.entities;

import java.sql.Date;

public class Projet {
	
	private long id;
	private String nomProjet;
	private String description;
	private Date DateDebut;
	private Date DateFin;
	private double Budget;
	
	public Projet() {
		super();
	}

	public Projet(String nomProjet, String description, Date dateDebut, Date dateFin, double budget) {
		super();
		this.nomProjet = nomProjet;
		this.description = description;
		DateDebut = dateDebut;
		DateFin = dateFin;
		Budget = budget;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateDebut() {
		return DateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}

	public double getBudget() {
		return Budget;
	}

	public void setBudget(double budget) {
		Budget = budget;
	}
	@Override
	public String toString() {
		return "Projet [id=" + id + ", nomProjet=" + nomProjet + ", description=" + description + ", DateDebut="
				+ DateDebut + ", DateFin=" + DateFin + ", Budget=" + Budget + "]";
	}
	 
}
