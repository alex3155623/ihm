package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import donnee.Produit;

public class CarteInteractive extends JPanel{
	
	private JLabel boissons = new JLabel(new ImageIcon("images/BoissonBouton.png"));
	private JLabel menus = new JLabel(new ImageIcon("images/MenuBouton.png"));
	private JLabel alacarte = new JLabel(new ImageIcon("images/CarteBouton.png"));

	private JLabel agent = new JLabel(new ImageIcon("images/ServeurTaisToi.png"));
	private JLabel agentFNI = new JLabel(new ImageIcon("images/ServeurFonctionNonImplemente.png"));
	
	private JPanel langue = new JPanel();
	private JLabel appelServ = new JLabel("Appel Serveur");
	private PanelCommande recapComm = new PanelCommande();
	private PanelBoissons paneBoissons = new PanelBoissons(recapComm);
	private PanelNourritures paneNourriture = new PanelNourritures(recapComm);
	private JPanel content = new JPanel();
	

	public CarteInteractive(){
		super(new BorderLayout());
		JPanel cotegauche = new JPanel(new GridLayout(3,1));
		JPanel bois = new JPanel(new BorderLayout());
		boissons.setName("Boissons");
		bois.setBackground(Color.red);
		boissons.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e)
		    {
		    	paneBoissons.setVisible(true);
		    	paneNourriture.setVisible(false);
		    	agentFNI.setVisible(false);
		    	agent.setVisible(true);
		    } 
		});  
		bois.add(boissons,BorderLayout.CENTER);
		cotegauche.add(bois);
		JPanel menu = new JPanel(new BorderLayout());
		menus.setName("menus");
		menu.setBackground(Color.orange);
		menus.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e)
		    {
		    	paneBoissons.setVisible(false);
		    	paneNourriture.setVisible(false);
		    	agentFNI.setVisible(true);
		    	agent.setVisible(false);
		    } 
		});
		menu.add(menus,BorderLayout.CENTER);
		cotegauche.add(menu);
		JPanel carte = new JPanel(new BorderLayout());
		alacarte.setName("alacarte");
		carte.setBackground(Color.YELLOW);
		alacarte.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e)
		    {
		    	paneBoissons.setVisible(false);
		    	agent.setVisible(true);
		    	paneNourriture.setVisible(true);
		    	agentFNI.setVisible(false);
		    } 
		});
		carte.add(alacarte, BorderLayout.CENTER);
		cotegauche.add(carte);
		this.add(cotegauche, BorderLayout.WEST);
		
		JPanel cotehaut = new JPanel(new BorderLayout());
		langue.setBackground(Color.white);
		langue.add(new JLabel(new ImageIcon("images/drapeauFrance.jpg")));
		langue.add(new JLabel(new ImageIcon("images/drapeauAnglais.jpg")));
		langue.add(new JLabel(new ImageIcon("images/drapeauEspagne.jpg")));
		langue.add(new JLabel(new ImageIcon("images/drapeauItalie.jpg")));
		cotehaut.add(langue, BorderLayout.WEST);
		JPanel tmp = new JPanel();
		tmp.setBackground(Color.white);
		tmp.add(Box.createRigidArea(new Dimension(5,0)));
		tmp.add(new JLabel("Table 14"));
		tmp.add(Box.createRigidArea(new Dimension(5,0)));
		cotehaut.add(tmp, BorderLayout.CENTER);
		cotehaut.add(appelServ, BorderLayout.EAST);
		cotehaut.setBackground(Color.white);
		this.add(cotehaut, BorderLayout.NORTH);
		
		
		this.add(recapComm, BorderLayout.EAST);
		
		//paneBoissons.setBackground(new Color(242,211,191));
		//paneBoissons.setForeground(new JLabel(new ImageIcon("images/CarteBouton.png")));
		paneBoissons.setVisible(false);
		paneNourriture.setVisible(false);
		agentFNI.setVisible(false);
		agent.setVisible(true);
		
		content.add(paneBoissons);
		content.add(paneNourriture);
		content.add(agent);
		content.add(agentFNI);
		content.setBackground(new Color(242,211,191));
		JScrollPane scrollContent = new JScrollPane(content);
		this.add(scrollContent, BorderLayout.CENTER);
		revalidate();
		repaint();
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		recapComm.repaint();
		repaint();
	}
}
