class Semana7 {

//	1)
	
	static int randomFromZeroTo(int n)
	{
		return (int)(Math.random() * (n+1));
	}
	
//	2)
	
	static int constrain(int n, int min, int max)
	{
		if(n < min)
			return min;
		
		if(n > max)
			return max;
		
		return n;
	}
	
//	3)	
	
	static boolean randomBool()
	{
		if((Math.random() * 2) >= 1.0)
			return true;
		
		return false;
	}
	
//	4)	
	
	static boolean[][] createRandomBoolMatrix(int lines, int columns)
	{
		boolean[][] boolMatrix = new boolean[lines][columns];

		for(int i = 0; i < boolMatrix.length; i++)
		{
			for(int j = 0; j < boolMatrix[i].length; j++)
			{
				boolMatrix[i][j] = randomBool();
			}
		}
		
		return boolMatrix;
	}
	
	static boolean[][] getChessBoard()
	{
		boolean[][] board = new boolean[8][8];
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if((i+j)%2 == 0)
					board[i][j] = true;
				else
					board[i][j] = false;				
			}
		}
		
		return board;
	}
	
	static double get2DPointDistance(double xa,double ya,double xb,double yb)
	{
		return Math.sqrt( Math.pow((xb-xa),2) + Math.pow((yb-ya),2) );
	}

//	-----------------------------------------
//					C O R E S
//	-----------------------------------------

//	a)
	
	static Color gray(int lum)
	{
		return new Color(lum, lum, lum);
	}
	
//	b)	
	
	static Color randomGray()
	{
		int randLum = randomFromZeroTo(255);

		return new Color(randLum,randLum,randLum);
	}
	
//	c)	
	
	static Color RandomColor()
	{
		Color rand = new Color(	randomFromZeroTo(255),
								randomFromZeroTo(255),
								randomFromZeroTo(255));
		return rand;
	}
	
//	d)
	
	static Color[] randomColorArray(int length)
	{
		Color[] randColors = new Color[length];
		
		for(int i = 0; i < length; i++)
		{
			randColors[i] = RandomColor();
		}
		
		return randColors;
	}
	
//	e)
	
	static Color inverted(Color color)
	{
		Color inverted = new Color(255 - color.getR(),
									255 - color.getG(),
									255 - color.getB());
	
		return inverted;
	}
	
	static Color test_inverted(int r, int g, int b)
	{
		return inverted(new Color(r,g,b));
	}
	
//	f)
	
	static Color changeBrightness(Color color, int delta)
	{
		Color newColor = 
				new Color(	constrain(color.getR() + delta, 0, 255),
							constrain(color.getG() + delta, 0, 255),
							constrain(color.getB() + delta, 0, 255));
	
		return newColor;
	}

	static Color test_changeBrightness(int r, int g, int b, int delta)
	{
		return changeBrightness(new Color(r,g,b), delta);
	}
	

//	-----------------------------------------
//			I M A G E N S    B I N A R I A S
//	-----------------------------------------
	
//	a)
	
	static BinaryImage noise(int width, int height)
	{
		BinaryImage img = new BinaryImage(width, height);
		
		for(int x = 0; x < width; x++)
		{
			for(int y = 0; y < height; y++)
			{
				if(randomBool() == true) 
					img.setWhite(x,y);
			}
		}
		
		return img;
	}
	
//	b)
	
	static void drawSquare(BinaryImage img, int xi, int yi, int side)
	{
		for(int x = xi; x < (xi + side); x++)
		{
			for(int y = yi; y < (yi + side); y++)
			{
				if( (x >= 0 && x < img.getWidth()) && (y >= 0 && y < img.getHeight()) )	
					img.setWhite(x,y);
			}
		}
	}
	
	static BinaryImage test_drawSquare(int width, int heigth, int x, int y, int side)
	{
		BinaryImage square = noise(width, heigth);

		drawSquare(square, x, y, side);
		
		return square;
	}
	
