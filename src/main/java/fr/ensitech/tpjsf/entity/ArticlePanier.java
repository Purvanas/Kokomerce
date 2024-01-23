package fr.ensitech.tpjsf.entity;

public class ArticlePanier {
	private int id;
	private Article article;
	private int quantite;
	private User utilisateur;

	public ArticlePanier() {

	}

	public ArticlePanier(int id, Article article, int quantite, User utilisateur) {
		super();
		this.id = id;
		this.article = article;
		this.quantite = quantite;
		this.utilisateur = utilisateur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public User getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}

}
