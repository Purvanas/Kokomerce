package fr.ensitech.tpjsf.model.dao;

import java.sql.Connection;

import fr.ensitech.tpjsf.entity.Adresse;
import fr.ensitech.tpjsf.model.connection.EcommerceDsSingleton;
import fr.ensitech.tpjsf.utils.Dates;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class AdresseDao implements IAdresseDao{
	
	@Override
	public String getAdressesByUserId(int userId) throws Exception {
		if (userId <= 0) {
			throw new IllegalArgumentException("L'id doit �tre > 0 !");
		}
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = EcommerceDsSingleton.getInstance().getConnection();
			String requete = "SELECT * FROM adresse WHERE id_user = ?";
			PreparedStatement ps = connection.prepareStatement(requete);
			ps.setInt(1, userId);
			ps.execute();
			rs = ps.getResultSet();
			if (rs != null && rs.next()) {
				Adresse adresse = new Adresse();
				adresse.setId(rs.getInt("id"));
				adresse.setAdresse(rs.getString("adresse"));
				adresse.setVille(rs.getString("ville"));
				adresse.setCodePostale(rs.getString("codePostal"));
				adresse.setUserId(rs.getInt("id_user"));

				return adresse.toString();
			}
		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return null;
	}

	@Override
	public Integer addAdresse(Adresse adresse) throws Exception {
		if (adresse == null) {
			throw new NullPointerException("L'adresse � cr�er ne doit pas �tre NULL !");
		}
		if (adresse.getAdresse() == null || adresse.getAdresse().trim().isEmpty() || 
				adresse.getVille() == null || adresse.getVille().trim().isEmpty()
				|| adresse.getUserId() <= 0 
		// ... tous les param�tres sauf l'id
		) {
			throw new IllegalArgumentException("Tous les param�tres sont obligatoires !");
		}
		Connection connection = null;
		ResultSet rs = null;
		try {
			connection = EcommerceDsSingleton.getInstance().getConnection();
			String requete = "INSERT INTO adresse(adresse, ville, codePostal, id_user)" + " VALUES(?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, adresse.getAdresse());
			ps.setString(2, adresse.getVille());
			ps.setString(3, adresse.getCodePostale());
			ps.setInt(4, adresse.getUserId());
			

			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				return rs.getInt(1); // l'id de la ligne ajout�e dans la table user de la BDD
			}
		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		}
		return null;
	}

	@Override
	public void updateAdresse(Adresse adresse) throws Exception {
		if (adresse == null) {
			throw new NullPointerException("L'adresse � cr�er ne doit pas �tre NULL !");
		}
		if (adresse.getAdresse() == null || adresse.getAdresse().trim().isEmpty() || 
				adresse.getVille() == null || adresse.getVille().trim().isEmpty()
				|| adresse.getUserId() <= 0 
		// ... tous les param�tres sauf l'id
		) {
			throw new IllegalArgumentException("Tous les param�tres sont obligatoires !");
		}
		Connection connection = null;
		try {
			connection = EcommerceDsSingleton.getInstance().getConnection();
			String requete = "UPDATE adresse SET adresse = ?, ville = ?, codePostal = ?, WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(requete);
			ps.setString(1, adresse.getAdresse());
			ps.setString(2, adresse.getVille());
			ps.setString(3, adresse.getCodePostale());
			ps.setInt(4, adresse.getId());

			ps.executeUpdate();
		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
		
	}

	@Override
	public void removeAdresse(int id) throws Exception {
		if (id <= 0) {
			throw new IllegalArgumentException("L'id doit être > 0 !");
		}
		Connection connection = null;
		try {
			connection = EcommerceDsSingleton.getInstance().getConnection();
			String requete = "DELETE FROM adresse WHERE id = ?";
			PreparedStatement ps = connection.prepareStatement(requete);
			ps.setInt(1, id);
			ps.executeUpdate();
		} finally {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		}
	}

}
