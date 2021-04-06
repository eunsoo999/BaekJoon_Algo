package week6;

import java.util.Scanner;

public class BOJ7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer st = new StringBuffer();
		
		int N = sc.nextInt();
		Body[] people = new Body[N];
		
		for (int i = 0; i < N; i++) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			people[i] = new Body(w, h);
		}
		
		for (int i = 0; i < N; i++) {
			int rank = 1;
			for (int j = 0; j < N; j++) {		
				if (people[i].weight < people[j].weight && people[i].height < people[j].height) {
					rank++;
				}
			}
			st.append(rank + " ");
		}
		
		System.out.println(st.toString());
		
		
		
		
	}
}

class Body {
	int weight;
	int height;
	
	public Body(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
}
