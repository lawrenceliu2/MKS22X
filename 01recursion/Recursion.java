public class Recursion{
    
    public String name(){
	return "Liu,Lawrence";
    }

    public double sqrt (double n){
	double guess = 1;
	return helper(n,guess);
    }

    public static double helper (double n, double guess){
	if (Math.abs(guess * guess - n)  < 0.000001){
	    return guess;
	}else{
	    guess = n / (guess * 2) + (guess / 2);
	    return helper (n, guess);
	}
    }
}
