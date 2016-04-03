import java.util.*;

public class MyDeque<T>{
    private T[] data;
    private int size, start, end;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	data = (T[]) new Object[10];
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

    public int size(){
	return size;
    }
    public int start(){
	return start;
    }
    public int end(){
	return end;
    }

    private void grow(){
	T[] newData = (T[]) new Object[data.length*2];
	int count=0;
	for (int i=start;i<data.length;i++){
	    newData[count]=data[i];
	    count++;
	}
	for (int i=0;i<start;i++){
	    newData[count]=data[i];
	    count++;
	}
	start=0;
	end=count-1;
	data=newData;
    }

    public void addFirst (T value){
	if (size==data.length){
	    grow();
	}
	if (end==data.length-1){
	    end=-1;
	}
	data[end+1]=value;
	size++;
	if (size==1){
	    end++;
	    start=end;
	}else{
	    end++;
	}
    }


    public static void main(String[]args){
	MyDeque<Integer> blah = new MyDeque<Integer>();
	System.out.println(blah);
	blah.addFirst(0);
	blah.addFirst(1);
	blah.addFirst(2);
	blah.addFirst(3);
	blah.addFirst(4);
	blah.addFirst(5);
	blah.addFirst(6);
	blah.addFirst(7);
	blah.addFirst(8);
	blah.addFirst(9);
	blah.addFirst(10);
	System.out.println(blah);
	System.out.println(blah.size());
	System.out.println(blah.start());
	System.out.println(blah.end());
    }
}
