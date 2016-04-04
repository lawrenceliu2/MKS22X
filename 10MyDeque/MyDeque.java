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
	ans+="]\nSize: "+size+"\nStart: "+start+"\nEnd: "+end;
	return ans;
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
	int count = start;
	T val = data[count];
	data[count]=value;
	count++;
	for (int i=0;i<size;i++){
	    if (count==data.length){
		count=0;
	    }
	    value=data[count];
	    data[count]=val;
	    count++;
	    val=value;
	}
	size++;
	if (size!=1){
	    end++;
	}
    }

    public void addLast (T value){
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

    public T removeFirst(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	T ans = data[start];
	int count=start;
	for (int i=0;i<size-1;i++){
	    if (count==data.length-1){
		data[count]=data[0];
		count=0;
	    }else{
		data[count]=data[count+1];
		count++;
	    }
	}
	size--;
	if (end==0){
	    end=data.length;
	}
	end--;
	return ans;
    }

    public T removeLast(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	T ans = data[end];
	size--;
	if (end==0){
	    end=data.length;
	}
	end--;
	return ans;
    }

    public T getFirst(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	return data[start];
    }

    public T getLast(){
	if (size==0){
	    throw new NoSuchElementException();
	}
	return data[end];
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
        blah.addLast(6);
	blah.addLast(7);
	blah.addLast(8);
	blah.addLast(9);
	blah.removeLast();
	blah.addLast(99);
	System.out.println(blah);
	System.out.println(blah.getFirst());
	System.out.println(blah.getLast());
    }
}
