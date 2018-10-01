package com.rover;

import com.rover.MarsRover;
import com.rover.space.XYcoordinates;
import com.rover.space.DirectionOfMotion;
import com.rover.space.Plateau;

public class CheckMarsRover {
  	public static void main(String args[]) {
        
         Plateau plateau = new Plateau(5,5);
         XYcoordinates startingPosition = new XYcoordinates(1,2);
        
         MarsRover marsRover = new MarsRover(plateau, DirectionOfMotion.N, startingPosition);

         String location=  marsRover.currentLocation().toString();
         System.out.println(location);
         marsRover.run("LMLMLMLMM");
         String locationNew=  marsRover.currentLocation().toString();
         System.out.println(locationNew);
         
         XYcoordinates startingPosition2 = new XYcoordinates(3,3);
         
         MarsRover marsRover2 = new MarsRover(plateau, DirectionOfMotion.E, startingPosition2);

         String location2=  marsRover2.currentLocation().toString();
         System.out.println(location2);
         marsRover2.run("MMRMMRMRRM");
         
         String locationNew2=  marsRover2.currentLocation().toString();
         System.out.println(locationNew2);
	}
}
