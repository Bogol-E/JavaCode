package algo;

class Stack2 {
	private int top = 0;
	private int[] data;

	public Stack2(int cap) {
		this.data = new int[cap];
	}

	public boolean isEmpty() {
		if (top == 0)
			return true;
		else
			return false;
	}

	public void push(int i) {
		data[top++] = i;
	}

	public int pop() {
		return data[--top];
	}
}

public class Chap6_Test_QuickSort {

//퀵 정렬(비재귀 버전)

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) {

		Stack2 ls = new Stack2(right - left + 1);
		Stack2 rs = new Stack2(right - left + 1);
		ls.push(left);
		rs.push(right);

		while (ls.isEmpty() != true) {
			int l = left = ls.pop();
			int r = right = rs.pop();
			int p = a[(left + right) / 2];
			do {
				while (a[l] < p)
					l++;
				while (a[r] > p)
					r--;
				if (l <= r)
					swap(a, l++, r--);

			} while (l <= r);

			if (left < r) {
				ls.push(left);
				rs.push(r);
			}
			if (l < right) {
				ls.push(l);
				rs.push(right);
			}
		}

	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[10];
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
