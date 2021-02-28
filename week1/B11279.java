
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;

public class B11279 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> output = new ArrayList<>();
		Heap heap = new Heap(n);
		
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) {
				output.add(heap.maxPop());
			} else {
				heap.insert(input);
			}
		}
		
		for (int num : output) 
			System.out.println(num);
	}
}

class Heap {
	int[] heap;
	int size;
	int maxSize;
	
	public Heap(int maxSize) {
		size = 0;
		heap = new int[maxSize + 1];
		heap[0] = Integer.MAX_VALUE;
	}
	
	public void insert(int key) {
		int i = ++size;
		while (i != 1 && key > heap[i / 2]) {
			heap[i] = heap[i / 2];
			i /= 2;
		}
		heap[i] = key;
	}
	
	public int maxPop() {
		if (size == 0) return 0;
		
		int max = heap[1];
		
		int temp = heap[size--];

		int parent = 1;
		int child = 2;
		
		while (child <= size) {
			if (child < size && heap[child] < heap[child + 1]) {
				child++;
			} 
			
			if (temp < heap[child]) {
				heap[parent] = heap[child];
				parent = child;
				child *= 2;
			} else {
				break;
			}
		}
		heap[parent] = temp;
		return max;
	}
}
