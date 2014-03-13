package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnee.Boisson;
import donnee.Commande;
import donnee.Nourriture;
import donnee.Produit;

public class PanelCommande extends JPanel implements MouseListener{
	
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
		Box box = Box.createHorizontalBox();
		JLabel label = new JLabel(b.afficher());
		label.setName(b.getNom());
		box.add(label);
		
		box.add(Box.createRigidArea(new Dimension(15,0)));
		JButton supp = new JButton("Supprimer");
		supp.setName(b.getNom());
		supp.addMouseListener(this);
		box.add(supp);
		contenuCom.add(box);
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		////////////
		//Attention à changer si on passe avec une image ! Code très très sale !
		//
		/////////////
		if(((JButton) arg0.getSource()).getText().equals("Supprimer")){
			Produit tmp = null;
			for(Produit p: commande.getListeProduits()){
				if( p.getNom().equals(((JButton) arg0.getSource()).getName()))
					tmp =p;
			}
			
			commande.getListeProduits().remove(tmp);
			contenuCom.remove(((Component) arg0.getSource()).getParent());
			calculerTotal();
		}
		else{
			contenuCom.removeAll();
			for(Produit p : commande.getListeProduits()){
				Box box = Box.createHorizontalBox();
				JLabel label = new JLabel(p.afficher());
				label.setName(p.getNom());
				box.add(label);
				
				box.add(Box.createRigidArea(new Dimension(15,0)));
				JLabel ok = new JLabel("Envoyé");
				ok.setName(p.getNom());
				
				box.add(ok);
				contenuCom.add(box);
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
