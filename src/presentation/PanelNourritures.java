package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnee.Boisson;
import donnee.CategorieBoisson;
import donnee.CategorieNourriture;
import donnee.ListeBoissons;
import donnee.ListeNourritures;
import donnee.Nourriture;

public class PanelNourritures extends JPanel implements MouseListener {
	
	private ListeNourritures listeNourritures = new ListeNourritures(); 
	private PanelCommande commande;
	
	
	public PanelNourritures(PanelCommande c){
		setLayout(new GridLayout(3,2));
		
		commande = c;
		
		for(CategorieNourriture cat : CategorieNourriture.values()){
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
			JLabel titre = new JLabel(cat.toString());
			titre.setBorder(BorderFactory.createLineBorder(Color.black));
			titre.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,20));
			panel.add(titre);
			ArrayList<Nourriture> listes = new ArrayList<Nourriture>();
			
			if(cat.equals(CategorieNourriture.Entree)){
				listes = listeNourritures.getListeEntree();
			}
			else if(cat.equals(CategorieNourriture.Plat))
			{
				listes = listeNourritures.getListePlat();
			}else{
				listes = listeNourritures.getListeDessert();
			}
			
			for(Nourriture b : listes){
				JPanel panBois = new JPanel(new FlowLayout());
				panBois.add(new JLabel(b.toString()));
				JLabel ajout= new JLabel("Ajouter");
				ajout.addMouseListener(this);
				ajout.setName(b.getNom());
				panBois.add(ajout);
				panel.add(panBois);
			}
			this.add(panel);
		}
	}
	
	public Nourriture rechercheNourriture(String nourriture){
		for(CategorieNourriture cat : CategorieNourriture.values()){
			ArrayList<Nourriture> listes = new ArrayList<Nourriture>();
			
			if(cat.equals(CategorieNourriture.Entree)){
				listes = listeNourritures.getListeEntree();
			}
			else if(cat.equals(CategorieNourriture.Plat))
			{
				listes = listeNourritures.getListePlat();
			}else{
				listes = listeNourritures.getListeDessert();
			}
			
			for(Nourriture b : listes){
				if(b.getNom().equals(nourriture))
					return b;
			}
		}
		return null;
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		Nourriture b = rechercheNourriture(((JLabel) arg0.getSource()).getName());
		commande.getCommande().ajoutProduitCommande(b);
		commande.ajoutProduit(b);
		commande.repaint();
		commande.validate();
		repaint();
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