//	c)
	
//		i)

	static void Invert(BinaryImage img)
	{
		for(int x = 0; x < img.getWidth(); x++)
		{
			for(int y = 0; y < img.getHeight(); y++)
			{
				if(img.isBlack(x,y))
				{
					img.setWhite(x,y);
				}
				else
				{
					img.setBlack(x,y);
				}
			}
		}		
	}
	
//		ii)

	static BinaryImage getInverted(BinaryImage img)
	{
		for(int x = 0; x < img.getWidth(); x++)
		{
			for(int y = 0; y < img.getHeight(); y++)
			{
				if(img.isBlack(x,y))
				{
					img.setWhite(x,y);
				}
				else
				{
					img.setBlack(x,y);
				}
			}
		}
		
		return img;
	}
	
	
	static BinaryImage test_Invert()
	{
		BinaryImage test = test_drawSquare(500, 500, 100, 100, 200);
		Invert(test);
		return test;
	}
	
//	d)
	
	static void drawBorder(BinaryImage img, int thickness)
	{				
		// upper border
		for(int x = 0; x < img.getWidth(); x++)
		{
			for(int y = 0; y < thickness; y++)
			{				
				img.setBlack(x,y);
			}
		}
		
		//	lower border
		for(int x = 0; x < img.getWidth(); x++)
		{
			for(int y = img.getHeight() - thickness; y < img.getHeight(); y++)
			{				
				img.setBlack(x,y);
			}
		}
		
		//	left border
		for(int x = 0; x < thickness; x++)
		{
			for(int y = thickness; y < img.getHeight(); y++)
			{
				img.setBlack(x,y);
			}
		}
		
		//	right border
		for(int x = img.getWidth() - thickness - 1; x < img.getWidth(); x++)
		{
			for(int y = thickness; y < img.getHeight() - thickness; y++)
			{
				img.setBlack(x,y);
			}
		}
		
	}
	
	static BinaryImage test_drawBorder(int thickness)
	{
		BinaryImage test = test_drawSquare(500, 500, 100, 100, 200);
		drawBorder(test, thickness);
		return test;
	}
	
//	e)
	
	static BinaryImage convert(boolean[][] data)
	{
		BinaryImage img = new BinaryImage(data[0].length, data.length);
		
		for(int x = 0; x < img.getWidth(); x++)
		{
			for(int y = 0; y < img.getHeight(); y++)
			{	
				if(data[y][x])
					img.setWhite(x,y);
			}	
		}
		
		return img;
	}
	
	static BinaryImage randomMatrixToBinaryImage(int lines, int columns)
	{
		boolean[][] boolMatrix = createRandomBoolMatrix(lines, columns);
		
		return convert(boolMatrix);
	}
	
//	f)	
	
	static BinaryImage convert(boolean[][] data, int pixelsize)
	{
		BinaryImage img = new BinaryImage(data[0].length*pixelsize, data.length*pixelsize);
		
		for(int y = 0; y < data.length; y++ )
		{
			for(int x = 0; x < data[y].length; x++)
			{
				if(data[y][x])
					drawSquare(img, x*pixelsize, y*pixelsize, pixelsize);
			}
		}
		
		return img;
	}
	
	static BinaryImage test_randomMatrixToBinaryImage(int lines, int columns, int pixelsize)
	{
		boolean[][] boolMatrix = createRandomBoolMatrix(lines, columns);
		
		return convert(boolMatrix, pixelsize);
	}

//	g)	
	
	static BinaryImage createChessBoard(int squaresize)
	{
		boolean[][] board = getChessBoard();
		BinaryImage boardImg = convert(board, squaresize);
		drawBorder(boardImg, (int)((double)squaresize*0.05));
		
		return boardImg;
	}
	
//	h)
	
	static BinaryImage scale(BinaryImage img, int scale)
	{
		
	}
}