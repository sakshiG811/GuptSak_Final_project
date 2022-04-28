package com.robot.simulation;

import junit.framework.TestCase;
import org.easymock.EasyMock;
import org.junit.Before;

public class SquareTableTest extends TestCase {
	private SquareTable table;

	@Before
	public void setUp() {
		table = new SquareTable(5, 5);
	}

	public void testValidatePositionWithinRange() {
		Position mockPosition = EasyMock.createNiceMock(Position.class);
		EasyMock.expect(mockPosition.getX()).andReturn(3);
		EasyMock.expect(mockPosition.getY()).andReturn(4);
		EasyMock.replay(mockPosition);

		assertTrue(table.validatePosition(mockPosition));
	}

	public void testValidatePositionOutOfRange() {
		Position mockPosition = EasyMock.createNiceMock(Position.class);
		EasyMock.expect(mockPosition.getX()).andReturn(3);
		EasyMock.expect(mockPosition.getY()).andReturn(6);
		EasyMock.replay(mockPosition);

		assertFalse(table.validatePosition(mockPosition));
	}
	
}