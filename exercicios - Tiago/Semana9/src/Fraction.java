class Fraction {

	final int numerator;
	final int denominator;
	
	Fraction(int n, int m)
	{
		numerator = n;
		denominator = m;
	}
	
	Fraction(int n)
	{
		this(n, 1);
	}
	
//	A)
	
	public String toString()
	{
		return numerator + "/" + denominator;
	}
	
//	B)
	
	double getValue()
	{
		return numerator/denominator;
	}
	
//	C)
	
	double getScaled(int n)
	{
		return getValue()*n;
	}
	
//	D)
	
	double getMul(Fraction f)
	{
		return getValue() * (f.numerator/f.denominator);
	}
	
//	E)
	
	double getSum(Fraction f)
	{
		return getValue() + (f.numerator/f.denominator);
	}
	
//	F)
	
	boolean isEqual(Fraction f)
	{
		return getValue() == f.getValue();
	}
}