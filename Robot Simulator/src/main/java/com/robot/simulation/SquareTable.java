package com.robot.simulation;
/**
 * Name: Sakshi Gupta
 * Date: 28 April 2022
 * Description: Square Table class of the project
 */
public class SquareTable {
	private int rows;
	private int columns;

	/**
	 Main Function
	 @param rows
	 @param columns
	 */
	public SquareTable(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
	}

	/**
	 Main Function
	 @param position
	 */
	public boolean validatePosition(Position position) {
		int xValue = position.getX();
		int yValue = position.getY();
		if (xValue > rows || xValue < 0 ||
				yValue > columns || yValue < 0) {
			return false;
		}
		return true;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
}
