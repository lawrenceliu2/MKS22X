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

    private static int partitionOld (int[]data, int left, int right){
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

    public static int quickSelectOld (int[]data, int k){
	return quickSelectOld (data, k, 0, data.length-1);
    }

    public static int quickSelectOld (int[]data, int k, int left, int right){
	int ans = partitionOld(data, left, right);
	if (left==right){
	    return data[left];
	}else{
	    if (ans<k){
		return quickSelectOld (data,k,ans+1,right);
	    }else{
		return quickSelectOld (data,k,left,ans-1);
	    }
	}
    }

    public static void quickSortOld (int[]data){
	quickSortOld (data, 0, data.length-1);
    }

    public static void quickSortOld (int[]data, int left, int right){
	if (left<=right){
	    int index = partitionOld (data, left, right);
	    quickSortOld (data, index+1, right);
	    quickSortOld (data, left, index-1);
	}
    }



    private static int[] partition (int[]data, int left, int right){
	int index = (int) (left+Math.random()*(right-left+1));
	int value = data[index];
	swap(data, index, right);
	for (int i=left;i<right;i++){
	    if (data[i]<=value){
		swap(data, left, i);
		left++;
	    }
	}
	int mid = left+1;
	right = mid;
	swap(data,left,right);
	for (int i=0;i<left;i++){
	    if (data[i]==value){
		swap(data, i, left);
		left--;
	    }
	}
	for (int i=mid;i<right;i++){
	    if (data[i]==value){
		swap(data, i, right);
		right--;
	    }
	}
	int[]ans={left,right};
	return ans;
    }

    public static void quickSort (int[]data){
	quickSort (data, 0, data.length-1);
    }

    public static void quickSort (int[]data, int left, int right){
	if (Math.abs(left-right)>1){
	    int[] index = partition (data, left, right);
	    quickSort (data, index[0], index[1]);
	}
    }

    
    public static void main(String[]args){
	/*int[]data = {6,-3,2,12,-18,123};
	int[]data2 = {6,-3,2,12,-18,123};
	int[]data3 = {6,-3,2,12,-18,123};
	Arrays.sort(data);
	printArray(data);
	quickSortOld(data2);
	printArray(data2);
	//quickSort(data3);
	//printArray(data3);
	int[] d = new int [4000000];
	int[] c = new int [d.length];

	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    c[i]= d[i];
	}

	quickSortOld(d); //or even your old quicksort!!!
	Arrays.sort(c);
	System.out.println("Done: Sorted="+Arrays.equals(d,c));*/
	int[]data = {6,-3,2,12,2,123,2};
	printArray(partition(data,0,data.length-1));
	printArray(data);
    }
}
