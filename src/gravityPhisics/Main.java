package gravityPhisics;

public class Main {
	public static void main(String[] args) {
		View view = new View();
		view.setVisible(true);
		
		ImageUpdater imageUpdater = new ImageUpdater(view.getGraphicPanel());
		Drawer drawer = new Drawer(imageUpdater);
		GameLogic gameLogic = new GameLogic(drawer, View.IMAGE_WIDTH / 2, View.IMAGE_HEIGHT);
		gameLogic.start();
		view.addKeyListener(new KeyboardHandler(drawer, gameLogic));
	}
}