
public class BasicFunctions  
{

//	Exercicios Semana 1
	
//	a)Obter o dobro de um n�mero.

	static int doubleOf(int x){
	    return x*2;
	}
	
//	b)	Elevar um n�mero ao quadrado.

	static int SquareOf(int x){
	    return x*x;
	}
	
//	c)	Obter a diferen�a entre dois n�meros.

	static int DifferenceOf(int a, int b){
	    return a-b;
	}
	
//	d)	Obter a percentagem de um valor relativamente a um total.
//		Exemplo: 2 num total de 8 corresponde a 25%

	static double percentage(int n, int total){
	    return (n*100.0)/total;
	}

//	e)	Obter a m�dia entre dois n�meros.

	static double averageOf(int a, int b){
	    return (a+b)/2;
	}

//	f)	Arredondar um n�mero decimal.
//		Exemplo: round(4.3) -> 4      round(4.7) -> 5

	static int roundUp(double n){
		return (int)(n + 0.5);
	}
	
//	g)	Saber se um n�mero inteiro � negativo.
//	Exemplo: isNegative(-2) -> true     isNegative(3) -> false

	static boolean isNegative(int n){
	    return n < 0;
	}
	
//	h)	Saber se um n�mero inteiro � impar.
	
	static boolean isOdd(int n){
	    return n%2 == 1;
	}
	
//	i)	Saber se um n�mero inteiro � par.

	static boolean isEven(int n){
	    return n%2 == 0;
	}
	
//	j)	Saber se um n�mero inteiro � menor que outro.

	static boolean isBiggerThan(int a, int b){
	    return a > b;
	}
	
//	k)	Saber se um n�mero inteiro corresponde a um d�gito (i.e. est� entre 0 e 9).
	
	static boolean isSingleDigit(int n){
	    return n >= 0 && n <= 9;
	}
	
//	l)	Saber se um n�mero est� inclu�do num dado intervalo (fechado).
//	Exemplo: isIncluded(5, 4, 9) -> true

	static boolean isIncluded(int n, int LowerLim, int UpperLim){
	    return n >= LowerLim && n <= UpperLim;
	}
	
//	m)	Saber se um n�mero est� exclu�do de um dado intervalo (fechado).
//	Exemplo: isExcluded(4, 4, 9) -> false

	static boolean isExcluded(int n, int LowerLim, int UpperLim){
	    return n < LowerLim || n > UpperLim;
	}
	
//	n)	Saber se um n�mero � m�ltiplo de outro e simultaneamente � par.

	static boolean isMultipleAndEven(int n, int m){
	    return (n%m == 0) && (n%2 == 0);
	}
	
//	o)	Saber se um n�mero satisfaz a condi��o de ser par ou ser negativo.

	static boolean isNegativeOrEven(int n){
	    return n < 0 || n%2 == 0;
	}
	
//	p)	Calcular a opera��o l�gica disjun��o exclusiva (XOR) 
	//	entre dois valores booleanos, sem utilizar o operador ^.
//	Exemplos:
//	xor(true, 	false)	-> true
//	xor(false, 	true)	-> true
//	xor(true, 	true)	-> false
//	xor(false, 	false)	-> false

	static boolean XOR(boolean a, boolean b){
	    return a != b;
	}

//	q)	Saber se um car�cter (char) corresponde a uma vogal min�scula.
//	Exemplos:
//	isVowel('a') -> true
//	isVowel('z') -> false

	static boolean isVowel(char vowel){
	    return 
	    		vowel == 'a' || 
	    		vowel == 'e' || 
	    		vowel == 'i' || 
	    		vowel == 'o' || 
	    		vowel == 'u';
	}
	
}
