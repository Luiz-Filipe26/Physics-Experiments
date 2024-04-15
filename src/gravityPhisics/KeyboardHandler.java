package gravityPhisics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardHandler implements KeyListener {
	private GameLogic gameLogic;
	private Drawer drawer;
	
	public KeyboardHandler(Drawer drawer, GameLogic gameLogic) {
		this.gameLogic = gameLogic;
		this.drawer = drawer;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP, KeyEvent.VK_W 		-> gameLogic.move(GameLogic.Position.UP);
			case KeyEvent.VK_DOWN, KeyEvent.VK_S	-> gameLogic.move(GameLogic.Position.DOWN);
			case KeyEvent.VK_LEFT, KeyEvent.VK_A 	-> gameLogic.move(GameLogic.Position.LEFT);
			case KeyEvent.VK_RIGHT, KeyEvent.VK_D 	-> gameLogic.move(GameLogic.Position.RIGHT);
				
		}
		drawer.generateBall(gameLogic.getXBall(), gameLogic.getYBall());
		drawer.updatePicture();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
