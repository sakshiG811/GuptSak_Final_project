package com.robot;


import com.robot.reader.CommandReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Name: Sakshi Gupta
 * Date: 28 April 2022
 * Description: Main class of the project
 */
public class Main {
	/**
	 Main Function
	 @param args
	 */
	public static void main(String[] args) {
		try {
			CommandReader reader = new CommandReader();
			if (args.length == 1 && !args[0].isEmpty()) {
				printResult(reader.readFrom(new File(args[0])));
			}else{
				System.out.println("Run command: java -jar robot-simulator-1.0-SNAPSHOT.jar <input file>");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 Main Function
	 @param result
	 */
	public static void printResult(ArrayList<String> result) {
		result.stream().forEach(r -> {
			System.out.println("Output: " + r);
		});
	}
}
