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

		final JFrame frame = new JFrame("Carte Interactive - IHM / CIE - Projet");
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
	}

}
