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
		//	Criar a primeira imagem original
		ColorImage TopLeft = new ColorImage("coffee.jpg");
		
		//	A partir das dimensoes da TopLeft, cria-se em branco
		//	a imagem final, com o dobro da altura/largura
		ColorImage Final = new ColorImage(TopLeft.getWidth() * 2,
											TopLeft.getHeight() * 2);
		
		//	Cria-se cópias da TopLeft, sendo mais rapido
		//	do que obter cópias através do ficheiro jpg
		ColorImage TopRight = new ColorImage(TopLeft);
		ColorImage BottomLeft = new ColorImage(TopLeft);
		
		TopLeft.greyscale();
		BottomLeft.invertColors();
		BottomLeft.invertHorizontal();
		
		//	A imagem inferior direita é greyscaled
		//	tal como a TopRight, evita-se o passo de 
		//	inverter as cores desta tambem
		ColorImage BottomRight = new ColorImage(TopLeft);
		TopLeft.invertHorizontal();

		//	Produto final:
		Final.paste(TopLeft, 0, 0);
		Final.paste(TopRight, TopLeft.getWidth(), 0);
		Final.paste(BottomLeft, 0, TopLeft.getHeight());
		Final.paste(BottomRight, TopLeft.getWidth(), TopLeft.getHeight());
		
		return Final;
	}
	
	/*		
	 * 				EXTRAS	
	 */
	
//	1)
	
	static ColorImage test_selection(String file)
	{
		ColorImage test = new ColorImage(file);
		
		ColorImage selected = test.selection(0,0,200,200);	
		return selected;
	}
	
//	2)
	
	static ColorImage[] getQuarters(String file)
	{
		ColorImage srcImg = new ColorImage(file);
		
		int width = srcImg.getWidth();
		int height = srcImg.getHeight();
		
		ColorImage[] quarters = new ColorImage[4];

		quarters[0] = srcImg.selection(0, 0, width/2, height/2);
		quarters[1] = srcImg.selection(0, height/2, width/2, height);
		quarters[2] = srcImg.selection(width/2, 0, width, height/2);
		quarters[3] = srcImg.selection(width/2, height/2, width, height);
					
		return quarters;
	}
	
//	3)	
	
	static ColorImage horizontalMerge(ColorImage left, ColorImage right)
	{
		int width = left.getWidth() + right.getWidth();
		int height = (int)Math.max(left.getHeight(), right.getHeight());
	
		ColorImage merge = new ColorImage(width, height);

		merge.paste(left, 0,0);
		merge.paste(right, left.getWidth(),0);
		
		return merge;
	}
	
	static ColorImage test_horizontalMerge(String left, String right)
	{
		ColorImage leftImg = new ColorImage(left);
		ColorImage rightImg = new ColorImage(right);
		
		return horizontalMerge(leftImg, rightImg);
	}
}