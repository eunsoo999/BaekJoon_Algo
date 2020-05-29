import java.util.Scanner;

public class Baek1453 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean[] seat = new boolean[101];
		int backCnt = 0;
		
		for (int i = 0; i < seat.length; i++) {
			seat[i] = false;
		}

		int customerCount = sc.nextInt();
		int customerNum;
	
		for(int i = 0; i < customerCount; i++) {
			customerNum = sc.nextInt();
		
			if(seat[customerNum] == false) {
				seat[customerNum] = true;
			}
			else {
				backCnt++;
			}
		}
			System.out.print(backCnt);
	}
}
