package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnee.Categorie;
import donnee.Commande;
import donnee.Produit;


public class PanelCommande extends JPanel implements MouseListener{
	
	private JPanel contenuCom = new JPanel(new GridLayout(15,1));
	private JButton envoyer = new JButton("Envoyer");
	private JButton payer = new JButton("Addition");
	private Commande commande;
	JLabel total = new JLabel("Total :");
	
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public PanelCommande(){
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		setBackground(Color.white);
		JLabel titreRecap = new JLabel("Recapitulatif Commande");
		titreRecap.setBorder(BorderFactory.createLineBorder(Color.black));
		titreRecap.setPreferredSize(new Dimension(300, 50));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		titreRecap.setVisible(true);
		this.add(titreRecap,c);
		contenuCom.setPreferredSize(new Dimension(300, 450));
		contenuCom.setMinimumSize(new Dimension(300, 450));
		contenuCom.setVisible(true);
		contenuCom.setBackground(Color.gray);
		c.gridx = 0;
		c.gridy = 1;
		this.add(contenuCom,c);
		c.gridx = 0;
		c.gridy = 2;
		
		total.setBorder(BorderFactory.createLineBorder(Color.black));
		total.setPreferredSize(new Dimension(300, 40));
		this.add(total,c);
		envoyer.setPreferredSize(new Dimension(150, 50));
		envoyer.setMinimumSize(new Dimension(150, 50));
		envoyer.setVisible(true);
		envoyer.addMouseListener(this);
		c.gridx = 0;
		c.gridy = 3;
		this.add(envoyer,c);
		payer.setPreferredSize(new Dimension(150,50));
		payer.setMinimumSize(new Dimension(150,50));
		payer.setVisible(true);
		c.gridx = 0;
		c.gridy = 4;
		this.add(payer,c);
		
		// Creation de l'objet Commande
		commande = new Commande();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		contenuCom.revalidate();
		contenuCom.repaint();
		repaint();
	}

	public void ajoutProduit(final Produit b) {
		// TODO Auto-generated method stub
		rafraichirListeCommande();
		
	}

	private void rafraichirListeCommande() {
		// TODO Auto-generated method stub
		contenuCom.removeAll();
		ArrayList<Produit> commandes = new ArrayList<Produit>();
		for(Categorie cat : Categorie.values()){
			for(Produit p : commande.getListeProduits()){
				if(p.getCategorie().equals(cat))
					commandes.add(p);
			}
		}
		Produit tmp = null;
		boolean flag = true;
		for(Produit p : commandes){
			if(tmp==null){
				tmp = p;
			}
			else
			{
				if(!p.getCategorie().equals(tmp.getCategorie())){
					flag = true;
				}
				else
					flag = false;
			}
			// On crée l'affichage des produits commandés
			Box box = Box.createHorizontalBox();
			if(flag)
			{
				JLabel titre =new JLabel(p.getCategorie().toString());
				titre.setBorder(BorderFactory.createLineBorder(Color.black));
				titre.setFont(new Font("TimesRoman",Font.BOLD,15));
				box.add(titre);
				contenuCom.add(box);
			}
			box = Box.createHorizontalBox();
			JLabel label = new JLabel(p.afficher());
			label.setName(p.getNom());
			box.add(label);
			box.add(Box.createRigidArea(new Dimension(15,0)));
			if(p.isEnvoye()){
				JLabel ok = new JLabel(new ImageIcon("images/checkVert.jpg"));
				ok.setName(p.getNom());
				box.add(ok);
			}
			else{
				JLabel supp = new JLabel(new ImageIcon("images/croixRouge.jpg"));
				supp.setName(p.getNom());
				supp.addMouseListener(this);
				box.add(supp);
			}
			calculerTotal();
			contenuCom.add(box);
			
			tmp =p;
				
		}

		
	}

	private void calculerTotal() {
		// TODO Auto-generated method stub
		double calcul = 0.0;
		for(Produit p : commande.getListeProduits()){
			calcul += p.getPrix();
		}
		total.setText("Total : ........................... "+calcul);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		if( arg0.getSource() instanceof JLabel && ((JLabel) arg0.getSource()).getIcon() != null && ((JLabel) arg0.getSource()).getIcon().toString().equals("images/croixRouge.jpg")
				){
			Produit tmp = null;
			for(Produit p: commande.getListeProduits()){
				if( p.getNom().equals(((JLabel) arg0.getSource()).getName()))
					tmp =p;
			}
			
			commande.getListeProduits().remove(tmp);
			contenuCom.remove(((Component) arg0.getSource()).getParent());
			calculerTotal();
		}
		else{
			contenuCom.removeAll();
			String res = "";
			for(Produit p : commande.getListeProduits()){
				
				p.setEnvoye(true);
				rafraichirListeCommande();
				
				
				}
			PrintWriter ecri ;
			try
			{
				ecri = new PrintWriter(new FileWriter("commande.txt"));
				ecri.print(res);
				ecri.flush();
				ecri.close();
			}//try
			catch (NullPointerException a)
			{
				System.out.println("Erreur : pointeur null");
			}
			catch (IOException a)
			{
				System.out.println("Problème d'IO");
			}
		
				
			
		}
		
		contenuCom.validate();
		contenuCom.repaint();
		validate();
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
