public class KnightBoard{
    private int[][]board;

    public KnightBoard (int size){
	board = new int[size][size];
    }

    public void printSolution (){
	for (int i=0;i<board.length;i++){
	    for (int k=0;k<board[i].length;k++){
		if (board.length*board.length>=10){
		    if (board[i][k]<10){
			System.out.print(" "+board[i][k]+" ");
		    }
		}else{
		    System.out.print(board[i][k]+" ");
		}
	    }
	    System.out.print("\n");
	}
    }

    public boolean solve (){
	
    }
}
