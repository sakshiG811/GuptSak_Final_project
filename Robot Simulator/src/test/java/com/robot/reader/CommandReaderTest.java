package com.robot.reader;

import junit.framework.TestCase;
import org.junit.Before;

import java.io.File;
import java.util.ArrayList;

public class CommandReaderTest extends TestCase {
	private CommandReader reader;

	@Before
	public void setUp() {
		reader = new CommandReader();
	}

	public void testReadFromFileNotExists() {
		try {
			reader.readFrom(new File("bar.txt"));
			fail("Throws an exception since bar.txt not exist");
		} catch (Exception e) {
			assertEquals("File not exist", e.getMessage());
		}
	}

	public void testReadFromFileNotFound() {
		try {
			File file = null;
			reader.readFrom(file);
			fail("Throws an exception because file not found");
		} catch (Exception e) {
			assertEquals("File not found", e.getMessage());
		}
	}

	public void testReadFromValidFile() {
		try {
			File file = new File("input-data.txt");
			ArrayList<String> result = reader.readFrom(file);
			assertEquals(3, result.size());
			assertEquals("0,1,NORTH", result.get(0));
			assertEquals("0,0,WEST", result.get(1));
			assertEquals("3,3,NORTH", result.get(2));
		} catch (Exception e) {
			//do nothing
		}
	}
}
