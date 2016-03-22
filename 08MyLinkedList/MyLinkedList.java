import java.util.*;

public class MyLinkedList <T>{
    private LNode start, end;
    private int size;

    public class LNode{
	private T value;
	private LNode next;
	
	
	public LNode(T data){
	    value=data;
	}

	public void set(T ans){
	    value=ans;
	}

	public T get(){
	    return value;
	}

	public LNode getNext(){
	    return next;
	}

	public void setNext(LNode data){
	    next=data;
	}
    }
    

    public T get (int index){
	LNode current = start;
	int i = 0;
	while (i<index){
	    if (current.getNext()!=null){
		current=current.getNext();
		i++;
	    }
	}
	return current.get();
    }

    public T set (int index, T newValue){
	LNode current = start;
	int i = 0;
	while (i<index){
	    if (current.getNext()!=null){
		current=current.getNext();
		i++;
	    }
	}
	T val = current.get();
	current.set(newValue);
	return val;
    }

    public int size(){
	return size;
    }

    public T remove (int index){
	LNode current = start;
	int i = 0;
	while (i<index){
	    if (current.getNext()!=null){
		current=current.getNext();
		i++;
	    }
	}
	T val= current.get();
        for (int k = i;k<size;k++){
	    if (current.getNext().getNext()==null){
		current.set(current.getNext().get());
		current.setNext(null);
		return val;
	    }else{
		current.set(current.getNext().get());
		current=current.getNext();
	    }
	}
	return val;
    }

    public boolean add(int index, T value){
	LNode current = start;
        int i = 0;
	while (i<index){
	    current=current.getNext();
	    i++;
	}
	for (int k = index;k<size;k++){
	    T val=current.get();
	    current.set(value);
	    value=val;
	    end = current.getNext();
	    current=current.getNext();
	}
	size++;
	return true;
    }

    public boolean add(T data){
	if (start==null){
	    start=new LNode(data);
	    end = start;
	    size++;
	}else{
	    LNode current = end;
	    current.setNext(new LNode(data));
	    end = current.getNext();
	    size++;
	}
	return true;
    }

    public int indexOf (T value){
	LNode current = start;
	for (int i=0;i<size;i++){
	    if (current.get().equals(value)){
		return i;
	    }else{
		current=current.getNext();
	    }
	}
	return T;
    }

    public String toString(){
	String ans = "[";
	LNode data = start;
	while (data!=null){
	    ans+=data.get();
	    if (data.getNext()!=null){
		ans+=", ";
	    }
	    data=data.getNext();
	}
	return ans+"]";
    }


    public static void main(String[]args){
	MyLinkedList blah = new MyLinkedList();
	ArrayList<Integer> blargh = new ArrayList<Integer>();
	long start, end;

	start = System.currentTimeMillis();

	int k = 0;
	while(k<100){
	    blargh.add(k);
	    k++;
	}
	System.out.println(blargh);
	blargh.add(54);
	blargh.add(-10);
	blargh.add(47);
	blargh.add(4,5);
	System.out.println(blargh);
	blargh.set(64,5);
	System.out.println(blargh);
	blargh.get(83);
	System.out.println(blargh);
	blargh.indexOf(5);
	System.out.println(blargh);
	blargh.remove(64);
	System.out.println(blargh);

	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for ArrayList");

	

	start = System.currentTimeMillis();
	
	int i=0;
	while(i<100){
	    blah.add(i);
	    i++;
	}
	System.out.println(blah);
	blah.add(54);
	blah.add(-10);
	blah.add(47);
	System.out.println(blah.add(4,5));
	System.out.println(blah);
	blah.set(64, 5);
	System.out.println(blah);
	System.out.println(blah.get(83));
	System.out.println(blah.indexOf(5));
	System.out.println(blah.remove(64));
	System.out.println(blah);

	end = System.currentTimeMillis();
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");
    }
}
