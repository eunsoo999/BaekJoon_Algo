package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class BOJ1920_¼öÃ£±â {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Integer> hashset = new HashSet<Integer>();

		int n = Integer.parseInt(br.readLine());
		String[] nItem = br.readLine().split(" ");
		
		for (int i = 0; i < n; i++) {
			hashset.add(Integer.parseInt(nItem[i]));
		}
		
		int m = Integer.parseInt(br.readLine());
		String[] mItem = br.readLine().split(" ");
		
		for (int i = 0; i < m; i++) {
			if (hashset.contains(Integer.parseInt(mItem[i]))) {
				bw.write("1");
			} else {
				bw.write("0");
			}
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}