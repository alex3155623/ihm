package donnee;

import java.util.ArrayList;

public class ListeNourritures {
	private ArrayList<Nourriture> listeEntree= new ArrayList<Nourriture>();
	private ArrayList<Nourriture> listePlat= new ArrayList<Nourriture>();
	private ArrayList<Nourriture> listeDessert = new ArrayList<Nourriture>();

	public ListeNourritures(){
		Nourriture meridional = new Nourriture("La meridionale", 13.0, Categorie.Entree);
		meridional.setIngredients("tomates et oignons confits, caviar d'aubergines, poivrons grillés, pates au pistou");
		listeEntree.add(meridional);
		Nourriture carpacio = new Nourriture("Carpaccio de Boeuf", 13.0, Categorie.Entree);
		carpacio.setIngredients("et son accompagnement");
		listeEntree.add(carpacio);
		Nourriture traditionnelle = new Nourriture("La traditionnelle", 15.0, Categorie.Entree);
		traditionnelle.setIngredients("Foies de volaille, tomates, oignons rouges, patates douces, salade");
		listeEntree.add(traditionnelle);
		Nourriture bistrot = new Nourriture("La Bistrot", 16.0, Categorie.Entree);
		bistrot.setIngredients("Nougat de chevre brasse, pasteque, melon, jambon cru, salade");
		listeEntree.add(bistrot);
		Nourriture folle = new Nourriture("La Folle", 16.0, Categorie.Entree);
		folle.setIngredients("saumon fumé, gambas et saint jacques deglacees au vinaigre balsamique, toasts, salade");
		listeEntree.add(folle);
		
		Nourriture tartare = new Nourriture("Tartare de Boeuf", 13.00, Categorie.Plat);
		listePlat.add(tartare);
		Nourriture cheesburger = new Nourriture("Veritable Cheesburger", 15.00, Categorie.Plat);
		cheesburger.setIngredients("ketchup, moutarde, oignon, cornichon, cheddar");
		listePlat.add(cheesburger);
		Nourriture boucher = new Nourriture("Entrecote 300g", 21.00, Categorie.Plat);
		boucher.setIngredients("sauce roquefort ");
		listePlat.add(boucher);
		Nourriture espadon = new Nourriture("Pavé d'espadon", 16.00, Categorie.Plat);
		espadon.setIngredients("au sésame");
		listePlat.add(espadon);
		Nourriture brochette = new Nourriture("Les brochettes", 17.00, Categorie.Plat);
		brochette.setIngredients("Canard et volaille marinés");
		listePlat.add(brochette);
		
		Nourriture tatin = new Nourriture("Tarte Tatin", 6.0, Categorie.Dessert);
		listeDessert.add(tatin);
		Nourriture creme = new Nourriture("Creme caramel maison", 5.50, Categorie.Dessert);
		listeDessert.add(creme);
		Nourriture micuit = new Nourriture("Mi-cuit au chocolat", 6.0, Categorie.Dessert);
		listeDessert.add(micuit);
		Nourriture profiterol = new Nourriture("Profiterolles maison", 6.0, Categorie.Dessert);
		listeDessert.add(profiterol);
		Nourriture cafe = new Nourriture("Café Gourmand", 7.0, Categorie.Dessert);
		listeDessert.add(cafe);
		
		
	}

	public ArrayList<Nourriture> getListeEntree() {
		return listeEntree;
	}

	public void setListeEntree(ArrayList<Nourriture> listeEntree) {
		this.listeEntree = listeEntree;
	}

	public ArrayList<Nourriture> getListePlat() {
		return listePlat;
	}

	public void setListePlat(ArrayList<Nourriture> listePlat) {
		this.listePlat = listePlat;
	}

	public ArrayList<Nourriture> getListeDessert() {
		return listeDessert;
	}

	public void setListeDessert(ArrayList<Nourriture> listeDessert) {
		this.listeDessert = listeDessert;
	}


}
