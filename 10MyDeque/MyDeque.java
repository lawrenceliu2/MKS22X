import java.util.*;

public class MyDeque{
    private Object[] data;
    private int size, start, end;

    public MyDeque(){
	data = new Object[10];
    }

    public String toString(){
	String ans = "[";
	for (int i=0;i<data.length;i++){
	    if (i == data.length-1){
		ans+=data[i];
	    }else{
		ans+=data[i]+", ";
	    }
	}
	ans+="]";
	return ans;
    }

    public static int size(){
	return size;
    }

    public static void grow(){
	Object[] newData = new Object[size()*2];
	for (int i=0;i<data.length;i++){
	    newData[i]=data[i];
	}
	data=newData;
    }

    public boolean add(Object value){
	if (size()==data.length){
	    grow();
	}
	data[end+1]=value;
	end++;
	size++;
    }

}
