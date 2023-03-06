package algo;

import java.util.Scanner;

import org.w3c.dom.Node;

//정수를 저정하는 이진트리 만들기 실습
class TreeNode {
	TreeNode LeftChild;
	int data;
	TreeNode RightChild;

	public TreeNode() {
		LeftChild = RightChild = null;
	}

	TreeNode(int data) {
		this.data = data;
		this.LeftChild = null;
		this.RightChild = null;
	}

	int getdata() {
		return data;
	}
}

class Tree {
	TreeNode root;

	Tree() {
		root = null;
	}

	// 자식 노드가 없으면 true
	boolean isLeafNode(TreeNode current) {
		if (current.LeftChild == null && current.RightChild == null)
			return true;
		else
			return false;
	}

	void inorder() {
		inorder(root);
	}

	void preorder() {
		preorder(root);
	}

	void postorder() {
		postorder(root);
	}

	void inorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			inorder(CurrentNode.LeftChild);
			System.out.print(" " + CurrentNode.data);
			inorder(CurrentNode.RightChild);
		}
	}

	void preorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			System.out.print(CurrentNode.data + " ");
			preorder(CurrentNode.LeftChild);
			preorder(CurrentNode.RightChild);
		}
	}

	void postorder(TreeNode CurrentNode) {
		if (CurrentNode != null) {
			postorder(CurrentNode.LeftChild);
			postorder(CurrentNode.RightChild);
			System.out.print(CurrentNode.data + " ");
		}
	}

	boolean insert(int x) {// binary search tree를 만드는 입력 => A + B * C을 tree로 만드는 방법: 입력 해결하는 알고리즘 작성 방법을
							// 설계하여 구현
		TreeNode p = root;
		TreeNode q = p;
		TreeNode newNode = new TreeNode(x);
		int mode = 0;

		if (p == null) {
			root = newNode;
			return true;
		}
		while (p != null) {
			if (p.getdata() == x)
				return false;
			else if (p.getdata() > x) {
				q = p;
				p = p.LeftChild;
				mode = 1;
			} else {
				q = p;
				p = p.RightChild;
				mode = 2;
			}

		}
		if (mode == 1)
			q.LeftChild = newNode;
		else
			q.RightChild = newNode;
		return true;

	}

	TreeNode inorderSucc(TreeNode current) {
		TreeNode temp = current.RightChild;
		if (current.RightChild != null)
			while (temp.LeftChild != null)
				temp = temp.LeftChild;
		return temp;
	}

	boolean delete(int num) {
		TreeNode p = root, q = null;
		int branchMode = 0; // 1은 left, 2는 right

		while (true) {
			if (p == null)
				return false;
			else if (p.getdata() == num)
				break;
			else {
				q = p;
				if (p.getdata() > num) {
					branchMode = 1;
					p = p.LeftChild;
				} else if (p.getdata() < num) {
					branchMode = 2;
					p = p.RightChild;
				}
			}
		}

		if (p.LeftChild == null) {
			if (p == root)
				root = p.RightChild;
			else if (branchMode == 1)
				q.LeftChild = p.RightChild;
			else if (branchMode == 2)
				q.RightChild = p.RightChild;
		} else if (p.RightChild == null) {
			if (p == root)
				root = p.LeftChild;
			else if (branchMode == 1)
				q.LeftChild = p.LeftChild;
			else if (branchMode == 2)
				q.RightChild = p.LeftChild;
		} else {
			
			TreeNode right = inorderSucc(p);	//오른쪽 제일큰 값
			p= right;

		}

		return false;

	}

	boolean search(int num) {
		TreeNode p = root;
		while (true) {
			if (p == null)
				return false;
			else if (p.getdata() == num)
				return true;
			else if (p.getdata() > num) {
				p = p.LeftChild;
			} else if (p.getdata() < num) {
				p = p.RightChild;
			}

		}

	}

}

public class BinaryTree_int {
	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("표시"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {
		Scanner stdIn = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values())
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
			System.out.print(" : ");
			key = stdIn.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Tree t = new Tree();
		Menu menu; // 메뉴
		int count = 0;
		int num;
		boolean result;
		do {
			switch (menu = SelectMenu()) {
			case Add: // 노드 삽입
				System.out.println("The number of items = ");

				count = stdIn.nextInt();
				int[] input = new int[10];
				for (int ix = 0; ix < count; ix++) {
					double d = Math.random();
					input[ix] = (int) (d * 30);
				}
				for (int i = 0; i < count; i++) {
					if (t.insert(input[i]) == false)
						System.out.println("Insert Duplicated data");
				}
				break;

			case Delete: // 노드 삭제 - 어렵다: 난이도 상
				System.out.println("삭제할 데이터:: ");
				num = stdIn.nextInt();
				t.delete(num);
				break;

			case Search: // 노드 검색
				System.out.println("검색할 데이터:: ");

				num = stdIn.nextInt();
				result = t.search(num);
				if (result == true)
					System.out.println(" 데이터 = " + num + "존재합니다.");
				else
					System.out.println("해당 데이터가 없습니다.");
				break;

			case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
				t.inorder();
				System.out.println();
				break;
			}
		} while (menu != Menu.Exit);
	}

}
