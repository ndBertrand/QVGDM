/*
 * Bertrand NDAYISENGA
 * David Messan KENEY
 * */
package images;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dessin extends Canvas {
	

private String lien;
	
	

public String getLien() {
	return lien;
}

public Dessin(String lien){
		this.lien = lien;
	}

public void paint(Graphics g){
		
		File image = new File(lien);
		  try {
			BufferedImage bfImage = ImageIO.read(image);
			g.drawImage(bfImage, 0, 0, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
