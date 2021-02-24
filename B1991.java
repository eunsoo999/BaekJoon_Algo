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
		      자바 toCharArray() 메소드는 문자열을 char형 배열로 바꾼다.
			이 메서드는 새롭게 만들어진 문자 배열을 리턴한다.
			String 형 변수.toCharArray() - 문자열을 char 형 배열로 바꾼다.
			new String(배열) - char형 배열을 문자열로 바꾼다.
			
			replaceAll("", "") 
			함수는 대상 문자열을 원하는 문자값으로 변환하는 함수이다.
			첫번째 매개변수는 변환하고자 하는 대상이 될 문자열
			두번째 매개변수는 변환할 문자 값
		여기서는 replaceAll(" ", "")을 사용하여 공백을 없앴음.
		그 후 toCharArray()를 이용해 문자열을 char형 배열로 바꾸어 주었음.
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
