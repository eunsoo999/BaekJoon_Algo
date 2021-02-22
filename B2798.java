import java.util.Scanner;

public class B2798 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] card = new int[100]; //n이 100은 안넘으니까
		//int[] card = new int[n]; 
		
		for (int i = 0; i < n; i++) {
			card[i] = sc.nextInt();
		}
		
		int best = 0;
		int sum = 0;
		for (int i = 0; i < n - 2; i++) { 
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					sum = card[i] + card[j] + card[k];
					//if (sum <= m && sum > best) {
					//	best = sum;
					//}
					if (sum <= m) best = Math.max(best, sum);
				}
			}
		}
		
		System.out.println(best);
	}

}
