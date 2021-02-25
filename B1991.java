import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1991 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		char data[] = new char[3];
		
		for (int i = 0; i < n; i++) {
			data = br.readLine().replaceAll(" ", "").toCharArray();
			tree.add(data[0], data[1], data[2]);
		}
		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
		br.close();

			/*
			toCharArray()
		      �ڹ� toCharArray() �޼ҵ�� ���ڿ��� char�� �迭�� �ٲ۴�.
			�� �޼���� ���Ӱ� ������� ���� �迭�� �����Ѵ�.
			String �� ����.toCharArray() - ���ڿ��� char �� �迭�� �ٲ۴�.
			new String(�迭) - char�� �迭�� ���ڿ��� �ٲ۴�.
			
			replaceAll("", "") 
			�Լ��� ��� ���ڿ��� ���ϴ� ���ڰ����� ��ȯ�ϴ� �Լ��̴�.
			ù��° �Ű������� ��ȯ�ϰ��� �ϴ� ����� �� ���ڿ�
			�ι�° �Ű������� ��ȯ�� ���� ��
		���⼭�� replaceAll(" ", "")�� ����Ͽ� ������ ������.
		�� �� toCharArray()�� �̿��� ���ڿ��� char�� �迭�� �ٲپ� �־���.
			 */
		}
		
	}

class Node{
	char data;
	Node left;
	Node right;	
	
	public Node(char data){
		this.data = data;
		left = null;
		right = null;
	}
}

class Tree {
	Node root;
	
	public void add(char data, char leftData, char rightData) {
		if (root == null) {
			if (data != '.')
				root = new Node(data);
			if (leftData != '.')
				root.left = new Node(leftData);
			if (rightData != '.')
				root.right = new Node(rightData);
		} else {
			search(root, data, leftData, rightData);
		}
	}
	
	public void search(Node root, char data, char leftData, char rightData) {
		if (root == null) return;
		else if (root.data == data) {
			if (leftData != '.') root.left = new Node(leftData);
			if (rightData != '.') root.right = new Node(rightData);
		} else {
			search(root.left, data, leftData, rightData);
			search(root.right, data, leftData, rightData);
		}
	}
	
	public void preorder (Node root) {
		System.out.print(root.data);
		if (root.left != null) {
			preorder(root.left);
		}
		if (root.right != null) {
			preorder(root.right);
		}
	}
	
	public void inorder(Node root) {
		if (root.left != null) {
			inorder(root.left);
		}
		System.out.print(root.data);
		if (root.right != null) {
			inorder(root.right);
		}
	}
	
	public void postorder(Node root) {
		if (root.left != null) {
			postorder(root.left);
		}
		if (root.right != null) {
			postorder(root.right);
		}
		System.out.print(root.data);
	}
}