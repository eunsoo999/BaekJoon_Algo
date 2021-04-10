package week6;

public class Backtracking_NQueen {
	
	public static void main(String[] args) {
		int N = 5;
		int candidate[] = new int[N];
		DFS(N, 0, candidate);
	}
	
	// DFS(N, 현재 행, 현재 선택된 퀸 후보자)
	public static void DFS(int N, int current_row, int[] current_candidate) {
		if (current_row == N) { //N개의 퀸을 배치했다면 결과 출력
			for (int q : current_candidate) {
				System.out.print(q + " ");
			}
			System.out.println();
			return;
		}
		
		//퀸 배치
		for (int i = 0; i < N; i++) {
			if (is_available(current_candidate, current_row, i)) {
				current_candidate[current_row] = i;
				DFS(N, current_row + 1, current_candidate);
			}
		}
	}
	
	//퀸 배치 조건 확인
	public static boolean is_available(int[] candidate, int current_row, int current_col) {
		for (int i = 0; i < current_row; i++) {
			if (candidate[i] == current_col 
					|| Math.abs(candidate[i] - current_col) == Math.abs(current_row - i)) {
				//각 행의 퀸들의 y값과 같거나 || | 각 행의 퀸의 y값 - 현재 y위치 | == | 현재 x위치 - 각 행의 퀸 x값 |  
				return false;
			}
		}
		return true;
	}
}
