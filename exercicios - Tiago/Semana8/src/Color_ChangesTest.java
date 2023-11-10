class Color_ChangesTest {

	/*
	 * 	Parte 2:
	 * 		Teste de alterações
	 * 		à classe color.java
	 */	

	static void colortest()
	{

//	1)
		
		Color ConstantTest = Color.RED;
		
//	2)
		
		Color test_invert = new Color(255,255,0);
		test_invert.invert();
		
//	3)
		
		Color test_brighter = test_invert.brighter(-50);
		test_brighter.changeBrightness(-100);
		
//	4)
		
		Color test_greyscale = Color.PURPLE;
		Color greyscaled = test_greyscale.getGreyscale();
		
//	5)
		
		boolean isEqualTest1 = ConstantTest.isEqualTo(Color.RED);
		boolean isEqualTest2 = ConstantTest.isEqualTo(new Color(255,0,0));
		boolean isEqualTest3 = ConstantTest.isEqualTo(Color.GREEN);
		
//	6)
	
		Color[] v = { Color.RED, new Color(220, 220, 220), Color.BLUE };
		Color c = new Color(220, 220, 220);
		boolean isInVetor = c.containedIn(v); // true
		boolean notInVetor = Color.GREEN.containedIn(v); // false
	}
}