package com.robot.reader;


import com.robot.exceptions.InvalidRobotException;
import com.robot.simulation.Robot;
import com.robot.simulation.Simulator;
import com.robot.simulation.SquareTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Name: Sakshi Gupta
 * Date: 28 April 2022
 * Description: Command Reader class of the project
 */
public class CommandReader {

	protected Simulator createRobotSimulator() {
		SquareTable table = new SquareTable(5, 5);
		Robot robot = new Robot();
		Simulator simulator = new Simulator();
		simulator.initSimulator(robot, table);
		return simulator;
	}

	/**
	 Main Function
	 @param file
	 */
	public ArrayList<String> readFrom(File file)
	throws IOException, InvalidRobotException {
		if (file == null) {
			throw new InvalidRobotException("File not found");
		}
		if (!file.exists()) {
			throw new InvalidRobotException("File not exist");
		}
		return read(file);
	}
	/**
	 Main Function
	 @param file
	 */
	private ArrayList<String> read(File file)
	throws IOException {
		ArrayList<String> result = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			Simulator simulator = createRobotSimulator();
			String currentLine;
			String output;
			while ((currentLine = br.readLine()) != null) {
				output = simulator.executeCommand(currentLine);
				if (currentLine.equals("REPORT")) {
					result.add(output);
				}
			}
		}
		return result;
	}
}
