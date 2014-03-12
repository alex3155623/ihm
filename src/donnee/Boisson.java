package donnee;

import java.util.ArrayList;

public class Boisson extends Produit{
	public Boisson(String n, double p) {
		super(n, p);
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "<html>"+getNom() + ".........." + getPrix()+"<br />"+getIngredients()+"<br /></html>";
	}
	
}
