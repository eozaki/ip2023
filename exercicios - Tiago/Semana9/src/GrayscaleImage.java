class GrayscaleImage {

	int[][] pixels; // @grayscaleimage
	
//	A)	
	
	GrayscaleImage(Rectangle r)
	{
		pixels = new int[ r.height ][ r.width ];
	}
	
	GrayscaleImage(ColorImage img)
	{
		pixels = new int[ img.getHeight() ][ img.getWidth() ];
		
		for(int y = 0; y < pixels.length; y++)
		{
			for(int x = 0; x < pixels[y].length; x++)
			{
				Color pixelColor = img.getColor(x,y);
				pixels[y][x] = pixelColor.getLuminance();
			}
		}
	}
	
//	B)
	
	//	B - a)
	
	int getPixels()
	{
		return pixels.length * pixels[0].length;
	}
	
	//	B - b)
	
	int getWidth()
	{
		return pixels[0].length;
	}
	
	int getHeight()
	{
		 return pixels.length;
	}
	
	//	B - c)
	
	boolean isSquare()
	{
		return getWidth() == getHeight();
	}
	
//	C)
	
	void drawRectangle(Rectangle rect, int x, int y, int greyTone)
	{
		int width = getWidth() - x;
		int height = getHeight() - y;
		
		if(width > rect.width)
			width = rect.width;
		
		if(height > rect.height)
			height = rect.height;

		for( ; y < height; y++)
		{
			for( ; x < width; x++)
			{
				pixels[y][x] = greyTone;
			}
		}
	}

//	D)
	
	void crop(Rectangle rect, int x, int y)
	{
		int width = getWidth() - x;
		int height = getHeight() - y;
		
		if(width > rect.width)
			width = rect.width;
		
		if(height > rect.height)
			height = rect.height;		
		
		int[][] cropPixels = new int[height][width];
		
		for(int cropY = 0; cropY < height; cropY++)
		{
			for(int cropX = 0; cropX < width; cropX++)
			{
				cropPixels[cropY][cropX] = pixels[cropY + y][cropX + x];
			}
		}
		
		pixels = cropPixels;
	}
	
//	E)
	
	void resize(int resizeX, int resizeY, int anchorX, int anchorY)
	{
		if(getWidth() > resizeX || getHeight() > resizeY)
		{
			//	throw new IllegalArgumentException
		}
		
		if(resizeX - getWidth() < anchorX || resizeY - getWidth() < anchorY)
		{
			//	old image will be cropped out the new image
		}
		
		int[][] resizePixels = new int[resizeY][resizeX];
		
		for(int y = 0; y < getHeight(); y++)
		{
			for(int x = 0; x < getWidth(); x++)
			{
				resizePixels[y + anchorY][x + anchorX] = pixels[y][x];
			}
		}
		
		pixels = resizePixels;
	}
}