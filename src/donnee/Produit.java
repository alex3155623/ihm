package donnee;

import java.util.Comparator;

public class Produit {

	private Categorie categorie;
	private String nom;
	private double prix;
	private String ingredients;
	private boolean envoye;
	
	public Produit(String n, double p, Categorie c){
		setNom(n); setPrix(p); ingredients = ""; categorie = c;envoye = false;
	}

	public boolean isEnvoye() {
		return envoye;
	}

	public void setEnvoye(boolean envoye) {
		this.envoye = envoye;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String toString() {
	
		return getNom()+"..."+getPrix();
	}

	public String afficher() {
		// TODO Auto-generated method stub
		return getNom()+"..."+getPrix();
	}

	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
