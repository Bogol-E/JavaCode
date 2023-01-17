package edu;

public class Test38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = new int[5][5];
		int num = 1;
		for(int i = 0; i <arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				arr[i][j] = num++;
			}
		}
		
		int sum=0;
				
		for(int i = 0; i <arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(i>=j) sum= sum + arr[i][j];
			}			
		}
		
		for(int i = 0; i <arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
				System.out.print("\t");		// \t 한탭
			}
			System.out.println("\n");		// \n 한줄
		}
		
		System.out.print("합 계 : " + sum);
	}

}
