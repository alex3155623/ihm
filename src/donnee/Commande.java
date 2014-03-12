package donnee;

import java.util.ArrayList;

import donnee.Produit;


public class Commande {
	
	private ArrayList<Produit> listeProduits = new ArrayList<Produit>();
	
	public Commande(){
		
	}
	
	public void ajoutProduitCommande(Produit p){
		listeProduits.add(p);
	}

	public ArrayList<Produit> getListeProduits() {
		return listeProduits;
	}

	public void setListeProduits(ArrayList<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}

	
}
