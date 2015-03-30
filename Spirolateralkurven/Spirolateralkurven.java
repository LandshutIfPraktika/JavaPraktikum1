class Spirolateralkurven{
	public static void main(String... args){
		
		final int sizeX = Integer.parseInt(args[0]);
		final int sizeY = Integer.parseInt(args[1]);
		final int logicalSize = Integer.parseInt(args[2]);
		final int angle = Integer.parseInt(args[3]);
		final int repetitions = Integer.parseInt(args[4]);
		int paintedAngle = 0;
		int count = 0;

		if ((angle * repetitions)%360 == 0){
			System.out.println("Spirolateralkurve mit Winkel="+angle+" und Widerholungen="+repetitions+" nicht moeglich!");
			System.out.println("Winkel * Wiederholungen != n*360");
			return;
		}
		
		
		TurtlePainter turtle = new TurtlePainter(sizeX, sizeY, logicalSize);
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