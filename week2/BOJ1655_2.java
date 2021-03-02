package week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1655_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //최소힙 (1,2,3)
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder()); //최대힙 (30, 20, 10)
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (minHeap.size() == maxHeap.size()) {
				maxHeap.add(num);
			} else {
				minHeap.add(num);
			}
			
			if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
				if (maxHeap.peek() > minHeap.peek()) {
					int temp = maxHeap.poll();
					maxHeap.add(minHeap.poll());
					minHeap.add(temp);
				}	
			}
			bw.write(String.valueOf(maxHeap.peek()) + "\n");
		}
		bw.flush();
		bw.close();
	}
}
//bw.write("전체 " + maxHeap.toString() + " | " + minHeap.toString() + "중앙 " + String.valueOf(maxHeap.peek()) + "\n");
//
