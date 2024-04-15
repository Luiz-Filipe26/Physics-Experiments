package gravityPhisics;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraphicPanel extends JPanel {
	private BufferedImage image;
	
	public GraphicPanel(BufferedImage image, Rectangle bounds) {
		this.image = image;
		setBounds(bounds);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	@Override
	protected void paintComponent(Graphics graphics) {
		if(image != null) {
			graphics.drawImage(image, 0, 0, null);
		}
	}
}
