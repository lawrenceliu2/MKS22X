import java.util.*;

public class MyLinkedList{
    private LNode start, end;
    private int size;

    public class LNode{
	private int value;
	private LNode next;
	
	
	public LNode(int data){
	    value=data;
	}

	public void set(int ans){
	    value=ans;
	}

	public int get(){
	    return value;
	}

	public LNode getNext(){
	    return next;
	}

	public void setNext(LNode data){
	    next=data;
	}
    }
    

    public int get (int index){
	LNode current = start;
	int i = 0;
	while (i<index){
	    if (current.getNext()!=null){
		current=current.getNext();
		i++;
	    }else{
		return -1;
	    }
	}
	return current.get();
    }

    public int set (int index, int newValue){
	LNode current = start;
	int i = 0;
	while (i<index){
	    if (current.getNext()!=null){
		current=current.getNext();
		i++;
	    }else{
		return -1;
	    }
	}
	int val = current.get();
	current.set(newValue);
	return val;
    }

    public int size(){
	return size;
    }

    public int remove (int index){
	LNode current = start;
	int i = 0;
	while (i<index){
	    if (current.getNext()!=null){
		current=current.getNext();
		i++;
	    }else{
		return -1;
	    }
	}
	int val= current.get();
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

    public boolean add(int index, int value){
	LNode current = start;
        int i = 0;
	while (i<index){
	    current=current.getNext();
	    i++;
	}
	for (int k = index;k<size;k++){
	    int val=current.get();
	    current.set(value);
	    value=val;
	    end = current.getNext();
	    current=current.getNext();
	}
	size++;
	return true;
    }

    public boolean add(int data){
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

    public int indexOf (int value){
	LNode current = start;
	for (int i=0;i<size;i++){
	    if (current.get()==value){
		return i;
	    }else{
		current=current.getNext();
	    }
	}
	return -1;
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
