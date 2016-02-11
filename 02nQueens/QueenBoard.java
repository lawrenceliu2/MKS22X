public class QueenBoard{
    private int[][]board;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *postcondition: 
     *-return false, and board is still filled
     *with 0's for a board that cannot be solved.
     *-return true, and board is filled with the 
     *final configuration of the board after adding 
     *all n queens.
     */
    public boolean solve(){
	return solveH(0);
    }
    
    private boolean solveH(int col){
	int row = 0;
	boolean queened = false;

	while (!queened&&row<board.length){
	    if (addQueen(row,col)){
		queened = true;
		//If the queen is added properly, then we stop trying to add queens and begin testing
	    }
	    row++;
	}

	if (col==0 && row==board.length-1){return false;}

	if (col==board[0].length-1){
	    //If we reached the end of the cols
	    for (int i = 0;i<board.length;i++){
		for (int k = 0;k<board[i].length;k++){
		    if (board[i][k]!=0){return true;}
		    //and if there is anything that isnt a 0, then the board is solved.
		}
	    }
	    return false;
	    //Otherwise, the board is still filled with 0s and cannot be solved.
	}

	if (row==board.length-1 && !queened){
	    //If we reached the end of the row and there has been no queen added still, then there are no possible queens placable in this row. Thus, we must backtrack and remove the last queen.
	    for (int i = 0;i<board.length;i++){
		if (board[row-1][i]==1){queened = !removeQueen(row-1,i);}
	    }
	    return solveH(col-1);
	}

	return solveH(col+1);	    
    }

    public void printSolution(){
	/**Print the board like toString, except
	   all negative numbers, and 0's are replaced with '_'
	   and all 1's are replaced with 'Q'
	 */
	for (int i = 0;i<board.length;i++){
	    for (int k=0;k<board[i].length;k++){
		if (board[i][k]==1){
		    System.out.print("Q ");
		}else{
		    System.out.print("_ ");
		}
	    }
	    System.out.print("\n");
	}
    }

    /********Do Not Edit Below This Line**********************************/

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if(board[row][col] != 1){
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]++;
	    if(row - offset >= 0){
		board[row-offset][col+offset]++;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }

    public String  toString(){
	String ans = "";
	for(int r = 0; r < board.length; r++){
	    for(int c = 0; c < board[0].length; c++){
		ans+= board[r][c]+"\t";
	    }
	    ans+="\n";
	}
	return ans;
    }
    
    public static void main(String[]args){
	QueenBoard b = new QueenBoard(3);
	b.printSolution();
	System.out.println(b.solve());
	b.printSolution();
    }
    
    
}
