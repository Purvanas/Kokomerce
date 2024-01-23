package fr.ensitech.tpjsf.entity;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
	private int id;
	private String nom;
	private int remise;
	private boolean isRemiseCumulable;
	private String photo;
	private List<Article> articles = new ArrayList<Article>();
}
