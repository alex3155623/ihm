package donnee;

public class Nourriture extends Produit {
	public Nourriture(String n, double p, Categorie c) {
		super(n, p,c );
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "<html><strong>"+getNom() + "</strong>.........." + getPrix()+"<br />"+getIngredients()+"<br /></html>";
	}
}
