import java.util.*;

public class Quick{

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

    public static int partition (int[]data, int left, int right){
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
    }

    public static int quickselect (int[]data, int k){
	return quickselect (data, k, 0, data.length-1);
    }

    public static int quickselect (int[]data, int k, int left, int right){
	int ans = partition(data, left, right);
	if (ans==k){
	    return data[k];
	}else{
	    if (ans<k){
		return quickselect (data,k,ans+1,right);
	    }else{
		return quickselect (data,k,left,ans-1);
	    }
	}
    }

    
    public static void main(String[]args){
	int[]data = {6,-3,2,12,-18,123};
	System.out.println(quickselect(data,1));
	printArray(data);
	System.out.println(quickselect(data,2));
	printArray(data);
	System.out.println(quickselect(data,3));
	printArray(data);
	System.out.println(quickselect(data,4));
	printArray(data);
	System.out.println(quickselect(data,5));
	printArray(data);
    }
}
