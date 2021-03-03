package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ2805 {
	static long maxHeight; // 필요한 길이로 딱 떨어지지 않는 경우도 있으므로, 필요한 길이를 충분히 확보했으면 나무를 더 적게 자를 수 있는지 확인해야함.

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] cut = br.readLine().split(" ");
		
		int n = Integer.parseInt(cut[0]); // 나무 개수
		int m = Integer.parseInt(cut[1]); // 필요한 길이
		
		String[] treeStr = br.readLine().split(" ");
		int[] tree = new int[n];
		
		for (int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(treeStr[i]); 
		}
		
		Arrays.sort(tree);
		
		getTree(tree, 0, tree[tree.length - 1], m); // 가장 긴 나무 길이 = 20
		
		bw.write(String.valueOf(maxHeight));
		bw.flush();
		bw.close();
	}
	
	// 해당 높이에 잘린 나무 길이
	public static long cutTree(int[] tree, long height) {
		long sum = 0;
		
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] > height)
				sum += tree[i] - height;
		}
		return sum;
	}
	
	public static void getTree(int[] tree, long start, long end, int required) {
		if (start > end) {
			return;
		}
		
		long mid = (start + end) / 2;
		long sum = cutTree(tree, mid);
		
		if (sum < required) {
			// 길이가 부족하면 나무 밑으로 더 잘라야함.
			getTree(tree, start, mid - 1, required);
		} else {
			// 이미 충분은 하지만 환경을 위해 조금 자를 수 있는지 확인
			maxHeight = Math.max(mid, maxHeight); // 이전이 충분했다면, 이전꺼와 이번 것 중 어느게 더 적게 자르는지 (더 높은 숫자로 자를 수록 개수 적음)
			getTree(tree, mid + 1, end, required);
		}	
	}
}
