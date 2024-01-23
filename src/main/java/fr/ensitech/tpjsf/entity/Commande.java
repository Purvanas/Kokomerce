package fr.ensitech.tpjsf.entity;

import java.util.ArrayList;
import java.util.List;

public class Commande {
	private int id;
	private String numero;
	private String dateCreation;
	private String dateLivraison;
	private float totaleRemise;
	private float fraisExpedition;
	private float totalGeneral;
	private Adresse adresseFacturation;
	private Adresse adresseLivraison;
	private CartePaiement cartePaiementDefaut;
	private User utilisateur;
	private List<LigneDeCommande> lignesCommande = new ArrayList<LigneDeCommande>();
	
	
	public Commande() {
	}


	public Commande(int id, String numero, String dateCreation, String dateLivraison, float totaleRemise,
			float fraisExpedition, float totalGeneral, Adresse adresseFacturation, Adresse adresseLivraison,
			CartePaiement cartePaiementDefaut, User utilisateur) {
		super();
		this.id = id;
		this.numero = numero;
		this.dateCreation = dateCreation;
		this.dateLivraison = dateLivraison;
		this.totaleRemise = totaleRemise;
		this.fraisExpedition = fraisExpedition;
		this.totalGeneral = totalGeneral;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
		this.cartePaiementDefaut = cartePaiementDefaut;
		this.utilisateur = utilisateur;
		//xcvcxv
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}


	public String getDateLivraison() {
		return dateLivraison;
	}


	public void setDateLivraison(String dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	public float getTotaleRemise() {
		return totaleRemise;
	}


	public void setTotaleRemise(float totaleRemise) {
		this.totaleRemise = totaleRemise;
	}


	public float getFraisExpedition() {
		return fraisExpedition;
	}


	public void setFraisExpedition(float fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}


	public float getTotalGeneral() {
		return totalGeneral;
	}


	public void setTotalGeneral(float totalGeneral) {
		this.totalGeneral = totalGeneral;
	}


	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}


	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}


	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}


	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}


	public CartePaiement getCartePaiementDefaut() {
		return cartePaiementDefaut;
	}


	public void setCartePaiementDefaut(CartePaiement cartePaiementDefaut) {
		this.cartePaiementDefaut = cartePaiementDefaut;
	}


	public User getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}


	public List<LigneDeCommande> getLignesCommande() {
		return lignesCommande;
	}
	
	
	public void addLigneCommande(LigneDeCommande ligne) {
		this.lignesCommande.add(ligne);
	}
	
	public void removeLigneCommande(LigneDeCommande ligne) {
		this.lignesCommande.remove(ligne);
	}
}
