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
    
    public MyLinkedList(int data){
	start = new LNode(data);
	size=1;
    }

    public void add(int data){
	LNode current = start;
	while (current.getNext()!=null){
	    current = current.getNext();
	}
	current.setNext(new LNode(data));
    }

}
