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
import donnee.Categorie;
import donnee.ListeBoissons;
import donnee.ListeNourritures;
import donnee.Nourriture;

public class PanelNourritures extends JPanel implements MouseListener {
	
	private ListeNourritures listeNourritures = new ListeNourritures(); 
	private PanelCommande commande;
	
	
	public PanelNourritures(PanelCommande c){
		setLayout(new GridLayout(3,2));
		
		commande = c;
		
		for(Categorie cat : Categorie.values()){
			if( cat.isNourriture(cat)){
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
				JLabel titre = new JLabel(cat.toString());
				titre.setBorder(BorderFactory.createLineBorder(Color.black));
				titre.setFont(new Font("TimesRoman",Font.BOLD,20));
			
				ArrayList<Nourriture> listes = new ArrayList<Nourriture>();
				
				if(cat.equals(Categorie.Entree)){
					listes = listeNourritures.getListeEntree();
				}
				else if(cat.equals(Categorie.Plat))
				{
					listes = listeNourritures.getListePlat();
				}else{
					listes = listeNourritures.getListeDessert();
				}
				JPanel panBois = new JPanel(new GridLayout(listes.size()+1,2));
				panBois.add(titre);
				panBois.add(new JLabel(""));
				for(Nourriture b : listes){
					
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
			
	}
	
	public Nourriture rechercheNourriture(String nourriture){
		for(Categorie cat : Categorie.values()){
			ArrayList<Nourriture> listes = new ArrayList<Nourriture>();
			
			if(cat.equals(Categorie.Entree)){
				listes = listeNourritures.getListeEntree();
			}
			else if(cat.equals(Categorie.Plat))
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
