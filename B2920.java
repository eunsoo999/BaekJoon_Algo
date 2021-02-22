import java.util.Scanner;

public class B2920 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		int[] music = new int[8];
		
		boolean ascending = true;
		boolean descending = true;
		
		for (int i = 0; i < 8; i++) {
			music[i] = scan.nextInt();
		}
		
		for (int i = 0; i < 7; i++) {
			if (music[i] > music[i+1]) ascending = false; //비교하여 내림차순이면 ascending을 false로 변경
			if (music[i] < music[i+1]) descending = false; //비교하여 오름차순이면 descending을 false로 변경
		}
		
		if (ascending) 
			System.out.println("ascending");
		else if (descending)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
