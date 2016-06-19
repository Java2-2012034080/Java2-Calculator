package Calculator;

public class Calculate {

	public double multiply(double n)
	 	{
	 		double result=0.0;
	 		
	 		result*=n;
	 		
	 		return result;
	 	}
	 			  	
	 	public double divide(double n)
	 	{
	 		double result=0.0;
	 		
	 		result/=n;
	 		
	 		return result;
	 	}
	  			  	
	 	/*private void calculate(double n) {		 +	public double sum(double n)
	 		if (operator.equals("+"))		 +	{
	 			result += n;		 +		double result=0.0;
	 		else if (operator.equals("-"))		 +		
	 			result -= n;		 +		result+=n;
	 		else if (operator.equals("x"))		 +		
	 			result *= n;		 +		return result;
	 		else if (operator.equals("/"))		 +	}
	 			result /= n;		 +	
	 		else if (operator.equals("="))		 +	public double sub(double n)
	 			result = n;		 +	{
	 		display.setText("" + result);		 +		double result=0.0;
	 	}*/	
	 	
	 	public double mode(double n)
	 	{
	 		double result=0.0;
	 		
	 		result%=n;
	 		
	 		return result;
	 	}
	 	
	 	public double inverse(double n)
	 	{
	 		if(n!=0)
	 			return 1/n;
	 		else
	 		return 0.000000000000; 
	 		
	 	}
	 	
	 	public double root(double n)
	 	{
			return Math.sqrt(n);
	 	}
	  }		  

