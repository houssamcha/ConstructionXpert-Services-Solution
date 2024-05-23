package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import metier.entities.Projet;

public class ProjetDaoImpl implements IprojetDao {

	@Override
	public Projet creer(Projet p) {
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps=connection.prepareStatement("INSERT INTO PROJETS(nom,description,date_debut,date_fin,budget) VALUES (?,?,?,?,?)");
			ps.setString(1, p.getNomProjet());
			ps.setString(2, p.getDescription());
			ps.setDate(3, p.getDateDebut());
			ps.setDate(4, p.getDateFin());
			ps.setDouble(5, p.getBudget());
			
			ps.executeUpdate();
			PreparedStatement ps2=connection.prepareStatement
					("SELECT MAX(ID) AS MAX_ID FROM PROJETS");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Projet> Afficher() {
		List<Projet> projects = new ArrayList<Projet>();
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PROJETS");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Projet p = new Projet();
//                p.setId(rs.getInt("id"));
                p.setNomProjet(rs.getString("nom"));
                p.setDateDebut(rs.getDate("date_debut"));
                p.setDateFin(rs.getDate("date_fin"));
                p.setDescription(rs.getString("description"));
                p.setBudget(rs.getDouble("budget"));
                projects.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
	}

	@Override
	public Projet Mise_a_jour(Projet p) {
		return null;
	}

	@Override
	public void Supprimer(Long id) {		
	}

}
