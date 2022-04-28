package com.robot.enums;
/**
 * Name: Sakshi Gupta
 * Date: 28 April 2022
 * Description: Direction class of the project
 */
public enum Direction {
	NORTH("NORTH"),
	EAST("EAST"),
	SOUTH("SOUTH"),
	WEST("WEST");

	private String description;

	Direction(String description) {
		this.description = description;
	}

	/**
	 Main Function
	 @param description
	 */
	public static Direction from(String description) {
		for (Direction direction : values()) {
			if (direction.getDescription().equalsIgnoreCase(description)) {
				return direction;
			}
		}
		return null;
	}

	/**
	 Main Function
	 @param rotatePoint
	 */
	public Direction changeDirection(int rotatePoint) {
		int resultIndex = ((ordinal() + rotatePoint) + 4) % 4;
		return values()[resultIndex];
	}

	public String getDescription() {
		return description;
	}
}

