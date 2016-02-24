import java.util.*;
import java.io.*;

public class Bronze{
    private int[][]field;

    public Bronze(int row, int col){
	field=new int[row][col];
    }

    public void add (int row, int col, int n){
	field[row][col]=n;
    }

    public int getHeight (int row, int col){
	return field[row][col];
    }

    
    public static void main(String[]args){
	try{
	Scanner s = new Scanner(new File("makelane.in"));
	int rows = s.nextInt();
	int cols = s.nextInt();
	int elevation = s.nextInt();
	int instructions = s.nextInt();
	Bronze lake = new Bronze(rows, cols);
	
	for (int i = 0;i<rows;i++){
	    for (int k = 0;k<cols;k++){
		lake.add(i,k,s.nextInt());
	    }
	}

        for (int i=0;i<instructions;i++){
	        int row=s.nextInt()-1;
		int col=s.nextInt()-1;
		int inches=s.nextInt();
	        lake.add(row,col,lake.getHeight(row,col)-inches);
		for (int x=row; x<row+3;x++){
		    for (int k=col;k<col+3;k++){
			if (lake.getHeight(x,k)>lake.getHeight(row,col)){
			    lake.add(x,k,lake.getHeight(row,col));
			}
		    }
		}
	    }


	for (int i = 0;i<rows;i++){
	    for (int k = 0;k<cols;k++){
		if (lake.getHeight(i,k)<elevation){
		    lake.add(i,k,elevation-lake.getHeight(i,k));
		}else{
		    lake.add(i,k,0);
		}
	    }
	}

	int total=0;
	for (int i = 0;i<rows;i++){
	    for (int k = 0;k<cols;k++){
		if (lake.getHeight(i,k)>0){
		    total+=lake.getHeight(i,k);
		}
	    }
	}
	int volume = total*72*72;

	System.out.println(volume+", 7, Liu, Lawrence");
	}
	
	catch (FileNotFoundException e){
	    System.out.println(e);
	}
    }
}
