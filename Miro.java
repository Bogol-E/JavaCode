package algo;

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
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
		data = new Point[35];
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
		int[][] input = 
			{ 
				{ 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 }, 
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
				{ 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
				{ 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 },
				{ 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0 },
				};
		

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

		int[][] mark = new int[array.length][array[0].length];
		
		Stack s = new Stack();
		Point p = new Point(1, 1);
		int x = 1;
		int y = 1;
		miro[x][y]=1;
		boolean noway = true;

		while(x!=array.length || y!=array[0].length) {
			
			if(miro[x][y+1]==1&&miro[x+1][y]==1&&miro[x+1][y+1]==1&&miro[x-1][y]==1&&
					miro[x][y-1]==1&&miro[x-1][y-1]==1&&miro[x-1][y+1]==1&&miro[x+1][y-1]==1) {
				noway=true; p = s.pop();x = p.getX();y = p.getY();};	
			
			if((miro[x][y+1]==0||miro[x+1][y]==0||miro[x+1][y+1]==0||miro[x-1][y]==0||
	        		miro[x][y-1]==0||miro[x-1][y-1]==0||miro[x-1][y+1]==0||miro[x+1][y-1]==0)&&noway==true) {
				s.push(new Point(x,y));noway=false;};
			
			if(miro[x][y+1]==0) { miro[x][++y]=1;  s.push(new Point(x,y));};
	        if(miro[x+1][y]==0) { miro[++x][y]=1;  s.push(new Point(x,y));};
	        if(miro[x+1][y+1]==0) { miro[++x][++y]=1; s.push(new Point(x,y));};
	        if(miro[x][y-1]==0) { miro[x][--y]=1; s.push(new Point(x,y));};
	        if(miro[x-1][y]==0) { miro[--x][y]=1;  s.push(new Point(x,y));};
	        if(miro[x-1][y-1]==0) { miro[--x][--y]=1;  s.push(new Point(x,y));};
	        if(miro[x-1][y+1]==0) {miro[--x][++y]=1;  s.push(new Point(x,y));};
	        if(miro[x+1][y-1]==0) { miro[++x][--y]=1; s.push(new Point(x,y));};
	        
	        
		}
		
		while(!s.isEmpty()) {
			p = s.pop();
			x = p.getX();
			y = p.getY();
			mark[x-1][y-1]=1;
		}
		
                
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
