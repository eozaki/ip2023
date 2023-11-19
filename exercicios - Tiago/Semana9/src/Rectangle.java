class Rectangle {

	final int width;
	final int height;
	
	Rectangle(int width, int height)
	{
		if(width < 1 || height < 1)
			throw new IllegalArgumentException("Arguments must be equal or bigger than 1");

		this.width = width;
		this.height = height;
	}
	
	static Rectangle Square(int side)
	{
		return new Rectangle(side, side);
	}
	
//	A)	area, perimetro, diagonal
	
	int area()
	{
		return width * height;
	}
	
	int perimeter()
	{
		return width*2 + height*2;
	}
	
	double diagonalLen()
	{
		return Math.sqrt(width*width + height*height);
	}
	
//	B)	Verificar se o rectangle é quadrado
	
	boolean isSquare()
	{
		return width == height;
	}
	
//	C)
	
	Rectangle scale(int factor)
	{
		return new Rectangle(width*factor, height*factor);
	}
	
//	D)
	
	Rectangle sum(int width, int height)
	{
		return new Rectangle(this.width + width, this.height + height);
	}
	
	Rectangle sum(Rectangle r)
	{
		return sum(r.width, r.height);
	}
	
//	E)
	
	boolean fitsIn(int width, int height)
	{
		return this.width <= width && this.height <= height;
	}
	
	boolean fitsIn(Rectangle r)
	{
		return fitsIn(r.width, r.height);
	}
	
//	F)
	
	
}