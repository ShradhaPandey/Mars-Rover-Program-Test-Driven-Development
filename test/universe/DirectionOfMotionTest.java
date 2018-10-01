package universe;

import org.junit.Assert;
import org.junit.Test;

import com.rover.space.DirectionOfMotion;

public class DirectionOfMotionTest {

    @Test
    public void westIsOnLeftOfNorth() {
        //Given
        DirectionOfMotion north = DirectionOfMotion.N;

        //When
        DirectionOfMotion west = north.left();

        //Then
        Assert.assertEquals(DirectionOfMotion.W, west);
    }

    @Test
    public void eastIsOnRightOfNorth() {
        //Given
        DirectionOfMotion north = DirectionOfMotion.N;

        //When
        DirectionOfMotion east = north.right();

        //Then
        Assert.assertEquals(DirectionOfMotion.E, east);
    }

    @Test
    public void northIsOnRightOfWest() {
        //Given
        DirectionOfMotion west = DirectionOfMotion.W;

        //When
        DirectionOfMotion north = west.right();

        //Then
        Assert.assertEquals(DirectionOfMotion.N, north);
    }

    @Test
    public void southIsOnLeftOfWest() {
        //Given
        DirectionOfMotion west = DirectionOfMotion.W;

        //When
        DirectionOfMotion south = west.left();

        //Then
        Assert.assertEquals(DirectionOfMotion.S, south);
    }

    @Test
    public void eastIsOnLeftOfSouth() {
        //Given
        DirectionOfMotion south = DirectionOfMotion.S;

        //When
        DirectionOfMotion east = south.left();

        //Then
        Assert.assertEquals(DirectionOfMotion.E, east);
    }

    @Test
    public void westIsOnRightOfSouth() {
        //Given
        DirectionOfMotion south = DirectionOfMotion.S;

        //When
        DirectionOfMotion west = south.right();

        //Then
        Assert.assertEquals(DirectionOfMotion.W, west);
    }

    @Test
    public void northIsOnLeftOfEast() {
        //Given
        DirectionOfMotion east = DirectionOfMotion.E;

        //When
        DirectionOfMotion north = east.left();

        //Then
        Assert.assertEquals(DirectionOfMotion.N, north);
    }

    @Test
    public void southIsOnRightOfEast() {
        //Given
        DirectionOfMotion east = DirectionOfMotion.E;

        //When
        DirectionOfMotion south = east.right();

        //Then
        Assert.assertEquals(DirectionOfMotion.S, south);
    }

    @Test
    public void eastIsOneStepForwardOnXAxis() {
        //Given
        DirectionOfMotion east = DirectionOfMotion.E;

        //When
        int stepSize = east.stepSizeForXAxis();

        //Then
        Assert.assertEquals(1, stepSize);
    }

    @Test
    public void eastIsStationaryOnYAxis() {
        //Given
        DirectionOfMotion east = DirectionOfMotion.E;

        //When
        int stepSize = east.stepSizeForYAxis();

        //Then
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void westIsOneStepBackOnXAxis() {
        //Given
        DirectionOfMotion west = DirectionOfMotion.W;

        //When
        int stepSize = west.stepSizeForXAxis();

        //Then
        Assert.assertEquals(-1, stepSize);
    }


    @Test
    public void westIsStationaryOnYAxis() {
        //Given
        DirectionOfMotion west = DirectionOfMotion.W;

        //When
        int stepSize = west.stepSizeForYAxis();

        //Then
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void northIsOneStepForwardOnYAxis() {
        //Given
        DirectionOfMotion north = DirectionOfMotion.N;

        //When
        int stepSize = north.stepSizeForYAxis();

        //Then
        Assert.assertEquals(1, stepSize);
    }


    @Test
    public void northIsStationaryOnXAxis() {
        //Given
        DirectionOfMotion north = DirectionOfMotion.N;

        //When
        int stepSize = north.stepSizeForXAxis();

        //Then
        Assert.assertEquals(0, stepSize);
    }

    @Test
    public void southIsOneStepBackOnYAxis() {
        //Given
        DirectionOfMotion south = DirectionOfMotion.S;

        //When
        int stepSize = south.stepSizeForYAxis();

        //Then
        Assert.assertEquals(-1, stepSize);
    }

    @Test
    public void southIsStationaryOnXAxis() {
        //Given
        DirectionOfMotion south = DirectionOfMotion.S;

        //When
        int stepSize = south.stepSizeForXAxis();

        //Then
        Assert.assertEquals(0, stepSize);
    }
}
