package com.rover;

import com.rover.commands.ICommand;
import com.rover.parser.CommandsParser;
import com.rover.space.XYcoordinates;
import com.rover.space.DirectionOfMotion;
import com.rover.space.Plateau;

import java.util.List;

public class MarsRover {

    private XYcoordinates currentCoordinates;
    private DirectionOfMotion currentDirection;
    private Plateau plateau;


    public MarsRover(final Plateau plateau, final DirectionOfMotion direction, final XYcoordinates coordinates) {
        this.plateau = plateau;
        this.currentDirection = direction;
        this.currentCoordinates = coordinates;
    }

    public void run(final String commandString) {
        List<ICommand> roverCommands = new CommandsParser(commandString).toCommands();
        for (ICommand command : roverCommands) {
            command.execute(this);
        }
        
    }

    public String currentLocation() {
        return currentCoordinates.toString() + " " + currentDirection.toString();
    }

    public void turnRight() {
        this.currentDirection = this.currentDirection.right();
    }

    public void turnLeft() {
        this.currentDirection = this.currentDirection.left();
    }

    public void move() {
        XYcoordinates positionAfterMove = currentCoordinates.newCoordinatesForStepSize(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());
       
        //ignores the command if rover is being driven off plateau
        if(plateau.hasWithinBounds(positionAfterMove))
            currentCoordinates = currentCoordinates.newCoordinatesFor(currentDirection.stepSizeForXAxis(), currentDirection.stepSizeForYAxis());
        
    }
    
    
    
}
