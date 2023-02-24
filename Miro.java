package algo;

class Point {
	private int x;
	private int y;


	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
	
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}

class Stack {
	private int top;
	private Point[] data;

	public Stack() {
		top = 0;
		data = new Point[100];
	}

	public boolean isEmpty() {
		if (top == 0)
			return true;
		else
			return false;
	}

	public void push(Point p) {
		data[top++] = p;
	}

	public Point pop() {
		return data[--top];
	}
}

public class Miro {

	public static void main(String[] args) {
		int[][] input = { { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 }, { 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 }, { 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 }, { 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 }, };

		solveMiro(input);

	}

	private static void solveMiro(int[][] array) {
		int[][] miro = new int[array.length + 2][array[0].length + 2];

		for (int i = 0; i < miro.length; i++) {
			for (int j = 0; j < miro[0].length; j++) {
				miro[i][j] = 1;
			}
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				miro[i + 1][j + 1] = array[i][j];
			}
		}

		int[][] mark = new int[array.length+2][array[0].length + 2];

		print(miro);

		
		
		
		
		
		
	}

	private static void print(int[][] ary) {
		for (int i = 0; i < ary.length; i++) {
			for (int j = 0; j < ary[0].length; j++) {
				System.out.print(ary[i][j] + " ");
			}
			System.out.println();
		}
	}

}
