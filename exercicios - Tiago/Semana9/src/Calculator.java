class Calculator {

	int value;
	
	Calculator(int n)
	{
		if(n < 0) 
			value = 0;
		else 
			value = n;
	}
	
//	A)	
	
	void plus(int n)
	{
		if(n <= 0)
			return;
		
		value += n;
		
		if(value < 0)
			value = 0;
	}
	
//	B)
	
	void minus(int n)
	{
		if(n <= 0)
			return;
		
		value -= n;
		
		if(value < 0)
			value = 0;
	}
	
//	C)
	
	void reset()
	{
		value = 0;
	}
	
//	D)
	
	void mul(int n)
	{
		if(n <= 1)
			return;
		
		int temp = 0;
		
		while(n > 0)
		{
			temp += value;
			n--;
		}
		
		value = temp;
	}
	
//	E)
	
	void pow(int n)
	{
		/*	funcionalidade nao implementada pois
		 *  o enunciado pede apenas valores POSITIVOS
		
		if(n == 0)
		{
			value = 1;
			return;
		}
		*/
		
		if(n <= 1)
			return;
		
		int temp = value;
		
		while(n > 1)
		{
			mul(temp);
			n--;
		}
		
	}
	
//	F)
	
	void div(int n)
	{
		if(n <= 1 || n > value)
			return;
			
		if(n == value)
		{
			value = 1;
			return;
		}
		
		int i = 1;
		
		while(i * n <= value)
		{
			i++;
		}
		
		value = (i - 1);
		
	}
	
//	G)
	
	void rem(int n)
	{
		int oldValue = value;
		
		div(n);
		
		value = oldValue - (value * n);
	}
}