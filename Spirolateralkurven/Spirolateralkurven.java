import java.util.*;




class Spirolateralkurven{
	public static void main(String... args){
		
		final int sizeX = Integer.parseInt(args[0]);
		final int sizeY = Integer.parseInt(args[1]);
		final int logicalSize = Integer.parseInt(args[2]);
		final int angle = Integer.parseInt(args[3]);
		final int repetitions = Integer.parseInt(args[4]);
		int paintedAngle = 0;
		int count = 0;
		Double xOffset = 0.0;
		Double yOffset = 0.0;
		
		List<Double> xPositions = new ArrayList<Double>();
		List<Double> yPositions = new ArrayList<Double>();


		if ((angle * repetitions)%360 == 0){
			System.out.println("Spirolateralkurve mit Winkel="+angle+" und Widerholungen="+repetitions+" nicht moeglich!");
			System.out.println("Winkel * Wiederholungen != n*360");
			return;
		}
		

		
		TurtlePainter turtle = new TurtlePainter(sizeX, sizeY, logicalSize);
		do{
			for (int i = 1; i<= repetitions; i++){
				turtle.fly(i);
				turtle.turn(angle);	
				paintedAngle = paintedAngle + angle;
				xPositions.add(turtle.getXPos());
				yPositions.add(turtle.getYPos());
				
			}
			count++;
			if(count >=1000){
				break;
			}
		} while(paintedAngle%360 != 0);



		for(Double x:xPositions){
			xOffset = xOffset + x;
		}
		xOffset = - xOffset/xPositions.size();

		for(Double y:yPositions){
			yOffset = yOffset + y;
		}
		yOffset = - yOffset/yPositions.size();


		turtle.flyTo(xOffset,yOffset);
		turtle.colors(repetitions);

		do{
			for (int i = 1; i<= repetitions; i++){
				
				turtle.color(i-1);
				turtle.move(i);
				turtle.turn(angle);	
				paintedAngle = paintedAngle + angle;
				
			}
			count++;
			if(count >=1000){
				break;
			}
		} while(paintedAngle%360 != 0);
		
		turtle.repaint();
	}
}