package com.robot.enums;

import junit.framework.TestCase;
import org.junit.Before;

public class DirectionTest extends TestCase {
	private Direction direction;

	@Before
	public void setUp() {
		direction = Direction.NORTH;
	}

	public void testDerivedEnums() {
		assertEquals(Direction.EAST, Direction.from("EAST"));
		assertEquals(Direction.WEST, Direction.from("WEST"));
		assertEquals(Direction.NORTH, Direction.from("NORTH"));
		assertEquals(Direction.WEST, Direction.from("WEST"));
	}

	public void testInvalidDirectionEnum() {
		assertNull(Direction.from("BARRR"));
	}

	public void testChangeDirectionFromNorthToWest() {
		Direction newDirection = direction.changeDirection(-1);
		assertEquals(Direction.WEST, newDirection);
	}

	public void testChangeDirectionFromNorthToEast() {
		Direction newDirection = direction.changeDirection(1);
		assertEquals(Direction.EAST, newDirection);
	}
}