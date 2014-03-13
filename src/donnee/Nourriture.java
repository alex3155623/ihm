package donnee;

public class Nourriture extends Produit {
	public Nourriture(String n, double p) {
		super(n, p);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "<html><strong>"+getNom() + "</strong>.........." + getPrix()+"<br />"+getIngredients()+"<br /></html>";
	}
}
