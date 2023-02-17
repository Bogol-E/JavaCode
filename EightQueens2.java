package data2;
import java.awt.Point;
import java.util.Stack;

public class EightQueens2 {
    
    public static void main(String[] args) {
        int[][] board = new int[8][8]; 
        
        for(int k = 0; k<8; k++) {
        	solveQueens(k, board); 
            printBoard(board); 
            System.out.println();
        }
        
    }
    
    public static void solveQueens(int k, int[][] board) {
        Stack<Point> queenStack = new Stack<>();
        int[] moves = new int[8];
        int currentRow = 0;
        
        queenStack.push(new Point(0,0));
        board[0][k] = 1;
        
        while(!queenStack.isEmpty()) {
            Point currentQueen = queenStack.peek();
            int currentColumn = moves[currentRow];
            boolean queenPlaced = false;
            
            while(currentColumn < 8 && !queenPlaced) {
                if(checkMove(currentRow, currentColumn, board)) {
                    queenStack.push(new Point(currentColumn, currentRow));
                    board[currentRow][currentColumn] = 1;
                    moves[currentRow] = currentColumn;
                    queenPlaced = true;
                } else {
                    currentColumn++;
                }
            }
            
            if(!queenPlaced) {
                Point removedQueen = queenStack.pop();
                int x = removedQueen.x;
                int y = removedQueen.y;
                board[y][x] = 0;
                currentRow--;
                moves[currentRow]++;
            } else if(currentRow == 7) {
                //solution found
                return;
            } else {
                currentRow++;
                moves[currentRow] = 0;
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
    
    
    public static void printBoard(int[][] board) {
        for(int i=0; i<8; i++) {
            for(int j=0; j<8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
