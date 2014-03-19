package donnee;

public class Nourriture extends Produit {
	public Nourriture(String n, double p, Categorie c) {
		super(n, p,c );
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		String s =  "<html><strong>"+getNom() + "</strong>.........." + getPrix();
				if(!getIngredients().equals(""))
					s+="<br />"+getIngredients()+"<br /></html>";
		return s;
	}
}
