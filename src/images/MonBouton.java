/*
 * Bertrand NDAYISENGA
 * David Messan KENEY
 * */
package images;

import java.awt.Color;

import javax.swing.JButton;

public class MonBouton extends JButton {

	public MonBouton(String text, int type) {
		this.setText(text);
		switch (type) {
		case 1:
			Btn();
			break;
		case 2:
			Btn50();
			break;
		case 3:
			BtnPublic();
			break;
		case 4:
			BtnCall();
			break;
		case 5:Btn2();break;
		}
		
	}

	public void Btn() {
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource("btn.jpg")));
		this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		this.setForeground(Color.white);
		this.setBackground(Color.decode("#183152"));
	}

	public void Btn50() {
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource("cinquante.jpg")));
		this.setForeground(Color.white);
		this.setBackground(Color.decode("#7401DF"));
	}

	public void BtnPublic() {
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource("public.png")));
		this.setForeground(Color.white);
		this.setBackground(Color.decode("#6A0888"));
	}

	public void BtnCall() {
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource("call.png")));
		this.setForeground(Color.white);
		this.setBackground(Color.decode("#7401DF"));
	}

	public void Btn2() {
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource("btn2.jpg")));
		this.setForeground(Color.orange);
		this.setBackground(Color.white);
		this.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		this.setFocusable(false);
	}

}
