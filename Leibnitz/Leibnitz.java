public class Leibnitz {
	
	public static void main(String[] Args){
		
		boolean isEven = true;
		int count = 0;
		double sum = 0;
		
		while(Math.abs((Math.PI-sum*4)) > 1e-6){
			if(isEven){
				sum = sum + (1.0/((double)count * 2 +1));
			} else {
				sum = sum - (1.0/((double)count * 2 +1));
			}
			count++;
			isEven = !isEven;
		}
		
		System.out.println(count);		
	}
	
}