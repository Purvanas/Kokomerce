package fr.ensitech.tpjsf.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.ensitech.tpjsf.model.connection.EcommerceDsSingleton;
import fr.ensitech.tpjsf.entity.*;

public final class UserDao implements IUserDao {

    public UserDao() {
    }

    @Override
    public final Integer addUser(User user) throws Exception {
        if (user == null) {
            throw new NullPointerException("Le user à créer ne doit pas être NULL !");
        }
        if (user.getNom() == null || user.getNom().trim().isEmpty() || user.getNom() == null
                || user.getNom().trim().isEmpty()
        ) {
            throw new IllegalArgumentException("Tous les paramètres sont obligatoires !");
        }
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = EcommerceDsSingleton.getConnection();
            String requete = "INSERT INTO user(nom, prenom, email, password, date_naissance)" + " VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getDateNaissance());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                return rs.getInt(1);
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
    public User getUserById(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("L'id doit être > 0 !");
        }
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = EcommerceDsSingleton.getConnection();
            String requete = "SELECT * FROM user WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.execute();
            rs = ps.getResultSet();
            if (rs != null && rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setDateNaissance(rs.getString("date_naissance"));
                return user;
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
    public void updateUser(User user) throws Exception {
        if (user == null) {
            throw new NullPointerException("Le user à créer ne doit pas être NULL !");
        }
        if (user.getNom() == null || user.getNom().trim().isEmpty() || user.getNom() == null
                || user.getNom().trim().isEmpty()
        ) {
            throw new IllegalArgumentException("Tous les paramètres sont obligatoires !");
        }
        Connection connection = null;
        try {
            connection = EcommerceDsSingleton.getConnection();
            String requete = "UPDATE user SET nom = ?, prenom = ?, email = ?, password = ?,"
                    + " date_naissance = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getDateNaissance());
            ps.setInt(6, user.getId());

            ps.executeUpdate();
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public void removeUser(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("L'id doit être > 0 !");
        }
        Connection connection = null;
        try {
            connection = EcommerceDsSingleton.getConnection();
            String requete = "DELETE FROM user WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    @Override
    public List<User> getUsers() throws Exception {
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = EcommerceDsSingleton.getConnection();
            String requete = "SELECT * FROM user";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.execute();
            rs = ps.getResultSet();
            if (rs != null) {
                List<User> users = new ArrayList<User>();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setNom(rs.getString("nom"));
                    user.setPrenom(rs.getString("prenom"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(rs.getString("password"));
                    user.setDateNaissance(rs.getString("date_naissance"));
                    users.add(user);
                }
                return users;
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
    public User getUserByEmail(String email) throws Exception {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("L'email doit être renseigné !");
        }
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = EcommerceDsSingleton.getConnection();
            String requete = "SELECT * FROM user WHERE email = ?";
            PreparedStatement ps = connection.prepareStatement(requete);
            ps.setString(1, email);
            ps.execute();
            rs = ps.getResultSet();
            if (rs != null && rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setDateNaissance(rs.getString("date_naissance"));
                return user;
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
}
