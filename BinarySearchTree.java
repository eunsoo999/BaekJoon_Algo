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
		
		//key를 갖는 노드t를 탐색
		while (t != null && t.data != id) {
			p = t;
			if (t.data < id) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		//while문이 종료된 시점에서 t == null이라면 해당 id가 tree에 없음
		if (t == null) {
			System.out.println("해당 값이 트리에 없습니다.");
			return false;
		}
		
		//case 1 : 자식노드가 없는 단말노드인 경우
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
		//case 2 : 자식노드가 1개인 경우
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
		//case 3 : 자식노드가 2개일 경우
		else {
			//t의 오른쪽 서브트리에서 후계자(가장 작은 값)을 찾는다.
			succ_p = t;
			succ = t.right;
			//후계자를 찾아 계속 왼쪽으로 이동
			while(succ.left != null) {
				succ_p = succ;
				succ = succ.left;
			}
			//후속자의 부모와 자식을 연결
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
	
	//노드 삽입
	public void insert(int data){
		Node newNode = new Node(data);
		Node t = root;
		Node p = null;
		
		while (t != null) {
			if (t.data == data) return; //이미 트리에 해당 값이 있으면 삽입불가
			p = t;
			if (t.data < data) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		
		//data가 Tree에 없으므로 삽입이 가능
		//부모 노드와 연결
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