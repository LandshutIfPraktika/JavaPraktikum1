public class Bithattan {
	public static int abs(int x){
		if (x < 0){
			return -x;
		} else {
			return x;
		}
	}
	//Frage wegen else/if Schlange
	public static int distToEdge(int[] point, int size){
		int dist = size-1;
		if (point[0] < dist){
			dist = point[0];
		}
		if (point[1] < dist){
			dist = point[1];
		}
		if ((size-1) - point[0] < dist){
			dist = (size-1) - point[0];
		}
		if ((size-1) - point[1] < dist){
			dist = (size-1) - point[1];
		}
		return dist;
	}
	
	public static void main(String[] args){		
		
		final int gridSize = Integer.parseInt(args[0]);
		final int startPos = Integer.parseInt(args[1]);
		final int endPos = Integer.parseInt(args[2]);
		
		final int[] startPoint = {startPos / 10, startPos % 10};
		final int[] endPoint = {endPos / 10, endPos % 10};
		
		final int directFare = abs(startPoint[0]-endPoint[0]) + abs(startPoint[1]-endPoint[1]);
		final int circumFare = distToEdge(startPoint,gridSize)+distToEdge(endPoint,gridSize);
		
		if (directFare <= circumFare){
			System.out.println(directFare);
		} else {
			System.out.println(circumFare);
		}
	}
}
