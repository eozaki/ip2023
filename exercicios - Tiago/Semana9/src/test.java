class test {

	/*
	 * Teste das classes desenvolvidas
	 * - Rectangle
	 * - Calculator
	 * - Fraction
	 */
	
//	Calculator
		
	static int sum(int m, int n)
	{
		Calculator c = new Calculator(m);
		
		c.plus(n);
		
		return c.value;
	}

	static int mul(int m, int n)
	{
		Calculator c = new Calculator(m);
		
		c.mul(n);
		
		return c.value;
	}
	
	static int pow(int m, int n)
	{
		Calculator c = new Calculator(m);
		
		c.pow(n);
		
		return c.value;
	}

	static int div(int m, int n)
	{
		Calculator c = new Calculator(m);
		
		c.div(n);
		
		return c.value;
	}
	
	static int rem(int m, int n)
	{
		Calculator c = new Calculator(m);
		
		c.rem(n);
		
		return c.value;
	}

//	Fraction	
	
	static String fractionAsString(int n, int m)
	{
		Fraction f = new Fraction(n,m);
		return f.toString();
	}
	
}