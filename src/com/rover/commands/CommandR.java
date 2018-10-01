package com.rover.commands;

import com.rover.MarsRover;

public class CommandR implements ICommand {

    @Override
    public void execute(final MarsRover rover) {
        rover.turnRight();
    }

}
