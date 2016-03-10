import java.util.*;

public class Quick{

    public static String name(){
	return "7,Liu,Lawrence";
    }

    public static void printArray(int[]data){
	System.out.print("{");
	for (int i = 0;i<data.length;i++){
	    if (i+1==data.length){
		System.out.print(data[i]);
	    }
	    else{
		System.out.print(data[i]+",");
	    }
	}
	System.out.print("}\n");
    }

    /* Mr. K's partition was better
      private static int partition (int[]data, int left, int right){
	int element = data[(int)(Math.random()*(right-left+1))+left];
	int[]ans = new int[data.length];
	int low = 0;
	int high = ans.length-1;
	
	for (int i=0;i<ans.length;i++){
	    if (data[i]<element){
		ans[low]=data[i];
		low++;
	    }else{
		if (data[i]==element){}
		else{
		    ans[high]=data[i];
		    high--;
		}
	    }
	}
	
	ans[low]=element;
	for (int i=0;i<ans.length;i++){
	    data[i]=ans[i];
	}
	return low;
	}*/

    private static void swap (int[]data, int x, int y){
	int placeholder=data[x];
	data[x]=data[y];
	data[y]=placeholder;
    }

    private static int partition (int[]data, int left, int right){
	int index = (int) (left+Math.random()*(right-left+1));
	int value = data[index];
	swap(data, index, right);
	for (int i=left;i<right;i++){
	    if (data[i]<=value){
		swap(data, left, i);
		left++;
	    }
	}
	swap(data,left,right);
	return left;
    }

    public static int quickSelect (int[]data, int k){
	return quickSelect (data, k, 0, data.length-1);
    }

    public static int quickSelect (int[]data, int k, int left, int right){
	int ans = partition(data, left, right);
	if (left==right){
	    return data[left];
	}else{
	    if (ans<k){
		return quickSelect (data,k,ans+1,right);
	    }else{
		return quickSelect (data,k,left,ans-1);
	    }
	}
    }

    public static void quickSort (int[]data){
	quickSort (data, 0, data.length-1);
    }

    public static void quickSort (int[]data, int left, int right){
	if (Math.abs(left-right)>1){
	    int index = partition (data, left, right);
	    quickSort (data, index+1, right);
	    quickSort (data, left, index-1);
	}
    }

    
    public static void main(String[]args){
	int[]data = {6,-3,2,12,-18,123};
	quickSort(data);
	printArray(data);

    }
}
