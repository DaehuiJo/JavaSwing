package Transh;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Subpanel extends JPanel {

	public Image img = null;
	protected static File imagefile = new File("images/Main_Page_Sample1.png");
	
	public Subpanel() {
		
		try {
			img = ImageIO.read(imagefile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paint(Graphics g) {

		g.drawImage(img, 0, 0, this);
	}
}
