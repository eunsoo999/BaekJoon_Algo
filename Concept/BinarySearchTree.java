public class BinarySearchTree {
	public static  Node root;
	public BinarySearchTree(){
		this.root = null;
	}
	
	
	public boolean find(int id){
		Node current = root;
		while(current!=null){
			if(current.data==id){
				return true;
			}else if(current.data>id){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	
	public boolean delete(int id){
		Node p = null;
		Node t = root;
		Node succ_p = null;
		Node succ = null;
		Node child = null;
		
		//key�� ���� ���t�� Ž��
		while (t != null && t.data != id) {
			p = t;
			if (t.data < id) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		//while���� ����� �������� t == null�̶�� �ش� id�� tree�� ����
		if (t == null) {
			System.out.println("�ش� ���� Ʈ���� �����ϴ�.");
			return false;
		}
		
		//case 1 : �ڽĳ�尡 ���� �ܸ������ ���
		if (t.left == null && t.right == null) {
			if (p != null) {
				if (p.left == t) {
					p.left = null;
				} else {
					p.right = null;
				}
			} else {
				root = null;
			}
		}
		//case 2 : �ڽĳ�尡 1���� ���
		else if (t.left == null || t.right == null ) {
			if (t.left != null) {
				child = t.left;
			} else {
				child = t.right;
			}
			
			if (p != null) {
				if (p.left == t) {
					p.left = child;
				} else {
					p.right = child;
				}
			} else {
				root = child;
			}
		}
		//case 3 : �ڽĳ�尡 2���� ���
		else {
			//t�� ������ ����Ʈ������ �İ���(���� ���� ��)�� ã�´�.
			succ_p = t;
			succ = t.right;
			//�İ��ڸ� ã�� ��� �������� �̵�
			while(succ.left != null) {
				succ_p = succ;
				succ = succ.left;
			}
			//�ļ����� �θ�� �ڽ��� ����
			if (succ_p.left == succ) {
				succ_p.left = succ.right;
			} else {
				succ_p.right = succ.right;
			}
			
			t.data = succ.data;
			t = succ;
		}
		return true;
	}
	
	//��� ����
	public void insert(int data){
		Node newNode = new Node(data);
		Node t = root;
		Node p = null;
		
		while (t != null) {
			if (t.data == data) return; //�̹� Ʈ���� �ش� ���� ������ ���ԺҰ�
			p = t;
			if (t.data < data) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		
		//data�� Tree�� �����Ƿ� ������ ����
		//�θ� ���� ����
		if (p != null) {
			if (p.data < data) {
				p.right = newNode;
			} else {
			p.left = newNode;
		}
		} else {
			root = newNode;
		}
	}
	
	public void display(Node root){
		if(root != null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	public static void main(String arg[]){
		BinarySearchTree b = new BinarySearchTree();
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		System.out.println("Check whether Node with value 4 exists : " + b.find(4));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(root);
	}
}

class Node{
	int data;
	Node left;
	Node right;	
	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}