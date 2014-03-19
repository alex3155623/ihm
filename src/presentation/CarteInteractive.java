package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
	private JLabel appelServ = new JLabel(new ImageIcon("images/AppelServeurCool.png"));
	private PanelCommande recapComm = new PanelCommande();
	private PanelBoissons paneBoissons = new PanelBoissons(recapComm);
	private PanelNourritures paneNourriture = new PanelNourritures(recapComm);
	private JPanel content = new JPanel(new BorderLayout());
	

	public CarteInteractive(){
		super(new BorderLayout());
		JPanel cotegauche = new JPanel(new GridLayout(3,1));
		JPanel bois = new JPanel(new BorderLayout());
		boissons.setName("Boissons");
		bois.setBackground(new Color(146,207,238));
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
		menu.setBackground(new Color(146,207,238));
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
		carte.setBackground(new Color(146,207,238));
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
		langue.setBackground(new Color(146,207,238));
		langue.add(new JLabel(new ImageIcon("images/drapeauFrance.jpg")));
		langue.add(new JLabel(new ImageIcon("images/drapeauAnglais.jpg")));
		langue.add(new JLabel(new ImageIcon("images/drapeauEspagne.jpg")));
		langue.add(new JLabel(new ImageIcon("images/drapeauItalie.jpg")));
		cotehaut.add(langue, BorderLayout.WEST);
		JPanel tmp = new JPanel();
		tmp.setBackground(new Color(146,207,238));
		tmp.add(Box.createRigidArea(new Dimension(5,0)));
		JLabel titre =new JLabel("Table 14");
		titre.setFont(new Font("TimesRoman",Font.BOLD,20));
		tmp.add(titre);
		tmp.add(Box.createRigidArea(new Dimension(5,0)));
		cotehaut.add(tmp, BorderLayout.CENTER);
		cotehaut.add(appelServ, BorderLayout.EAST);
		cotehaut.setBackground(new Color(146,207,238));
		this.add(cotehaut, BorderLayout.NORTH);
		
		
		this.add(recapComm, BorderLayout.EAST);
		
		//paneBoissons.setBackground(new Color(242,211,191));
		//paneBoissons.setForeground(new JLabel(new ImageIcon("images/CarteBouton.png")));
		paneBoissons.setVisible(false);
		paneNourriture.setVisible(false);
		agentFNI.setVisible(false);
		agent.setVisible(true);
		JPanel temp = new JPanel();
		temp.setBackground(new Color(252,243,214));
		paneBoissons.setPreferredSize(new Dimension(650,800));
		temp.add(paneBoissons);
		paneNourriture.setPreferredSize(new Dimension(700,1000));
		temp.add(paneNourriture);
		content.add(temp,BorderLayout.CENTER);
		JPanel temp2 = new JPanel();
		temp2.setBackground(new Color(252,243,214));
		temp2.add(Box.createRigidArea(new Dimension(0,1000)));
		temp2.add(agent);
		temp2.add(agentFNI);
		content.add(temp2,BorderLayout.EAST);
		content.setPreferredSize(new Dimension(800,1000));
		content.setBackground(new Color(252,243,214));
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
