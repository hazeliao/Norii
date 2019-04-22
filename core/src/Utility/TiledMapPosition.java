package Utility;

import java.awt.Point;
import java.awt.geom.Point2D;

import com.mygdx.game.Map.Map;

public class TiledMapPosition {
	private Point2D realCoordinates;
	private Point tileCoordinates;
	
	public TiledMapPosition(float x,float y) {
		realCoordinates = new Point2D.Float(x,y);
		tileCoordinates = new Point((int) (x * Map.UNIT_SCALE),(int) (y * Map.UNIT_SCALE));
	}
	
	public TiledMapPosition(int x,int y) {
		realCoordinates = new Point2D.Float((float) (x / Map.UNIT_SCALE),(float) (y / Map.UNIT_SCALE));
		tileCoordinates = new Point(x,y);
	}
	
	public void setPosition(float x, float y) {
		realCoordinates = new Point2D.Float(x,y);
		tileCoordinates = new Point((int) (x * Map.UNIT_SCALE),(int) (y * Map.UNIT_SCALE));
	}
	
	public void setPosition(int x, int y) {
		realCoordinates = new Point2D.Float((float) (x / Map.UNIT_SCALE),(float) (y / Map.UNIT_SCALE));
		tileCoordinates = new Point(x,y);
	}
	
	public Point2D getPositionAsRealCoordinates() {
		return realCoordinates;
	}
	
	public Point getPositionAsTileCoordinates() {
		return tileCoordinates;
	}
	
	public void moveStepsUpward(int steps){
		float currentRealX = (float) realCoordinates.getX();
		float currentRealY = (float) realCoordinates.getY();
		realCoordinates.setLocation(currentRealX, currentRealY + steps / Map.UNIT_SCALE);
		
		int currentTileX = tileCoordinates.x;
		int currentTileY = tileCoordinates.y;
		tileCoordinates.setLocation(currentTileX, currentTileY + steps);
	}
	
	public void moveStepsDownward(int steps){
		float currentRealX = (float) realCoordinates.getX();
		float currentRealY = (float) realCoordinates.getY();
		realCoordinates.setLocation(currentRealX, currentRealY - steps / Map.UNIT_SCALE);
		
		int currentTileX = tileCoordinates.x;
		int currentTileY = tileCoordinates.y;
		tileCoordinates.setLocation(currentTileX, currentTileY - steps);
	}
	
	public void moveStepsLeft(int steps){
		float currentRealX = (float) realCoordinates.getX();
		float currentRealY = (float) realCoordinates.getY();
		realCoordinates.setLocation(currentRealX - steps / Map.UNIT_SCALE, currentRealY);
		
		int currentTileX = tileCoordinates.x;
		int currentTileY = tileCoordinates.y;
		tileCoordinates.setLocation(currentTileX - steps, currentTileY);
	}
	
	public void moveStepsRight(int steps){
		float currentRealX = (float) realCoordinates.getX();
		float currentRealY = (float) realCoordinates.getY();
		realCoordinates.setLocation(currentRealX + steps / Map.UNIT_SCALE, currentRealY);
		
		int currentTileX = tileCoordinates.x;
		int currentTileY = tileCoordinates.y;
		tileCoordinates.setLocation(currentTileX + steps, currentTileY);
	}

}