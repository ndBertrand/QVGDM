/*
 * Bertrand NDAYISENGA
 * David Messan KENEY
 * */
import java.awt.BorderLayout;
import java.awt.GridLayout;


import javax.swing.*;

import images.Dessin;
import images.MonBouton;

import java.awt.event.*;


public class Start extends JFrame{

	
	private JButton quitter = new MonBouton("Quiter",1);
	private JButton commencer = new MonBouton("Commencer",1);
	private JLabel message = new JLabel("Bien venu dans Qui veut Gagner Des Millons");
	private Dessin ds;
	public Start(){
		init();
	}
	public void init(){
		
		
		
		/*initialisation de la fenêtre*/
		this.setTitle("QVGDM");
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		
		
		/*Creation des panel de la fenetre*/
		JPanel panneau2 = new JPanel();
	
		ds = new Dessin("src/images/qvgdm.jpg");
		this.add(ds,BorderLayout.CENTER);
		this.add(panneau2,BorderLayout.SOUTH);
		
		
		
		
		
		panneau2.setLayout(new GridLayout(1,3));
		
		panneau2.add(quitter);
		panneau2.add(commencer);
		
		quitter.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent evt) {
	            	quitterActionPerformed(evt);
	            }
	        });
		
		commencer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	commencerActionPerformed(evt);
            }
        });
		
	}
	private void quitterActionPerformed(ActionEvent evt) {                                         
	        // TODO add your handling code here:
		 System.exit(0);
	 }
	
	private void commencerActionPerformed(ActionEvent evt){
		this.setVisible(false);
		Game game = new Game();
	}
		public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Start start = new Start();
	}

}
