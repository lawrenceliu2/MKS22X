public class BSTree<T extends Comparable<T>>{

    private class Node{
	private T data;
	private Node left,right;

	public Node(T value){
	    data=value;
	}

	public T getData(){return data;}

	public Node getLeft(){return left;}

	public Node getRight(){return right;}

	public void setData(T value){data=value;}

	public void setLeft(Node value){left=value;}

	public void setRight(Node value){right=value;}
    }
    
    private Node root;

    public int getHeight(){
	return getHeight(root);
    }
	
    public int getHeight(Node data){
	if (data==null){
	    return 0;
	}else{
	    return 1+Math.max(getHeight(data.getLeft()),getHeight(data.getRight()));
	}
    }
    
    public void add(T value){
	Node data = new Node(value);
	if (root==null){
	    root = data;
	}else{
	    Node current = root;
	    Node parent = null;
	    parent = current;
	    if (value.compareTo(current.getData())<0){
		current = current.getLeft();
		if (current==null){
		    parent.setLeft(data);
		}
	    }else{
		current=current.getRight();
		if (current==null){
		    parent.setRight(data);
		}
	    }
	}
    }

    public boolean contains(T value){
	Node current = root;
	while (current!= null){
	    if (current.getData()==value){
		return true;
	    }else if (current.getData().compareTo(value)>0){
		current=current.getLeft();
	    }else{
		current=current.getRight();
	    }
	}
	return false;
    }

    public String toString(){
	return toString(root);
    }

    public String toString (Node data){
	String ans = "";
	if (data == null){
	    return "";
	}else{
	    ans+= toString (data.getLeft());
	    ans+= toString (data.getRight());
	    ans+= data.getData().toString();
	    return ans;
	}
    }
}
