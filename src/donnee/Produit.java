package donnee;

public class Produit {

	private String nom;
	private double prix;
	private String ingredients;
	
	public Produit(String n, double p){
		setNom(n); setPrix(p); ingredients = ""; 
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
}
