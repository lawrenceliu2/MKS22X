import java.util.*;

public class MyLinkedList <T> implements Iterable{
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
    

    /*public Iterator<T> iterator(){
	Iterator<T> ans = 
	}*/
    
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
	if (index<0||index>size){
	    throw new IndexOutOfBoundsException();
	}else{
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
    }

    public int size(){
	return size;
    }

    public T remove (int index){
	if (index<0||index>size){
	    throw new IndexOutOfBoundsException();
	}else{
	    LNode current = start;
	    int i = 0;

	    if (index == 0){
		T val = current.get();
		current = current.getNext();
		start = current;
		size--;
		return val;
	    }

	    while (i<index){
		if (index==size-1){
		    end = current;
		    }
		current=current.getNext();
		i++;
	    }
	    T val= current.get();

	    for (int k = i;k<size-1;k++){
		end = current;
		current.set(current.getNext().get());
		current = current.getNext();
	    }

	    size--;
	    return val;
	}
    }

    public boolean add(int index, T value){
	if (index<0||index>size){
	    throw new IndexOutOfBoundsException();
	}else{
	    LNode current = start;
	    int i = 0;
	    while (i<index){
		current=current.getNext();
		i++;
	    }
	    if (index==size){
		current.setNext(new LNode(value));
		current=current.getNext();
		end = current;
		size++;
		return true;
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

    public String toString(boolean thing){
	String ans = "[";
	LNode data = start;
	while (data!=end){
	    if (data == null){
		data=data.getNext();
	    }else{
		ans+=data.get();
		ans+=", ";
		data=data.getNext();
	    }
	}
	ans+=data.get();
	return ans+"]";
    }


    public static void main(String[]args){
	MyLinkedList<String> m = new MyLinkedList<String>();
        ArrayList<String>    n = new ArrayList<String>();

        for(int i = 0; i < 10; i++){
            n.add(""+i);
            m.add(""+i);
        }

        try{
            m.add(-1,"oops");
            System.out.println("\n\nAdd -1 #####################################");
        }catch(IndexOutOfBoundsException e){

        }
        try{
            m.add(12,"oops");
            System.out.println("\n\n add 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }
        try{
            m.remove(12);
            System.out.println("\n\n remove 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }

        try{
            m.set(12,"Fwazzat?!?");
            System.out.println("\n\n set 12 #####################################");
        }catch(IndexOutOfBoundsException e){

        }


        //replace toString(true) with a debug to string that shows the head/tail
        System.out.println(m.toString(true));
        System.out.println(n);

        //test removing from head/tail/middle
        m.remove(0);
        n.remove(0);
        System.out.println(m.toString(true));

        m.remove(2);
        n.remove(2);
        System.out.println(m.toString(true));

        m.remove(m.size()-1);
        n.remove(n.size()-1);
        System.out.println(m.toString(true));
        System.out.println(n);

        //test adding to end/start
        m.add(0,"START");
        n.add(0,"START");
        m.add(m.size(),"PENULTIMATE");
        n.add(n.size(),"PENULTIMATE");
        System.out.println(m.toString(true));
        System.out.println(n);

        //test add
        m.add("Z-END!");
        n.add("Z-END!");
        System.out.println(m.toString(true));
        System.out.println(n);

        //test remove random items:
        Random rand = new Random(0);
        for(int i = 0; i < 6000; i++){
            int op = rand.nextInt(4);

            if(op == 0 || n.size()==0){//ensure never empty
                n.add(""+i);
                m.add(""+i);
            }else if(op == 1 ){
                int x = rand.nextInt(n.size());
                n.add(x,""+i);
                m.add(x,""+i);
            }else{
		System.out.println(m);
		System.out.println(n);
                int x = rand.nextInt(n.size());
                if(!n.remove(x).equals(m.remove(x))){
                    System.out.println("Non matching elements removed\n");
                    System.exit(1);
                }
            }
        }
        System.out.println(m.toString(true));
        System.out.println(n);

	
	/*MyLinkedList <Integer>blah = new MyLinkedList<Integer>();
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
	System.out.println("Time: " + (end-start)/1000.0 + " seconds for MyLinkedList");*/

        
    }
}
