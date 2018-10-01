package commands;

import com.rover.MarsRover;
import com.rover.commands.CommandR;
import com.rover.space.XYcoordinates;
import com.rover.space.DirectionOfMotion;
import com.rover.space.Plateau;

import org.junit.Assert;
import org.junit.Test;

public class CommandRTest {

    @Test
    public void testThatRotateRightCommandRotatesTheNavigableObjectRight() {
        //Given
        CommandR command = new CommandR();
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(1,2);
        MarsRover rover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

        //When
        command.execute(rover);

        //Then
        Assert.assertEquals("1 2 E", rover.currentLocation());
    }

}
