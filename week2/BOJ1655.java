package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1655 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //최소힙 (1,2,3)
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); //최대힙 (30, 20, 10)
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (minHeap.size() == maxHeap.size()) {
				if (minHeap.size() == 0) {
					maxHeap.add(num);
				} else {
					if (num < minHeap.peek()) {
						maxHeap.add(num);
					} else if (num > minHeap.peek()) {
						minHeap.add(num);
						maxHeap.add(minHeap.poll());
					} else {
						maxHeap.add(num);
					}
				}
			} else {
				if (num < maxHeap.peek()) {
					maxHeap.add(num);
					minHeap.add(maxHeap.poll());
				} else  {
					minHeap.add(num);
				} 
			}
			bw.write(String.valueOf(maxHeap.peek()) + "\n");
			bw.flush();
		}
		bw.close();
	}
}

//bw.write("전체 " + maxHeap.toString() + " | " + minHeap.toString() + "중앙 " + String.valueOf(maxHeap.peek()) );
