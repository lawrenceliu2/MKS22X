public class MyLinkedList{
    private LNode start;
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
	int val= current.getNext().get();
        current.set(0);
	return val;
    }

    public boolean add(int index, int value){
	LNode current = start;
        int i = 0;
	while (i<index){
	    if (current.get()==value){
		for (int k = index;k<size;k++){
		    int val=current.get();
		    current.set(value);
		    value=val;
		    current=current.getNext();
		}
		return true;
	    }else{
		current=current.getNext();
	    }
	}
	return false;
    }

    public boolean add(int data){
	if (start==null){
	    start=new LNode(data);
	}else{
	    LNode current = start;
	    while (current.getNext()!=null){
		current=current.getNext();
	    }
	    current.setNext(new LNode(data));
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
	int i=0;
	while(i<100){
	    blah.add(i);
	    i++;
	}
	blah.add(54);
	blah.add(-10);
	blah.add(47);
	System.out.println(blah.add(4,5));
	System.out.println(blah);
    }
}
