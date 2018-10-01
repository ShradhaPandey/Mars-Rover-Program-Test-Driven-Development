package universe;

import org.junit.Assert;
import org.junit.Test;

import com.rover.space.XYcoordinates;
import com.rover.space.Plateau;

public class PlateauTest {

    @Test
    public void locationWithCoordinateWithinBoundsIsIdentified() {
        //Given
        Plateau mars = new Plateau(5,5);

        //When
        XYcoordinates plateauCoordinates = new XYcoordinates(5, 0);

        //Then
        Assert.assertTrue(mars.hasWithinBounds(plateauCoordinates));
    }

    @Test
    public void locationWithPositiveXCoordinateOutsideBoundsIsIdentified() {
        //Given
        Plateau mars = new Plateau(5,5);

        //When
        XYcoordinates coordinates = new XYcoordinates(6, 0);

        //Then
        Assert.assertFalse(mars.hasWithinBounds(coordinates));
    }

    @Test
    public void locationWithNegativeXCoordinateOutsideBoundsIsIdentified() {
        //Given
        Plateau mars = new Plateau(5,5);

        //When
        XYcoordinates coordinates = new XYcoordinates(-1, 0);


        //Then
        Assert.assertFalse(mars.hasWithinBounds(coordinates));
    }

    @Test
    public void locationWithPositiveYCoordinateOutsideBoundsIsIdentified() {
        //Given
        Plateau mars = new Plateau(5,5);

        //When
        XYcoordinates coordinates = new XYcoordinates(0, 6);


        //Then
        Assert.assertFalse(mars.hasWithinBounds(coordinates));
    }

    @Test
    public void locationWithNegativeYCoordinateOutsideBoundsIsIdentified() {
        //Given
        Plateau mars = new Plateau(5,5);

        //When
        XYcoordinates coordinates = new XYcoordinates(0, -1);


        //Then
        Assert.assertFalse(mars.hasWithinBounds(coordinates));
    }
}
