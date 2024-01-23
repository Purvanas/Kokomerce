package fr.ensitech.tpjsf.beans;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import fr.ensitech.tpjsf.entity.*;
import fr.ensitech.tpjsf.model.dao.*;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean {
	@ManagedProperty(value = "Dupond")
	private String nom;
	@ManagedProperty(value = "MICHEL")
	private String prenom;
	private String dateNaissance;
	@ManagedProperty(value = "MICHEL.Dupond@gmail.com")
	private String email;
	private String password;
	private static final List<User> users =  new ArrayList<User>();
	


	public UserBean() {
	}

	public UserBean(String nom, String prenom, String dateNaissance, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "USER : [nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance 
				+ ", email=" + email + "]";
	}

	public String createUser() {
		UserBean u = new UserBean(nom, prenom, dateNaissance, email);
		System.out.println(u.toString());
		return "user";
	}

	public List<User> getUsers() {
		UserDao udo = new UserDao();
		try {
			System.out.println("users !!");
			System.out.println(udo.getUsers().toString());
			return udo.getUsers();
		}catch(Exception e) {
			return new ArrayList<User>();
		}
	}
	

	public void addAction() {
		User user = new User(this.nom, this.prenom, this.email, this.password, this.dateNaissance);
		users.add(user);
	}

	public void deleteAction(User user) {
		users.remove(user);
	}
	
}
