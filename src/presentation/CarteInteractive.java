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
	private JPanel accueil = new JPanel(new BorderLayout());
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
		    	accueil.setVisible(false);
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
		    	accueil.setVisible(false);
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
		    	accueil.setVisible(false);
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
		langue.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e)
		    {
		    	paneBoissons.setVisible(false);
		    	agent.setVisible(false);
		    	paneNourriture.setVisible(false);
		    	agentFNI.setVisible(true);
		    	accueil.setVisible(true);
		    } 
		});
		cotehaut.add(langue, BorderLayout.WEST);
		JPanel tmp = new JPanel();
		tmp.setBackground(new Color(146,207,238));
		tmp.add(Box.createRigidArea(new Dimension(5,0)));
		JLabel titre =new JLabel("Table 14");
		titre.setFont(new Font("TimesRoman",Font.BOLD,20));
		tmp.add(titre);
		tmp.add(Box.createRigidArea(new Dimension(5,0)));
		cotehaut.add(tmp, BorderLayout.CENTER);
		appelServ.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e)
		    {
		    	paneBoissons.setVisible(false);
		    	agent.setVisible(false);
		    	paneNourriture.setVisible(false);
		    	agentFNI.setVisible(true);
		    	accueil.setVisible(true);
		    } 
		});
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
		JLabel titreAcc = new JLabel("Bienvenue !");
		titreAcc.setFont(new Font("Chalkduster",Font.BOLD,40));
		accueil.setBackground(new Color(252,243,214));
		accueil.add(Box.createRigidArea(new Dimension(0,250)), BorderLayout.NORTH);
		accueil.add(titreAcc, BorderLayout.CENTER);
		temp.add(accueil);
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
		content.setPreferredSize(new Dimension(600,1000));
		content.setBackground(new Color(252,243,214));
		JScrollPane scrollContent = new JScrollPane(content);
		this.add(scrollContent, BorderLayout.CENTER);
		revalidate();
		repaint();
		
	}
	
	public JLabel getBoissons() {
		return boissons;
	}

	public void setBoissons(JLabel boissons) {
		this.boissons = boissons;
	}

	public JLabel getMenus() {
		return menus;
	}

	public void setMenus(JLabel menus) {
		this.menus = menus;
	}

	public JLabel getAlacarte() {
		return alacarte;
	}

	public void setAlacarte(JLabel alacarte) {
		this.alacarte = alacarte;
	}

	public JLabel getAgent() {
		return agent;
	}

	public void setAgent(JLabel agent) {
		this.agent = agent;
	}

	public JLabel getAgentFNI() {
		return agentFNI;
	}

	public void setAgentFNI(JLabel agentFNI) {
		this.agentFNI = agentFNI;
	}

	public JPanel getLangue() {
		return langue;
	}

	public void setLangue(JPanel langue) {
		this.langue = langue;
	}

	public JPanel getAccueil() {
		return accueil;
	}

	public void setAccueil(JPanel accueil) {
		this.accueil = accueil;
	}

	public JLabel getAppelServ() {
		return appelServ;
	}

	public void setAppelServ(JLabel appelServ) {
		this.appelServ = appelServ;
	}

	public PanelCommande getRecapComm() {
		return recapComm;
	}

	public void setRecapComm(PanelCommande recapComm) {
		this.recapComm = recapComm;
	}

	public PanelBoissons getPaneBoissons() {
		return paneBoissons;
	}

	public void setPaneBoissons(PanelBoissons paneBoissons) {
		this.paneBoissons = paneBoissons;
	}

	public PanelNourritures getPaneNourriture() {
		return paneNourriture;
	}

	public void setPaneNourriture(PanelNourritures paneNourriture) {
		this.paneNourriture = paneNourriture;
	}

	public JPanel getContent() {
		return content;
	}

	public void setContent(JPanel content) {
		this.content = content;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		recapComm.repaint();
		repaint();
	}
}
