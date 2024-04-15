package gravityPhisics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Drawer {
	private ImageUpdater imageUpdater;
	private BufferedImage layer1;
	private BufferedImage layer2;
	
	private int image_width;
	private int image_height;
	
	public Drawer(ImageUpdater imageUpdater) {
		this.imageUpdater = imageUpdater;
		image_width = imageUpdater.getWidth();
		image_height = imageUpdater.getHeight();
		
		layer1 = new BufferedImage(image_width, image_height, BufferedImage.TYPE_INT_RGB);
		layer2 = new BufferedImage(image_width, image_height, BufferedImage.TYPE_INT_RGB);
		
		initializeGraphics();
	}
	
	private void initializeGraphics() {
        Graphics graphics = layer1.getGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, image_width, image_height);
	}
	
	public void generateBall(int x, int y) {
		layer2 = new BufferedImage(image_width, image_height, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = layer2.getGraphics();
		graphics.setColor(new Color(0, 0, 0, 0));
		graphics.fillRect(0, 0, image_width, image_height);
		graphics.setColor(Color.white);
		graphics.drawOval(x, y - GameLogic.ballDiameter, GameLogic.ballDiameter, GameLogic.ballDiameter);
	}
	
	public void updatePicture() {
		imageUpdater.drawLayer(layer1);
		imageUpdater.drawLayer(layer2);
	}
}
