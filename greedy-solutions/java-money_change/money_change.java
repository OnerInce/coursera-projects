import java.util.Scanner;

public class greedy1{

	   private static int getChange(int m) {
        
		int changeCounter = 0;
		
		while(m > 0){
		
			if(m >= 10){changeCounter++; m -= 10;continue;}
			else if(m >= 5){changeCounter++; m -= 5;continue;}
			else if (m >= 1){changeCounter++; m -= 1;continue;}
		
		}
		
        return changeCounter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }

}