package donnee;

import java.util.ArrayList;

public class Boisson extends Produit{
	public Boisson(String n, double p , Categorie c) {
		super(n, p,c );
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "<html><strong>"+getNom() + "</strong>.........." + getPrix()+"<br />"+getIngredients()+"<br /></html>";
	}
	
}
