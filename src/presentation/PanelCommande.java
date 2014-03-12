package presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnee.Boisson;
import donnee.Commande;
import donnee.Produit;

public class PanelCommande extends JPanel{
	
	private JPanel contenuCom = new JPanel(new GridLayout(10,1));
	private JButton envoyer = new JButton("Envoyer");
	private JButton payer = new JButton("Payer");
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
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 0;
		titreRecap.setVisible(true);
		this.add(titreRecap,c);
		contenuCom.setPreferredSize(new Dimension(300, 450));
		contenuCom.setVisible(true);
		contenuCom.setBackground(Color.gray);
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 1;
		this.add(contenuCom,c);
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 2;
		
		total.setBorder(BorderFactory.createLineBorder(Color.black));
		total.setPreferredSize(new Dimension(300, 40));
		this.add(total,c);
		envoyer.setPreferredSize(new Dimension(150, 50));
		envoyer.setVisible(true);
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 0;
		c.gridy = 3;
		this.add(envoyer,c);
		payer.setPreferredSize(new Dimension(150,50));
		payer.setVisible(true);
		c.fill = GridBagConstraints.VERTICAL;
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

	public void ajoutProduit(Produit b) {
		// TODO Auto-generated method stub
		JLabel label = new JLabel(b.afficher());
		contenuCom.add(label);
		calculerTotal();
	}

	private void calculerTotal() {
		// TODO Auto-generated method stub
		double calcul = 0.0;
		for(Produit p : commande.getListeProduits()){
			calcul += p.getPrix();
		}
		total.setText("Total : ........................... "+calcul);
	}
	

}
