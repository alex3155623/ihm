package donnee;

public enum Categorie {
	Bieres, Cocktails, Sodas, Vins, Entree, Plat, Dessert;
	
	public boolean isBoisson(Categorie cat){
		if(cat.equals(Bieres) || cat.equals(Cocktails)  || cat.equals(Sodas) || cat.equals(Vins))
			return true;
		else
			return false;
	}
	
	public boolean isNourriture(Categorie cat){
		if(cat.equals(Entree) || cat.equals(Plat)  || cat.equals(Dessert) )
			return true;
		else
			return false;
	}
}
