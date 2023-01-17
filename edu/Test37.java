package edu;

public class Test37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = { 90, 85, 78, 100, 98};
		int sum = 0;
		double avg = 0.0;
		int max = 0;
		int min = 999;
		
		for(int i=0; i<score.length; i++) {  //for(변수선언 : 배열변수명) {실행문;}   *배열변수는 :
											// for(제어변수 선언 및 초기화 ; 조건식 ; 증감식) { 실행문; }
											// Scope rule(변수의 효력범위): 포문 내에서 선언한 변수 i는 for문 안에서만 작동해서 충돌X
			sum += score[i];
			if (max < score[i]) max=score[i];	//실행문1; if(조건식) {실행문2; } 실행문3;
			if (min > score[i]) min=score[i];
			
		}
		avg=sum/score.length;
		System.out.println("총 점 : " + sum);
		System.out.println("평 균 : " + avg);
		System.out.println("최댓값 : " + max);
		System.out.println("최소값 : " + min);
	}

}
