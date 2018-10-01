package parser;

import com.rover.commands.ICommand;
import com.rover.commands.CommandM;
import com.rover.commands.CommandL;
import com.rover.commands.CommandR;
import com.rover.parser.CommandsParser;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CommandsParserTest {

    @Test
    public void stringLMapsToRotateLeftCommand() {
        //Given
        CommandsParser parser = new CommandsParser("L");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof CommandL);
        Assert.assertEquals(1, commands.size());
    }

    @Test
    public void stringRMapsToRotateRightCommand() {
        //Given
        CommandsParser parser = new CommandsParser("R");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof CommandR);
    }

    @Test
    public void stringMMapsToMoveCommand() {
        //Given
        CommandsParser parser = new CommandsParser("M");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof CommandM);
    }


    @Test
    public void emptyStringResultsInEmptyCommandList() {
        //Given
        CommandsParser parser = new CommandsParser("");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertEquals(0, commands.size());
    }


    @Test
    public void nullStringResultsInEmptyCommandList() {
        //Given
        CommandsParser parser = new CommandsParser(null);

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertEquals(0, commands.size());
    }

    @Test
    public void stringToCommandMappingIsCaseInsensitive() {
        //Given
        CommandsParser parser = new CommandsParser("mM");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof CommandM);
        Assert.assertTrue(commands.get(1) instanceof CommandM);
    }

    @Test
    public void multiCommandStringIsMappedToCommandsInSameOrder() {
        //Given
        CommandsParser parser = new CommandsParser("MRL");

        //When
        List<ICommand> commands = parser.toCommands();

        //Then
        Assert.assertTrue(commands.get(0) instanceof CommandM);
        Assert.assertTrue(commands.get(1) instanceof CommandR);
        Assert.assertTrue(commands.get(2) instanceof CommandL);
    }

}
