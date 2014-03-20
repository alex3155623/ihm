package donnee;

import java.io.Serializable;

public class Produit implements Cloneable{

	private Categorie categorie;
	private String nom;
	private double prix;
	private String ingredients;
	private boolean envoye;
	private String informations;
	private String image ;
	
	public Produit(String n, double p, Categorie c){
		setNom(n); setPrix(p); ingredients = ""; categorie = c;envoye = false; informations = "";setImage("");
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
		return "<html>"+getNom()+"..."+getPrix()+"<br />"+getInformations()+"</html>";
	}

	
	public String getInformations() {
		return informations;
	}

	public void setInformations(String informations) {
		this.informations = informations;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public Produit clone() {
	   Produit produit = null;
	    try {
	    	// On récupère l'instance à renvoyer par l'appel de la 
	      	// méthode super.clone()
	    	produit = (Produit) super.clone();
	    } catch(CloneNotSupportedException cnse) {
	      	// Ne devrait jamais arriver car nous implémentons 
	      	// l'interface Cloneable
	      	cnse.printStackTrace(System.err);
	    }
	    
	    // On clone l'attribut de type Patronyme qui n'est pas immuable.
	    produit.categorie = (Categorie) categorie;
	    
	    // on renvoie le clone
	    return produit;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
