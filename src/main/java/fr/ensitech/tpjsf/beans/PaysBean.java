package fr.ensitech.tpjsf.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "paysbean")
@SessionScoped
public class PaysBean {
	@ManagedProperty(name = "pays", value = "Suisse")
	private String pays;
	@ManagedProperty(name = "ville", value = "Lausanne")
	private String ville;

	public List<String> getContries() {
		return Arrays.asList("France", "Suisse", "Belgique");
	}

	public List<String> getTowns() {
		switch (pays) {
		case "France":
			return Arrays.asList("France", "Suisse", "Belgique");

		case "Belgique":
			return Arrays.asList("France", "Suisse", "Belgique");

		case "Suisse":
			return Arrays.asList("France", "Suisse", "Belgique");

		default:
			return new ArrayList<String>();
		}
	}

	public PaysBean(String pays, String ville) {
		this.pays = pays;
		this.ville = ville;
	}

	public PaysBean() {
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
