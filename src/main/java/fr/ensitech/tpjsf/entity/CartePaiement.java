package fr.ensitech.tpjsf.entity;

public class CartePaiement {
	int id;
	String nomProprietaire;
	String prenomProprietaire;
	byte[] numero;
	String dateFinValidite;
	byte[] cryptograme;
	User utilisateur;
	
	
	public CartePaiement(String nomProprietaire, String prenomProprietaire, byte[] numero, String dateFinValidite,
			byte[] cryptograme, User utilisateur) {
		this.nomProprietaire = nomProprietaire;
		this.prenomProprietaire = prenomProprietaire;
		this.numero = numero;
		this.dateFinValidite = dateFinValidite;
		this.cryptograme = cryptograme;
		this.utilisateur = utilisateur;
	}
}
