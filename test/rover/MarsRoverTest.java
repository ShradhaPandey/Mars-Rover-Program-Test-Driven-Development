package rover;
import com.rover.MarsRover;
import com.rover.space.XYcoordinates;
import com.rover.space.DirectionOfMotion;
import com.rover.space.Plateau;

import org.junit.Assert;
import org.junit.Test;

public class MarsRoverTest {

    @Test
    public void canProvideCurrentLocationAsString() {
        //Given
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(3,3);

        //When
        MarsRover marsRover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

        //then
        Assert.assertEquals("3 3 N", marsRover.currentLocation());
    }

    @Test
    public void canRotateLeft() {
        //Given
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

        //When
        marsRover.turnLeft();

        //then
        Assert.assertEquals("1 2 W", marsRover.currentLocation());
    }

    @Test
    public void canRotateRight() {
        //Given
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

        //When
        marsRover.turnRight();

        //then
        Assert.assertEquals("1 2 E", marsRover.currentLocation());
    }

    @Test
    public void canMove() {
        //Given
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

        //When
        marsRover.move();

        //then
        Assert.assertEquals("1 3 N", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandToRotateRight() {
        //Given
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

        //When
        marsRover.run("R");

        //then
        Assert.assertEquals("1 2 E", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandToRotateLeft() {
        //Given
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

        //When
        marsRover.run("L");

        //then
        Assert.assertEquals("1 2 W", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandToMove() {
        //Given
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(1,2);
        MarsRover marsRover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

        //When
        marsRover.run("M");

        //then
        Assert.assertEquals("1 3 N", marsRover.currentLocation());
    }

    @Test
    public void canRunCommandWithMultipleInstructions() {
        //Given
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(3,3);
        MarsRover marsRover = new MarsRover(plateau, DirectionOfMotion.E, startingPosition);

        //When
        marsRover.run("MMRMMRMRRM");

        //then
        Assert.assertEquals("5 1 E", marsRover.currentLocation());
    }

    @Test
    public void wontDriveOffPlateau() {
        //Given
        Plateau plateau = new Plateau(5,5);
        XYcoordinates startingPosition = new XYcoordinates(3,3);
        MarsRover marsRover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

        //When
        marsRover.run("MMMMMMMMMMR");

        //then
        Assert.assertEquals("3 5 E", marsRover.currentLocation());
    }
}
