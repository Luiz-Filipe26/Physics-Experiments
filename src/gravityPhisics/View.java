package gravityPhisics;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class View extends JFrame {
	
	private GraphicPanel graphicPanel;
	public static final int WINDOW_WIDTH = 900;
	public static final int WINDOW_HEIGHT = 600;
	
	private static final String WINDOW_TITLE = "Gravity test";
	
	public static final int IMAGE_WIDTH = 800;
	public static final int IMAGE_HEIGHT = 500;
	
	public static final int IMAGE_X = 20;
	public static final int IMAGE_Y = 20;
	
	public View() {
		defineViewProperties();
		defineComponents();
		addComponents();
		requestFocus();
		setLocationRelativeTo(null);
	}

	public GraphicPanel getGraphicPanel() {
		return graphicPanel;
	}
	
	private void defineViewProperties() {
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		setTitle(WINDOW_TITLE);
	}
	
	private void defineComponents() {
		BufferedImage image = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		graphicPanel = new GraphicPanel(image, new Rectangle(IMAGE_X, IMAGE_Y, IMAGE_WIDTH, WINDOW_HEIGHT));
	}
	
	private void addComponents() {
		add(graphicPanel);
		pack();
	}
}
