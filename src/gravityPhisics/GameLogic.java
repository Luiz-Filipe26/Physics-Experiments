package gravityPhisics;

public class GameLogic extends Thread {
	
	public enum Position {
		UP, DOWN, RIGHT, LEFT
	}
	
	private Drawer drawer;
	
	public static int ballDiameter = 20;
	
	private int xBall, yBall;
	private float xBallSpeed;
	private float yBallSpeed;
	private final float GRAVITY_ACCELERATION = 200.0f;
	private final float FRICTION_ACCELERATION = 150.0f;
	private final int JUMP_SPEED = 200;
	private final int FREQUENCY = 30;
	
	public GameLogic(Drawer drawer, int initialX, int initialY) {
		this.drawer = drawer;
		xBall = initialX;
		yBall = initialY;
		drawer.generateBall(xBall, yBall);
		drawer.updatePicture();
	}
	
	@Override
	public void run() {
		int waitingTime = 1000 / FREQUENCY;
		
		while(true) {
			waitTime(waitingTime);
			processCoordinates();
			drawer.generateBall(xBall, yBall);
			drawer.updatePicture();
		}
		
	}
	
	private void waitTime(int waitingTime) {
		try {
			Thread.sleep(waitingTime);
		} catch (InterruptedException e) {
			System.err.println("Error in sleep");
		}
	}
	
	private void processCoordinates() {
		if(xBallSpeed != 0) {
			processX();
		}
		
		if(yBall < View.IMAGE_HEIGHT || yBallSpeed < 0) {
			processY();
		}
	}
	
	private void processX() {
		float deltaXSpeed = - Math.signum(xBallSpeed) * FRICTION_ACCELERATION / FREQUENCY;
		float newXBallSpeed = xBallSpeed + deltaXSpeed;
		if(Math.signum(newXBallSpeed) != Math.signum(xBallSpeed)) {
			xBallSpeed = 0;
			return;
		}
		xBallSpeed = newXBallSpeed;
		float deltaX = xBallSpeed / FREQUENCY;
		xBall += deltaX;
	}
	
	private void processY() {
		yBallSpeed += GRAVITY_ACCELERATION / FREQUENCY;
		float deltaY = yBallSpeed / FREQUENCY;
		
		if(yBall + deltaY < View.IMAGE_HEIGHT) {
			yBall += deltaY;
		}
		else {
			yBall = View.IMAGE_HEIGHT;
			yBallSpeed = 0;
		}
	}
	
	public void move(Position position) {
		switch(position) {
			case UP -> {
				if(yBallSpeed == 0)
					yBallSpeed -= JUMP_SPEED;
			}
			case DOWN -> xBall += 10;
			case LEFT -> xBallSpeed -= 10;
			case RIGHT -> xBallSpeed += 10;
		}
	}
	
	public int getXBall() {
		return xBall;
	}
	
	public int getYBall() {
		return yBall;
	}
	
}