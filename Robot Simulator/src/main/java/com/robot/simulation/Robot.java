package com.robot.simulation;


import com.robot.enums.Direction;
import com.robot.exceptions.InvalidRobotException;
/**
 * Name: Sakshi Gupta
 * Date: 28 April 2022
 * Description: Robot class of the project
 */
public class Robot {
    Position position;

    public void move() {
        if (position.getDirection().equals(Direction.NORTH)) {
            position.updatePosition(0, 1);
        } else if (position.getDirection().equals(Direction.SOUTH)) {
            position.updatePosition(0, -1);
        } else if (position.getDirection().equals(Direction.EAST)) {
            position.updatePosition(1, 0);
        } else if (position.getDirection().equals(Direction.WEST)) {
            position.updatePosition(-1, 0);
        }
    }

    public void left() {
        Direction newDirection = getPosition().getDirection().changeDirection(-1);
        getPosition().setDirection(newDirection);
    }

    public void right() {
        Direction newDirection = getPosition().getDirection().changeDirection(1);
        getPosition().setDirection(newDirection);
    }

    public String report() {
        return position.toString();
    }

    /**
     Main Function
     @param position
     @param table
     */
    public void placeRobot(Position position, SquareTable table) {
        if (table == null) {
            throw new InvalidRobotException(("Table not found"));
        }

        if (position == null) {
            throw new InvalidRobotException("Position not found");
        }

        if (!table.validatePosition(position)) {
            throw new InvalidRobotException("Invalid position");
        }
        position.setMaxX(table.getRows());
        position.setMaxY(table.getColumns());
        setPosition(position);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
