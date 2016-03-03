import java.io.*;
import java.util.*;

public class Silver{
    int[][] pasture;

    public Silver(int row, int col){
	pasture = new int[row][col];
    }

    public void add (int row, int col, int n){
	pasture[row][col]=n;
    }

    public int get (int row, int col){
	return pasture[row][col];
    }

    public static void solve(){
	try{
	    Scanner s = new Scanner(new File("ctravel.in"));
	    int rows = s.nextInt();
	    int cols = s.nextInt();
	    int seconds = s.nextInt();
	    Silver field = new Silver(rows, cols);

	    for (int i = 0;i<rows;i++){
		String next=s.next();
		for (int k = 0;k<cols;k++){
		    if (next.charAt(k)=='.'){
			field.add(i,k,0);
		    }else{
			field.add(i,k,-1);
		    }
		}
	    }

	    int startrow = s.nextInt()-1;
	    int startcol = s.nextInt()-1;
	    int endrow = s.nextInt()-1;
	    int endcol = s.nextInt()-1;

	    for (int x=0;x<seconds;x++){
		for (int i=0;i<rows;i++){
		    for (int k=0;k<cols;k++){
			if (field.get(i,k)>0){
			    helper(i,k,rows,cols,field);
			}
		    }
		}

		for (int y=0;y<rows;y++){
		    for(int z=0;z<cols;z++){
			if (field.get(y,z)<-1){
			    field.add(y,z,-1*field.get(y,z)/2);
			}
		    }
		}
	    }
	    
	    System.out.println(field.get(endrow,endcol)+", 7, Liu, Lawrence");
	}
	catch (FileNotFoundException e){
	    System.out.println(e);
	}
    }

    public static void helper (int row, int col, int rows, int cols, Silver field){
	if ((field.get(row+1,col)>=0||field.get(row+1,col)<=-2)&&row<rows-1) {
	    field.add(row+1,col,field.get(row+1,col)+(-2*field.get(row,col)));
	}
	
	if ((field.get(row-1,col)>=0||field.get(row-1,col)<=-2)&&row>0){
	    field.add(row-1,col,field.get(row-1,col)+(-2*field.get(row,col)));
	}
	
	if ((field.get(row,col+1)>=0||field.get(row,col+1)<=-2)&&col<cols-1){
	    field.add(row,col+1,field.get(row,col+1)+(-2*field.get(row,col)));
	}

	if ((field.get(row,col-1)>=0||field.get(row,col-1)<=-2)&&col>0){
	    field.add(row,col-1,field.get(row,col-1)+(-2*field.get(row,col)));
	}
	
	field.add(row,col,0);
    }



    public String toString(){
	String ans = "";
	for (int i=0;i<pasture.length;i++){
	    for (int k=0;k<pasture[i].length;k++){
		ans+= pasture[i][k]+" ";
	    }
	    ans+="\n";
	}
	return ans;
    }
    

    public static void main(String[]args){
	solve();
    }
}

