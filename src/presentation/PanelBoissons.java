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
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnee.Boisson;
import donnee.Categorie;
import donnee.Commande;
import donnee.ListeBoissons;

public class PanelBoissons extends JPanel implements MouseListener {
	
	private ListeBoissons listeBoissons = new ListeBoissons(); 
	private PanelCommande commande;
	
	public PanelBoissons(PanelCommande c){
		setLayout(new GridLayout(4,1));
		setBackground(new Color(132,211,191));
		commande = c;
		
		for(Categorie cat : Categorie.values()){
			if(cat.isBoisson(cat))
			{
				JPanel panel = new JPanel();
				panel.setBackground(new Color(132,211,191));
				panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
				JLabel titre = new JLabel(cat.toString());
				titre.setBorder(BorderFactory.createLineBorder(Color.black));
				titre.setFont(new Font("TimesRoman",Font.BOLD,20));
				
				ArrayList<Boisson> listes = new ArrayList<Boisson>();
				
				if(cat.equals(Categorie.Bieres)){
					listes = listeBoissons.getListeBieres();
				}
				else if(cat.equals(Categorie.Cocktails))
				{
					listes = listeBoissons.getListeCoktails();
				}else if(cat.equals(Categorie.Sodas))
				{
					listes = listeBoissons.getListeSodas();
				}else{
					listes = listeBoissons.getListeVins();
				}
				JPanel panBois = new JPanel(new GridLayout(listes.size()+1,2));
				
				panBois.add(titre);
				panBois.add(new JLabel());
				panBois.setBackground(new Color(132,211,191));
				for(Boisson b : listes){
					
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
	
	public Boisson rechercheBoisson(String boisson){
		for(Categorie cat : Categorie.values()){
			ArrayList<Boisson> listes = new ArrayList<Boisson>();
			
			if(cat.equals(Categorie.Bieres)){
				listes = listeBoissons.getListeBieres();
			}
			else if(cat.equals(Categorie.Cocktails))
			{
				listes = listeBoissons.getListeCoktails();
			}else if(cat.equals(Categorie.Sodas))
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
		Boisson clone = (Boisson) b.clone();
		commande.getCommande().ajoutProduitCommande(clone);
		commande.ajoutProduit(clone);
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
