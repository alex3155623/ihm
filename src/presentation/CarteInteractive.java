package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import donnee.Produit;

public class CarteInteractive extends JPanel{
	
	private JLabel boissons = new JLabel("Boissons");
	private JLabel menus = new JLabel("Menus");
	private JLabel alacarte = new JLabel("A la Carte");
	private JLabel langue = new JLabel("Francais | Anglais | Espagnol");
	private JLabel appelServ = new JLabel("Appel Serveur");
	private PanelCommande recapComm = new PanelCommande();
	private PanelBoissons paneBoissons = new PanelBoissons();
	private PanelNourritures paneNourriture = new PanelNourritures();
	

	public CarteInteractive(){
		super(new BorderLayout());
		JPanel cotegauche = new JPanel(new GridLayout(3,1));
		boissons.setName("Boissons");
		boissons.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e)
		    {
		    	paneBoissons.setVisible(true);
		    	paneNourriture.setVisible(false);
		    } 
		});  
		cotegauche.add(boissons);
		menus.setName("menus");
		menus.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e)
		    {
		    	paneBoissons.setVisible(false);
		    	paneNourriture.setVisible(false);
		    } 
		});
		cotegauche.add(menus);
		alacarte.setName("alacarte");
		alacarte.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e)
		    {
		    	paneBoissons.setVisible(false);
		    	paneNourriture.setVisible(true);
		    } 
		});
		cotegauche.add(alacarte);
		cotegauche.setBackground(Color.white);
		this.add(cotegauche, BorderLayout.WEST);
		
		JPanel cotehaut = new JPanel(new FlowLayout());
		cotehaut.add(langue);
		cotehaut.add(appelServ);
		cotehaut.setBackground(Color.white);
		this.add(cotehaut, BorderLayout.NORTH);
		
		
		this.add(recapComm, BorderLayout.EAST);
		
		paneBoissons.setVisible(false);
		paneNourriture.setVisible(false);
		JPanel content = new JPanel();
		content.add(paneBoissons);
		content.add(paneNourriture);
		this.add(content, BorderLayout.CENTER);
		
		
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		recapComm.repaint();
		repaint();
	}
}
