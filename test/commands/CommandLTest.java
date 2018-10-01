package commands;

import com.rover.MarsRover;
import com.rover.commands.CommandL;
import com.rover.space.XYcoordinates;
import com.rover.space.DirectionOfMotion;
import com.rover.space.Plateau;

import org.junit.Assert;
import org.junit.Test;

public class CommandLTest {

    @Test
    public void testThatRotateLeftCommandRotatesTheNavigableObjectLeft() {
        //Given
        CommandL command = new CommandL();
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(1,2);
        MarsRover rover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

        //When
        command.execute(rover);

        //Then
        Assert.assertEquals("1 2 W", rover.currentLocation());
    }

}
