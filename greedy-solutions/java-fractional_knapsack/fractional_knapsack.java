import java.util.*;

public class greedy2 {
    
	private static double getOptimalValue(int capacity, int[] values, int[] weights, double[] valuePerUnit) {
        
		double value = 0, totalAdded = 0;
		
		int initialCapacity = capacity;
		
		while(capacity > 0){
		
			int bestIndex = indexOftheBest(valuePerUnit);
		
			double totalWeight = 0, unitValue = valuePerUnit[bestIndex];
			
			while(totalWeight < weights[bestIndex] && totalAdded < initialCapacity){
				totalWeight++;
				totalAdded++;
				capacity--;
				value += unitValue;
			
			}
			
			valuePerUnit[bestIndex] = 0;
		
		}
		
        return value;
    }
	
	private static int indexOftheBest(double[] valuePerUnit){
	
		int index = 0;
		double best = 0;
		
		for(int i = 0; i < valuePerUnit.length; i++){
		
			if(valuePerUnit[i] > best){best = valuePerUnit[i]; index = i;}
		
		}
		
		return index;
	
	}

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int totalItems = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[totalItems];
        int[] weights = new int[totalItems];
		double[] valuePerUnit = new double[totalItems];
        for (int i = 0; i < totalItems; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
			valuePerUnit[i] = (double) values[i] / weights[i];
        }
		System.out.printf("%.4f\n", getOptimalValue(capacity, values, weights, valuePerUnit));
    }
} 
