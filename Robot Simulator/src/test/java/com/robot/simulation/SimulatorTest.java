package com.robot.simulation;


import com.robot.enums.Direction;
import junit.framework.TestCase;
import org.junit.Before;
import com.robot.enums.Command;
import com.robot.exceptions.InvalidRobotException;

public class SimulatorTest extends TestCase {
	
	private Simulator simulator;

	@Before
	public void setUp() {
		simulator = new Simulator();
		Robot robot = new Robot();
		SquareTable table = new SquareTable(5, 5);
		simulator.initSimulator(robot, table);
	}

	public void testPlaceCommandWithValidKeyWords() {
		simulator.placeCommand("1,1,NORTH");
		Position currentPosition = simulator.getRobot().getPosition();
		assertEquals(1, currentPosition.getX());
		assertEquals(1, currentPosition.getY());
		assertEquals(Direction.NORTH, currentPosition.getDirection());
	}

	public void testPlaceCommandWithInvalidKeyWords() {
		try {
			simulator.placeCommand("1,10,NORTH");
		} catch (InvalidRobotException e) {
			assertEquals("Invalid position", e.getMessage());
		}
	}

	public void testPlaceCommandWithInvalidCoordinate() {
		try {
			simulator.placeCommand("1,a,NORTH");
		} catch (InvalidRobotException e) {
			assertEquals("Invalid argument", e.getMessage());
		}
	}

	public void testProcessSingleValidMoveCommand() {
		simulator.placeCommand("0,0,NORTH");
		simulator.otherCommand(Command.MOVE);
		Position currentPosition = simulator.getRobot().getPosition();
		assertEquals(0, currentPosition.getX());
		assertEquals(1, currentPosition.getY());
		assertEquals(Direction.NORTH, currentPosition.getDirection());
	}

	public void testProcessSingleValidLeftCommand() {
		simulator.placeCommand("0,0,NORTH");
		simulator.otherCommand(Command.LEFT);
		Position currentPosition = simulator.getRobot().getPosition();
		assertEquals(Direction.WEST, currentPosition.getDirection());
	}

	public void testProcessSingleValidRightCommand() {
		simulator.placeCommand("0,0,NORTH");
		simulator.otherCommand(Command.RIGHT);
		Position currentPosition = simulator.getRobot().getPosition();
		assertEquals(Direction.EAST, currentPosition.getDirection());
	}

	public void testProcessSingleValidReportCommand() {
		simulator.placeCommand("0,0,NORTH");
		String result = simulator.otherCommand(Command.REPORT);
		assertEquals("0,0,NORTH", result);
	}

	public void testProcessReadCommandFromInput() {
		simulator.executeCommand("PLACE 0,0,NORTH");
		String result = simulator.executeCommand("REPORT");
		assertEquals("0,0,NORTH", result);
	}

	public void testProcessReadInvalidCommandFromInput() {
		try {
			simulator.executeCommand("PL 0,0,NORTH");
		} catch (InvalidRobotException e) {
			assertEquals("Invalid command", e.getMessage());
		}
	}

	public void testIgnoreUndefinedPositionOnSingleCommand() {
		simulator.getRobot().setPosition(null);
		String result = simulator.otherCommand(Command.MOVE);
		assertEquals("", result);
	}

	public void testInvalidPositionOnSingleCommand() {
		try {
			simulator.getRobot().setPosition(new Position(0, 0, Direction.NORTH));
			simulator.otherCommand(null);
		} catch (InvalidRobotException e) {
			assertEquals("Command not found", e.getMessage());
		}
	}
	
}
