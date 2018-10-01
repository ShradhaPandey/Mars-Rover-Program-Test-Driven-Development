package com.rover.space;

public class XYcoordinates {

    private int xCoordinate;
    private int yCoordinate;

    public XYcoordinates(final int xCoordinate, final int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public XYcoordinates newCoordinatesFor(final int xCoordinateStepValue, final int yCoordinateStepValue) {
        return new XYcoordinates(this.xCoordinate + xCoordinateStepValue, this.yCoordinate + yCoordinateStepValue);
    }

    @Override
    public String toString() {
        StringBuilder coordinateOutput = new StringBuilder();
        coordinateOutput.append(xCoordinate);
        coordinateOutput.append(" ");
        coordinateOutput.append(yCoordinate);
        return coordinateOutput.toString();
    }

    public boolean hasWithinBounds(final XYcoordinates coordinates) {
        return isXCoordinateWithinBounds(coordinates.xCoordinate) && isYCoordinateWithinBounds(coordinates.yCoordinate);
    }

    public boolean hasOutsideBounds(final XYcoordinates coordinates) {
        return isXCoordinateInOutsideBounds(coordinates.xCoordinate) && isYCoordinateInOutsideBounds(coordinates.yCoordinate);
    }

    private boolean isXCoordinateInOutsideBounds(final int xCoordinate) {
        return xCoordinate >= this.xCoordinate;
    }

    private boolean isYCoordinateInOutsideBounds(final int yCoordinate) {
        return yCoordinate >= this.yCoordinate;
    }

    private boolean isYCoordinateWithinBounds(final int yCoordinate) {
        return yCoordinate <= this.yCoordinate;
    }

    private boolean isXCoordinateWithinBounds(final int xCoordinate) {
        return xCoordinate <= this.xCoordinate;
    }

    public XYcoordinates newCoordinatesForStepSize(final int xCoordinateStepValue, final int yCoordinateStepValue) {
        return new XYcoordinates(xCoordinate+xCoordinateStepValue, yCoordinate+yCoordinateStepValue);
    }

}
