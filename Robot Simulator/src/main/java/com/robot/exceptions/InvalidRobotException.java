package com.robot.exceptions;
/**
 * Name: Sakshi Gupta
 * Date: 28 April 2022
 * Description: Invalid Exception class of the project
 */
public class InvalidRobotException extends RuntimeException {
	private String message;

	/**
	 Main Function
	 @param message
	 */
	public InvalidRobotException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
