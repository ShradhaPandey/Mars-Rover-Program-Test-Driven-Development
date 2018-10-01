package com.rover.commands;

import com.rover.MarsRover;

public class CommandM implements ICommand {

    @Override
    public void execute(final MarsRover rover) {
        rover.move();
    }

}
