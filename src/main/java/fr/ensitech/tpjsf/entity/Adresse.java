package fr.ensitech.tpjsf.entity;

public class Adresse {
	int id;
	int numéro;
	String ville;
	String codePostale;
	String adresse;
	int userId;
	User utilisateur;

	public Adresse(int numéro, String ville, String codePostale, User utilisateur) {
		super();
		this.numéro = numéro;
		this.ville = ville;
		this.codePostale = codePostale;
		this.utilisateur = utilisateur;
	}

	public Adresse() {
	}
	
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNuméro() {
		return numéro;
	}

	public void setNuméro(int numéro) {
		this.numéro = numéro;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}


	}

