package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnee.Boisson;
import donnee.CategorieBoisson;
import donnee.Commande;
import donnee.ListeBoissons;

public class PanelBoissons extends JPanel implements MouseListener {
	
	private ListeBoissons listeBoissons = new ListeBoissons(); 
	private PanelCommande commande;
	
	public PanelBoissons(PanelCommande c){
		setLayout(new GridLayout(3,2));
		
		commande = c;
		
		for(CategorieBoisson cat : CategorieBoisson.values()){
			JPanel panel = new JPanel();
			panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
			JLabel titre = new JLabel(cat.toString());
			titre.setBorder(BorderFactory.createLineBorder(Color.black));
			titre.setFont(new Font("TimesRoman",Font.BOLD+Font.ITALIC,20));
			panel.add(titre);
			ArrayList<Boisson> listes = new ArrayList<Boisson>();
			
			if(cat.equals(CategorieBoisson.Bieres)){
				listes = listeBoissons.getListeBieres();
			}
			else if(cat.equals(CategorieBoisson.Coktails))
			{
				listes = listeBoissons.getListeCoktails();
			}else if(cat.equals(CategorieBoisson.Sodas))
			{
				listes = listeBoissons.getListeSodas();
			}else{
				listes = listeBoissons.getListeVins();
			}
			
			for(Boisson b : listes){
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
	
	public Boisson rechercheBoisson(String boisson){
		for(CategorieBoisson cat : CategorieBoisson.values()){
			ArrayList<Boisson> listes = new ArrayList<Boisson>();
			
			if(cat.equals(CategorieBoisson.Bieres)){
				listes = listeBoissons.getListeBieres();
			}
			else if(cat.equals(CategorieBoisson.Coktails))
			{
				listes = listeBoissons.getListeCoktails();
			}else if(cat.equals(CategorieBoisson.Sodas))
			{
				listes = listeBoissons.getListeSodas();
			}else{
				listes = listeBoissons.getListeVins();
			}
			
			for(Boisson b : listes){
				if(b.getNom().equals(boisson))
					return b;
			}
		}
		return null;
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		Boisson b = rechercheBoisson(((JLabel) arg0.getSource()).getName());
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
