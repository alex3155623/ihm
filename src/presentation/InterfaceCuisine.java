package presentation;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnee.Categorie;
import donnee.Commande;
import donnee.Produit;

public class InterfaceCuisine extends JPanel{
	
	private Commande c;
	JPanel entrep = new JPanel();
	JPanel platp = new JPanel();
	JPanel dessertp = new JPanel();
	public InterfaceCuisine(CarteInteractive carte){
		
		setLayout(new GridLayout(6,1));
		JLabel entree = new JLabel("Entree");
		entree.setBorder(BorderFactory.createLineBorder(Color.black));
		entree.setFont(new Font("TimesRoman",Font.BOLD,15));
		JLabel plat = new JLabel("Plat");
		plat.setBorder(BorderFactory.createLineBorder(Color.black));
		plat.setFont(new Font("TimesRoman",Font.BOLD,15));
		JLabel dessert = new JLabel("Dessert");
		dessert.setBorder(BorderFactory.createLineBorder(Color.black));
		dessert.setFont(new Font("TimesRoman",Font.BOLD,15));
		
		this.add(entree);
		this.add(entrep);
		this.add(plat);
		this.add(platp);
		this.add(dessert);
		this.add(dessertp);
		c = carte.getRecapComm().getCommande();
		Thread t = new Thread() {
	        public void run() {
	        	
	        	while(true){
	        		try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	for(Produit p : c.getListeProduitsEnvoyes()){
	        		if(p.getCategorie().equals(Categorie.Entree)){
	        			final JPanel tmp = new JPanel(new GridLayout(3,1));
	        			JLabel titreRecap = new JLabel("Table 14");
	        			titreRecap.setBorder(BorderFactory.createLineBorder(Color.black));
	        			JLabel titrep = new JLabel(p.getNom());
	        			
	        			tmp.add(titreRecap);
	        			tmp.add(Box.createRigidArea(new Dimension(0,20)));
	        			tmp.add(titrep);
	        			tmp.setBorder(BorderFactory.createLineBorder(Color.black));
	        			tmp.addMouseListener(new MouseAdapter() {
	        			    public void mouseClicked(MouseEvent e)
	        			    {
	        			    	tmp.removeAll();
	        			    } 
	        			});
	        			entrep.add(tmp);
	        			entrep.repaint();
	        			repaint();
	        			
	        		}else if(p.getCategorie().equals(Categorie.Plat))
	        		{
	        			final JPanel tmp = new JPanel(new GridLayout(3,1));
	        			JLabel titreRecap = new JLabel("Table 14");
	        			titreRecap.setBorder(BorderFactory.createLineBorder(Color.black));
	        			JLabel titrep = new JLabel(p.getNom());
	        			
	        			tmp.add(titreRecap);
	        			tmp.add(Box.createRigidArea(new Dimension(0,30)));
	        			tmp.add(titrep);
	        			tmp.setBorder(BorderFactory.createLineBorder(Color.black));
	        			tmp.addMouseListener(new MouseAdapter() {
	        			    public void mouseClicked(MouseEvent e)
	        			    {
	        			    	tmp.removeAll();
	        			    } 
	        			});
	        			platp.add(tmp);
	        			platp.repaint();
	        			repaint();
	        			
	        		} else if(p.getCategorie().equals(Categorie.Dessert)){
	        			final JPanel tmp = new JPanel(new GridLayout(3,1));
	        			JLabel titreRecap = new JLabel("Table 14");
	        			titreRecap.setBorder(BorderFactory.createLineBorder(Color.black));
	        			JLabel titrep = new JLabel(p.getNom());
	        			
	        			tmp.add(titreRecap);
	        			tmp.add(Box.createRigidArea(new Dimension(0,20)));
	        			tmp.add(titrep);
	        			tmp.setBorder(BorderFactory.createLineBorder(Color.black));
	        			tmp.addMouseListener(new MouseAdapter() {
	        			    public void mouseClicked(MouseEvent e)
	        			    {
	        			    	tmp.removeAll();
	        			    } 
	        			});
	        			dessertp.add(tmp);
	        			dessertp.repaint();
	        			repaint();
	        		}
	        	}
	        	c.getListeProduitsEnvoyes().clear();
	        }	
	        	
	        }
	      };
	      t.start();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		entrep.revalidate();
		entrep.repaint();
		revalidate();
		repaint();
	}

}
