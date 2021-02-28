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
			if (music[i] > music[i+1]) ascending = false; //���Ͽ� ���������̸� ascending�� false�� ����
			if (music[i] < music[i+1]) descending = false; //���Ͽ� ���������̸� descending�� false�� ����
		}
		
		if (ascending) 
			System.out.println("ascending");
		else if (descending)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}
