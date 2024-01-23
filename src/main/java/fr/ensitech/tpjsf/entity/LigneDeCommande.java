package fr.ensitech.tpjsf.entity;

public class LigneDeCommande {
	private int id;
	private int quantite;
	private float prixUnitaire;
	private int remiseArticle;
	private Commande commande;
	private Article article;
	
	
	public LigneDeCommande(int id, int quantite, float prixUnitaire, int remiseArticle, Commande commande,
			Article article) {
		super();
		this.id = id;
		this.quantite = quantite;
		this.prixUnitaire = prixUnitaire;
		this.remiseArticle = remiseArticle;
		this.commande = commande;
		this.article = article;
	}


	public LigneDeCommande() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public float getPrixUnitaire() {
		return prixUnitaire;
	}


	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}


	public int getRemiseArticle() {
		return remiseArticle;
	}


	public void setRemiseArticle(int remiseArticle) {
		this.remiseArticle = remiseArticle;
	}


	public Commande getCommande() {
		return commande;
	}


	public void setCommande(Commande commande) {
		this.commande = commande;
	}


	public Article getArticle() {
		return article;
	}


	public void setArticle(Article article) {
		this.article = article;
	}
	
	
}
