package presentation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class IHM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 final JFrame frame = new JFrame("Carte Interactive - IHM / CIE - Projet - Interface Client");
	     	// on cree un objet configuration et le menu
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setPreferredSize(new Dimension(1500,700));
	        CarteInteractive carte = new CarteInteractive();
	        carte.setBackground(Color.white);
	        frame.setContentPane(carte);
	        frame.pack();
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override public void run() {
	            
	            	frame.validate();
	            	frame.repaint();
	                frame.setVisible(true);
	                
	            }
	        });
        
     /*   final JFrame frame2 = new JFrame("Carte Interactive - IHM / CIE - Projet - Interface Client");
     	// on cree un objet configuration et le menu
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setPreferredSize(new Dimension(1500,700));
        InterfaceServeur serveur = new InterfaceServeur( carte);
        serveur.setBackground(Color.white);
        frame2.setContentPane(serveur);
        frame2.pack();
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
            
            	frame2.validate();
            	frame2.repaint();
            	frame2.setVisible(true);
                
            }
        });*/
        
        final JFrame frame3 = new JFrame("Carte Interactive - IHM / CIE - Projet - Interface Cuisine");
     	// on cree un objet configuration et le menu
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setPreferredSize(new Dimension(1500,700));
        InterfaceCuisine cuisine = new InterfaceCuisine( carte);
        cuisine.setBackground(Color.white);
        frame3.setContentPane(cuisine);
        frame3.pack();
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
            
            	frame3.validate();
            	frame3.repaint();
            	frame3.setVisible(true);
                
            }
        });
        
       
	}

}
