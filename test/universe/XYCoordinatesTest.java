package universe;

import org.junit.Assert;
import org.junit.Test;

import com.rover.space.XYcoordinates;

public class XYCoordinatesTest {

    @Test
    public void xCoordinatesAreIncrementedForPositiveValue() {
        //Given
        XYcoordinates boundaryCoordinates = new XYcoordinates(2,3);

        //When
        boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(1, 0);

        //Then
        Assert.assertEquals("3 3", boundaryCoordinates.toString());
    }

    @Test
    public void xCoordinatesAreDecrementedForNegativeValue() {
        //Given
        XYcoordinates boundaryCoordinates = new XYcoordinates(2,3);

        //When
        boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(-1, 0);

        //Then
        Assert.assertEquals("1 3", boundaryCoordinates.toString());
    }

    @Test
    public void yCoordinatesAreIncrementedForPositiveValue() {
        //Given
        XYcoordinates boundaryCoordinates = new XYcoordinates(2,3);

        //When
        boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(0, 1);

        //Then
        Assert.assertEquals("2 4", boundaryCoordinates.toString());
    }

    @Test
    public void yCoordinatesAreDecrementedForNegativeValue() {
        //Given
        XYcoordinates boundaryCoordinates = new XYcoordinates(2,3);

        //When
        boundaryCoordinates = boundaryCoordinates.newCoordinatesFor(0, -1);

        //Then
        Assert.assertEquals("2 2", boundaryCoordinates.toString());
    }

    @Test
    public void pointWithXCoordinateWithinBoundaryAreIdentified() {
        //Given
        XYcoordinates boundaryCoordinates = new XYcoordinates(5,5);

        //When
        XYcoordinates internalPoint = new XYcoordinates(4,5);

        //Then
        Assert.assertTrue(boundaryCoordinates.hasWithinBounds(internalPoint));
    }


    @Test
    public void pointWithYCoordinateWithinBoundaryAreIdentified() {
        //Given
        XYcoordinates boundaryCoordinates = new XYcoordinates(5,5);

        //When
        XYcoordinates internalPoint = new XYcoordinates(5,4);

        //Then
        Assert.assertTrue(boundaryCoordinates.hasWithinBounds(internalPoint));
    }


    @Test
    public void pointsWithXCoordinateOutsideBoundaryAreIdentified() {
        //Given
        XYcoordinates boundaryCoordinates = new XYcoordinates(5,5);

        //When
        XYcoordinates externalPoint = new XYcoordinates(8,5);

        //Then
        Assert.assertTrue(boundaryCoordinates.hasOutsideBounds(externalPoint));
    }


    @Test
    public void pointsWithYCoordinateOutsideBoundaryAreIdentified() {
        //Given
        XYcoordinates boundaryCoordinates = new XYcoordinates(5,5);

        //When
        XYcoordinates externalPoint = new XYcoordinates(5,8);

        //Then
        Assert.assertTrue(boundaryCoordinates.hasOutsideBounds(externalPoint));
    }

    @Test
    public void immutableCoordinatesAreCreatedForNewStepSize() {
        //Given
        XYcoordinates boundaryCoordinates = new XYcoordinates(5,5);

        //When
        XYcoordinates newBoundary = boundaryCoordinates.newCoordinatesForStepSize(1, -1);

        //Then
        Assert.assertEquals("6 4", newBoundary.toString());
        Assert.assertEquals("5 5", boundaryCoordinates.toString());
    }

}
