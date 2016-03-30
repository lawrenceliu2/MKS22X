import java.util.*;

public class ParenDemo{

    public static boolean isMatching(String s){
	MyStack<Character> data=new MyStack<Character>();
	for (char next: s.toCharArray()){
	    if (next=='('||next=='{'||next=='['||next=='<'){
		data.push(next);
	    }
	    if (next==')'||next=='}'||next==']'||next=='>'){
		try{
		    char expected = getMatch(next);
		    if (data.pop()!=expected){
			return false;
		    }
		}catch (NoSuchElementException e){
		    return false;
		}
	    }
	}
	return data.isEmpty();
    }

    public static char getMatch (char c){
	char match = 0;
	if (c==')'){
	    match='(';
	}
	if (c=='}'){
	    match='{';
	}
	if (c==']'){
	    match='[';
	}
	if (c=='>'){
	    match='<';
	}
	return match;
    }


    public static void main(String[]args){
	String input = "()()(([[]]))";
	if(args.length > 0){
	    input = args[0];
	    System.out.println(isMatching(input)); 
	}else{
	    System.out.println("Usage:"); 
	    System.out.println("java ParenDemo \"text\""); 
	}
    }
}
