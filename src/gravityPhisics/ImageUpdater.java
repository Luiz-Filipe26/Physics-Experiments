package gravityPhisics;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImageUpdater {
	
	private BufferedImage image;
	private JPanel graphicPanel;
	
	private int width;
	private int height;
	
	public ImageUpdater(GraphicPanel graphicPanel) {
		this.graphicPanel = graphicPanel;
		this.image = graphicPanel.getImage();
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public void drawLayer(BufferedImage layer) {
		image.getGraphics().drawImage(layer, 0, 0, null);
		graphicPanel.getGraphics().drawImage(image, 0, 0, null);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}