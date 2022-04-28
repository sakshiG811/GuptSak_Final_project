package com.robot.simulation;

import com.robot.enums.Direction;
import com.robot.enums.Command;
import com.robot.exceptions.InvalidRobotException;
/**
 * Name: Sakshi Gupta
 * Date: 28 April 2022
 * Description: Simulator class of the project
 */
public class Simulator {
    private Robot toyRobot;
    private SquareTable table;

    /**
     Main Function
     @param robot
     @param table
     */
    public void initSimulator(Robot robot, SquareTable table) {
        this.toyRobot = robot;
        this.table = table;
    }

    /**
     Main Function
     @param commands
     */
    public void placeCommand(String commands) {
        int xValue = 0;
        int yValue = 0;
        String[] commandArgs = commands.split(",");
        try {
            xValue = Integer.parseInt(commandArgs[0]);
            yValue = Integer.parseInt(commandArgs[1]);
        } catch (Exception ex) {
            throw new InvalidRobotException("Invalid argument");
        }
        Direction direction = Direction.from(commandArgs[2]);
        Position position = new Position(xValue, yValue, direction);
        toyRobot.placeRobot(position, table);
    }

    /**
     Main Function
     @param currentCommand
     */
    public String otherCommand(Command currentCommand) {
        String output = "";
        if (toyRobot.getPosition() == null) {
            return output;
        }
        if (currentCommand == null) {
            throw new InvalidRobotException("Command not found");
        }
        switch (currentCommand) {
            case MOVE:
                toyRobot.move();
                break;
            case LEFT:
                toyRobot.left();
                break;
            case RIGHT:
                toyRobot.right();
                break;
            case REPORT:
                output = toyRobot.report();
                break;
        }
        return output;
    }

    /**
     Main Function
     @param commandLine
     */
    public String executeCommand(String commandLine) {
        String[] commandArgs = commandLine.split(" ");
        String output = "";
        try {
            Command command = Command.valueOf(commandArgs[0]);
            if (command == Command.PLACE) {
                placeCommand(commandArgs[1]);
            } else {
                output = otherCommand(command);
            }
        } catch (IllegalArgumentException ex) {
            throw new InvalidRobotException("Invalid command");
        }
        return output;
    }

    public Robot getRobot() {
        return toyRobot;
    }
}
