package edu;

public class Test39_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[4][4];
		int[][] b = new int[4][4];
		int[][] c = new int[4][4];
		int[][] d = new int[4][4];


//		int num = 1;

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {

				double rnum = Math.random(); //난수생성 0~1사이 실수
				int num = (int) (rnum * 10);
				
				a[i][j] = num;
			}
		}

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				
				double rnum = Math.random(); //난수생성 0~1사이 실수
				int num = (int) (rnum * 10);
				
				b[i][j] = num;
			}
		}
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {

				c[i][j] = a[i][j] + b[i][j];
			}
		}

		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
					int sum = 0;
				for (int k = 0; k < d.length; k++) {
					sum += a[i][k] * b[k][j];
					d[i][j] = sum;
				}

			}
		}
		
	 
		int jang = 0;
		for (int i = 0; i < d.length; i++) {
			jang += a[0][0];
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		System.out.println("\n");

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		System.out.println("\n");

		
		  for(int i = 0; i <c.length; i++) { 
			  for(int j = 0; j < c[i].length; j++) {
				  System.out.print(c[i][j]);
				  System.out.print("\t"); }
			  
			  System.out.println("\n"); 
		 } 
		 System.out.println("\n");
		 

		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j]);
				System.out.print("\t"); // \t 한탭
			}
			System.out.println("\n"); // \n 한줄
		}
		System.out.println(jang);

	}

}
