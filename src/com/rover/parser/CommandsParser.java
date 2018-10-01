package com.rover.parser;

import java.util.*;

import com.rover.commands.ICommand;
import com.rover.commands.CommandM;
import com.rover.commands.CommandL;
import com.rover.commands.CommandR;

public class CommandsParser {

    public static final String BY_EACH_CHARACTER = "";
    public static final int START_INDEX = 0;

    private static Map<String, ICommand> stringToCommandMap = new HashMap<String, ICommand>() {{
        put("L", new CommandL());
        put("R", new CommandR());
        put("M", new CommandM());
    }};

    private String commandString; //sp

    public CommandsParser(final String commandString) {
        this.commandString = commandString;
    }

    public List<ICommand> toCommands() {
        if(isNullOrEmpty(commandString)) return new ArrayList<ICommand>();
        return buildCommandsList(commandString);
    }

    private List<ICommand> buildCommandsList(final String commandString) {
        List<ICommand> commands = new ArrayList<ICommand>();

        for(String commandCharacter : commandCharactersFrom(commandString)) {
            if (commandCharacter == null) break;
            ICommand mappedCommand = lookupEquivalentCommand(commandCharacter.toUpperCase());
            commands.add(mappedCommand);
        }

        return commands;
    }

    private boolean isNullOrEmpty(final String commandString) {
        return (null == commandString || commandString.trim().length() == 0);
    }

    private String[] commandCharactersFrom(final String commandString) {
        return Arrays.copyOfRange(commandString.split(BY_EACH_CHARACTER), START_INDEX, commandString.length() + 1);
    }

    private ICommand lookupEquivalentCommand(final String commandString) {
        return stringToCommandMap.get(commandString);
    }

}
