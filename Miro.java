package data3;

class Point {
	private int x;
	private int y;
	private int z;

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
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

		int[][] miro = new int[input.length + 2][input[0].length + 2];
		

		for (int i = 0; i < miro.length; i++) {
			for (int j = 0; j < miro[0].length; j++) {
				miro[i][j] = 1;
			}
		}

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				miro[i + 1][j + 1] = input[i][j];
			}
		}

		movemiro(miro);

		

	}

	private static void movemiro(int[][] array) {
		int i = 1;
		int j = 1;
		int[][] mark = new int[array.length][array[0].length + 2];
		
		
		print(mark);

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
