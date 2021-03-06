package donnee;

import java.util.ArrayList;

public class ListeBoissons {

	private ArrayList<Boisson> listeBieres= new ArrayList<Boisson>();
	private ArrayList<Boisson> listeCoktails= new ArrayList<Boisson>();
	private ArrayList<Boisson> listeSodas = new ArrayList<Boisson>();
	private ArrayList<Boisson> listeVins = new ArrayList<Boisson>();

	public ListeBoissons(){
		Boisson delirium = new Boisson("Delirium", 7.30, Categorie.Bieres);
		listeBieres.add(delirium);
		Boisson guiness = new Boisson("Guiness", 4.30, Categorie.Bieres);
		listeBieres.add(guiness);
		Boisson frambLindemans = new Boisson("Framboise Lindemans", 4.90, Categorie.Bieres);
		listeBieres.add(frambLindemans);
		Boisson mille64 = new Boisson("1664", 3.80, Categorie.Bieres);
		listeBieres.add(mille64);
		Boisson chimay = new Boisson("Chimay Blonde", 4.90, Categorie.Bieres);
		listeBieres.add(chimay);
		
		Boisson apple = new Boisson("L'apple", 9.00, Categorie.Cocktails);
		apple.setIngredients("manzana, vodka, jus de pomme");
		listeCoktails.add(apple);
		Boisson tequilaSun = new Boisson("Tequila Sunrise", 9.00, Categorie.Cocktails);
		tequilaSun.setIngredients("t�quila, orange, grenadine");
		listeCoktails.add(tequilaSun);
		Boisson pinaColada = new Boisson("Pina Colada", 9.00, Categorie.Cocktails);
		pinaColada.setIngredients("rhum blanc, jus ananas et coco ");
		listeCoktails.add(pinaColada);
		Boisson greenIsland = new Boisson("Green Island", 9.00, Categorie.Cocktails);
		greenIsland.setIngredients("gin, menta verde, perrier");
		listeCoktails.add(greenIsland);
		Boisson merico = new Boisson("Merico", 9.00, Categorie.Cocktails);
		merico.setIngredients("bi�re blonde, citron vert, tequila");
		listeCoktails.add(merico);
		
		Boisson coca = new Boisson("Coca Cola", 3.80, Categorie.Sodas);
		coca.setImage("logoCoca.jpg");
		listeSodas.add(coca);
		Boisson sprite = new Boisson("Sprite", 3.80, Categorie.Sodas);
		listeSodas.add(sprite);
		Boisson orange = new Boisson("Minute Maid", 3.80, Categorie.Sodas);
		listeSodas.add(orange);
		Boisson icetea = new Boisson("Ice Tea", 3.80, Categorie.Sodas);
		listeSodas.add(icetea);
		Boisson fanta = new Boisson("Fanta", 3.80, Categorie.Sodas);
		listeSodas.add(fanta);
		
		Boisson pichet = new Boisson("Pichet Rouge,ros�,blanc", 4.50, Categorie.Vins);
		listeVins.add(pichet);
		Boisson rhone = new Boisson("Rhones", 18.0, Categorie.Vins);
		listeVins.add(rhone);
		Boisson chablis = new Boisson("Chablis", 23.0, Categorie.Vins);
		listeVins.add(chablis);
		Boisson chianti = new Boisson("Chianti", 21.0, Categorie.Vins);
		listeVins.add(chianti);
		Boisson riesling = new Boisson("Riesling", 19.0, Categorie.Vins);
		listeVins.add(riesling);
		
	}

	public ArrayList<Boisson> getListeBieres() {
		return listeBieres;
	}

	public void setListeBierres(ArrayList<Boisson> listeBieres) {
		this.listeBieres = listeBieres;
	}

	public ArrayList<Boisson> getListeCoktails() {
		return listeCoktails;
	}

	public void setListeCoktails(ArrayList<Boisson> listeCoktails) {
		this.listeCoktails = listeCoktails;
	}

	public ArrayList<Boisson> getListeSodas() {
		return listeSodas;
	}

	public void setListeSodas(ArrayList<Boisson> listeSodas) {
		this.listeSodas = listeSodas;
	}

	public ArrayList<Boisson> getListeVins() {
		return listeVins;
	}

	public void setListeVins(ArrayList<Boisson> listeVins) {
		this.listeVins = listeVins;
	}


}
