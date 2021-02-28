public class MaxHeap { 
    private int[] Heap; 
    private int size; //Heap 배열의 요소 개수
    private int maxsize; //최대 이진트리 요소의 개수
  
    public MaxHeap(int maxsize) 
    { 
        this.maxsize = maxsize;
        this.size = 0; 
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;  //2147483647
        //Heap배열은 편의를 위해 인덱스 1번부터 시작한다. 
    } 

    public void insert(int element) 
    { 
    	int i; //히프 크기 마지막 인덱스
    	
    	size++;
    	i = size;
    	while (i != 1 && element > Heap[i / 2]) {
    		Heap[i] = Heap[i / 2];
    		i /= 2;
    	}
    	Heap[i] = element;
    } 
  
    public void print() 
    { 
        for (int i = 1; i <= size / 2; i++) { 
            System.out.print( 
                " PARENT : " + Heap[i] 
                + " LEFT CHILD : " + Heap[2 * i] 
                + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        } 
    } 
  
    // 최대값(root)를 추출한다.(제거 및 반환)
    public int extractMax() 
    { 
    	int item = Heap[1];
    	int temp;
    	int p;
    	int c;
    	
    	temp = Heap[size--];
    	
    	p = 1;
    	c = 2;
    	while (c <= size) {
    		if (c < size && Heap[c] < Heap[c + 1]) {
    			c++;
    		}
    		
    		if (Heap[c] <= temp) {
    			break;
    		} else {
    			Heap[p] = Heap[c];
    			p = c;
    			c *= 2;
    		}
    	}
    		Heap[p] = temp;
    		return item;
    }
    
    public void preorder(int root) {
    	if (root <= size) {
    		System.out.print(Heap[root] + " -> ");
    		preorder(root * 2); //왼쪽자식노드로
    		preorder(root * 2 + 1); //오른쪽 자식 노드로
    	}
    }
    
    public int find(int root, int key) {
    	if (root > size) return 0; //힙 안에 key가 없음.
    	
    	if (Heap[root] == key) {
    		return root;
    	} else if (Heap[root] < key) {
    		return 0;
    	} else {
    		return Math.max(find((root * 2), key), find((root * 2 + 1), key));
    	}
    }
  
    public static void main(String[] arg) 
    { 
        System.out.println("The Max Heap is "); 
        MaxHeap maxHeap = new MaxHeap(15); 
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9);
  
        maxHeap.print(); 
        System.out.println("The max val is " + maxHeap.extractMax()); 
        System.out.print("전위순회 : ");
        maxHeap.preorder(1);
        System.out.println();
        int findIndex = maxHeap.find(1, 6);
        if (findIndex == 0) {
        	System.out.println("해당 key가 힙에 없습니다.");
        } else {
        	System.out.println(findIndex + "번째 인덱스에 존재합니다.");
        }
    } 
}