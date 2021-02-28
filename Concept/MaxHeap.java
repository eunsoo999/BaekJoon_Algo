public class MaxHeap { 
    private int[] Heap; 
    private int size; //Heap �迭�� ��� ����
    private int maxsize; //�ִ� ����Ʈ�� ����� ����
  
    public MaxHeap(int maxsize) 
    { 
        this.maxsize = maxsize;
        this.size = 0; 
        Heap = new int[this.maxsize + 1];
        Heap[0] = Integer.MAX_VALUE;  //2147483647
        //Heap�迭�� ���Ǹ� ���� �ε��� 1������ �����Ѵ�. 
    } 

    public void insert(int element) 
    { 
    	int i; //���� ũ�� ������ �ε���
    	
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
  
    // �ִ밪(root)�� �����Ѵ�.(���� �� ��ȯ)
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
    		preorder(root * 2); //�����ڽĳ���
    		preorder(root * 2 + 1); //������ �ڽ� ����
    	}
    }
    
    public int find(int root, int key) {
    	if (root > size) return 0; //�� �ȿ� key�� ����.
    	
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
        System.out.print("������ȸ : ");
        maxHeap.preorder(1);
        System.out.println();
        int findIndex = maxHeap.find(1, 6);
        if (findIndex == 0) {
        	System.out.println("�ش� key�� ���� �����ϴ�.");
        } else {
        	System.out.println(findIndex + "��° �ε����� �����մϴ�.");
        }
    } 
}