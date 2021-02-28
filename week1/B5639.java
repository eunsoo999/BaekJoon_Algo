import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5639 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Tree tree = new Tree();
	
        String input = "";
        while((input = br.readLine()) != null) {
        	int data = Integer.parseInt(input);
            tree.add(tree.root, data);
        }
        tree.postOrder(tree.root);
	}
}

class Tree {
	Node root;
	
	//data »ðÀÔ
	public void add(Node node, int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			if (node.data < data) {
				if (node.right != null) {
					add(node.right, data);
				} else {
					node.right = new Node(data);
				}
			} else {
				if (node.left != null) {
					add(node.left, data);
				} else {
					node.left = new Node(data);
				}
			}
			
		}
	}
	
	public void search(Node root, int data) {
		Node p = null;
		Node t = root;
		Node node = new Node(data);
		
		while (t != null) {
			if (t.data == data) return;
			p = t;
			if (t.data < data) {
				t = t.right;
			} else {
				t = t.left;
			}
		}
		
		if (p != null) {
			if (p.data < data) {
				p.right = node;
			} else {
				p.left = node;
			}
		} else {
			root = node;
		}
	}
	
	public void postOrder(Node root) {
		if (root.left != null) postOrder(root.left);
		if (root.right != null) postOrder(root.right);
		System.out.println(root.data);
	}
}

class Node {
	int data;
	Node left;
	Node right;	
	
	public Node (int data){
		this.data = data;
		left = null;
		right = null;
	}
}
