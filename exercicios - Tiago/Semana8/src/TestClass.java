class TestClass {

	/*
	 * 	Parte 1:
	 * 		Trabalho prévio
	 */
	
	static void test ()
	{
		
//	1)	
		String nullString = null;
		String emptyString = "";
		String s1 = "Olá mundo";
		
//	2)		
		
		String s4 = String.valueOf (42);
		String s5 = String.valueOf ('Z');
		String s6 = String.valueOf (3.14);
		String s7 = String.valueOf (true);
		
//	3)
		int length = s1.length();
		char c = s1.charAt (2);
	
//	4)
		
		char [] word = s1.toCharArray();
		String s3 = new String (word);
		
//	5)
		
		ColorImage img = new ColorImage(200, 150);
		img.drawText(30, 50, "And the answer is ..", 20, new Color(255,255,255));
		img.drawCenteredText(100, 100, s4, 20, new Color(255,255,255));
		
	}
}