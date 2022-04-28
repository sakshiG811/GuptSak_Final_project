package com.robot.simulation;


import com.robot.enums.Direction;
/**
 * Name: Sakshi Gupta
 * Date: 28 April 2022
 * Description: Position class of the project
 */
public class Position {
	private int x;
	private int y;
	private int maxX;
	private int maxY;
	private Direction direction;

	/**
	 Main Function
	 @param x
	 @param y
	 @param direction
	 */
	public Position(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return x + "," + y + "," + direction.getDescription();
	}

	/**
	 Main Function
	 @param xPoint
	 @param yPoint
	 */
	public void updatePosition(int xPoint, int yPoint) {
		int newX = getX() + xPoint;
		int newY = getY() + yPoint;
		if (newX > maxX) {
			newX = maxX;
		} else if (newX < 0) {
			newX = 0;
		}
		if (newY > maxY) {
			newY = maxY;
		} else if (newY < 0) {
			newY = 0;
		}
		this.x = newX;
		this.y = newY;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
}
