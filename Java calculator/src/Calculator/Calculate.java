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
	
	public double sum(double n)
	{
		double result=0.0;
		
		result+=n;
		
		return result;
	}
	
	public double sub(double n)
	{
		double result=0.0;
		
		result-=n;
		
		return result;
	}
	
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
			return 0.000000000000; // 에러구현 필요
		
	}
	
	public double root(double n)
	{
		return Math.sqrt(n);
	}
}
