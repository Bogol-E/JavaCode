package edu;

public class Test36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char letter = 'A';
		char[] alphabet =new char[130];
		
		for(int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char) (letter +i); //char 타입 캐스팅 뒤에 괄호 묶어줄것
		}
		for(char c : alphabet) {
			System.out.print(" " + c);
		}
	}

}
