package data2;

public class EightQueens {

	public static void main(String[] args) {
		int[][] data = new int[4][4];
		int[] move = new int[8];
		SolveQueen(data);

	}

	public static void SolveQueen(int[][] data) {
		for (int i = 0; i < data.length; i++) {
			int culcal = 0;
			int culrow = 0;
			while (moved) {
				data[culcal][culrow]=1
				
			}
				
			}

		}

	}



	public static boolean checkMove(int row, int col, int[][] board) {
        for(int i=0; i<row; i++) {
            if(board[i][col] == 1) {
                return false; //check column
            }
            int rowDist = row - i;
            if(col-rowDist >= 0 && board[i][col-rowDist] == 1) {
                return false; //check diagonal SW
            }
            if(col+rowDist < 8 && board[i][col+rowDist] == 1) {
                return false; //check diagonal SE
            }
        }
        return true; //move is valid
    }
//  => 8  Queen 문제 풀기: 스택 사용하여 backtracking 코딩 실습
//    -> 2차원 배열에 0으로 초기화, Queen을 배치하면 1로 설정, 8 X 8 배열에 8개 퀸이 가로 세로 대각선에 충돌이 없으면 성공
//
//    -> stack에 Point 객체를 생성하여 push, pop::(x, y, move) => move는 다음 이동 가능 candidate의 column임

//
//        => backtracking을 stack을 이용하여 push/pop으로 해결하는 것을 보이는 것임
//
//    -> 가로, 세로, 대각선에 대한 충돌 체크 함수 코딩
//     
