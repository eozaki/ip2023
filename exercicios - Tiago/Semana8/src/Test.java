class Test {


	/*
	 * 	Parte 3:	
	 * 		Imagens a cores
	 * 		
	 */	
		
//	1)	( Ediçoes à classe ColorImage.java )
	
	static void main()
	{
		/*
		 * Teste às alterações da classe ColorImage.java
		 */
		
		ColorImage img = new ColorImage("coffee.jpg");
		
//	a)
		ColorImage copy = new ColorImage(img);

//	b)		
		copy.invertColors();
		
//	c)
		copy.greyscale();
		
//	d)
		copy.changeBrightness(50);

//	e)
		ColorImage copy_invertH = new ColorImage(img);
		copy_invertH.invertHorizontal();
		
		return;
	}
	

//	2)
	
	static void mirrorRightVertical(ColorImage img)
	{
		int Width = img.getWidth();
		
		for(int x = 0; x < Width/2; x++)
		{
			for(int y = 0; y < img.getHeight(); y++)
			{
				Color CopyPixel = img.getColor(Width - x - 1, y);
				img.setColor(x, y, CopyPixel);
			}
		}
	}
	
	static ColorImage test_mirrorMidVertical()
	{
		ColorImage img = new ColorImage("coffee.jpg");
		
		mirrorRightVertical(img);
		
		img.invertColors();
		img.greyscale();
		
		return img;
	}
	
//	3)
	
	static ColorImage test_paste()
	{
		ColorImage CanvasImg = new ColorImage("coffee.jpg");
		ColorImage PasteImg = new ColorImage("botas.jpg");
		
		CanvasImg.paste(PasteImg, 50, 50);
		
		return CanvasImg;
	}
	
//	4)
	
	static ColorImage fourPictureFrame()
	{
		ColorImage TopLeft = new ColorImage("coffee.jpg");
		
		ColorImage Final = new ColorImage(TopLeft.getWidth() * 2,
											TopLeft.getHeight() * 2);
		
		ColorImage TopRight = new ColorImage(TopLeft);
		ColorImage BottomLeft = new ColorImage(TopLeft);
		
		TopLeft.greyscale();
		BottomLeft.invertColors();
		BottomLeft.invertHorizontal();
		
		ColorImage BottomRight = new ColorImage(TopLeft);
		TopLeft.invertHorizontal();
		
		Final.paste(TopLeft, 0, 0);
		Final.paste(TopRight, TopLeft.getWidth(), 0);
		Final.paste(BottomLeft, 0, TopLeft.getHeight());
		Final.paste(BottomRight, TopLeft.getWidth(), TopLeft.getHeight());
		
		return Final;
	}
	
}