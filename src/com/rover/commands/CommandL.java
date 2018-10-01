package com.rover.commands;

import com.rover.MarsRover;

public class CommandL implements ICommand {

    @Override
    public void execute(final MarsRover rover) {
        rover.turnLeft();
    }

}
