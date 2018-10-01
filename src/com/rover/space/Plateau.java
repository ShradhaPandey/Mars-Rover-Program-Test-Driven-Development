package com.rover.space;

public class Plateau {

    private XYcoordinates topRightCoordinates = new XYcoordinates(0, 0);
    private XYcoordinates bottomLeftCoordinates = new XYcoordinates(0, 0);

    public Plateau(final int topRightXCoordinate, final int topRightYCoordinate) {
        this.topRightCoordinates = this.topRightCoordinates.newCoordinatesFor(topRightXCoordinate, topRightYCoordinate);
    }

    public boolean hasWithinBounds(final XYcoordinates coordinates) {
        return this.bottomLeftCoordinates.hasOutsideBounds(coordinates) && this.topRightCoordinates.hasWithinBounds(coordinates);
    }

}
