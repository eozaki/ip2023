
public class BasicFunctions  
{

//	Exercicios Semana 1
	
//	a)Obter o dobro de um número.

	static int doubleOf(int x){
	    return x*2;
	}
	
//	b)	Elevar um número ao quadrado.

	static int SquareOf(int x){
	    return x*x;
	}
	
//	c)	Obter a diferença entre dois números.

	static int DifferenceOf(int a, int b){
	    return a-b;
	}
	
//	d)	Obter a percentagem de um valor relativamente a um total.
//		Exemplo: 2 num total de 8 corresponde a 25%

	static double percentage(int n, int total){
	    return (n*100.0)/total;
	}

//	e)	Obter a média entre dois números.

	static double averageOf(int a, int b){
	    return (a+b)/2;
	}

//	f)	Arredondar um número decimal.
//		Exemplo: round(4.3) -> 4      round(4.7) -> 5

	static int roundUp(double n){
		return (int)(n + 0.5);
	}
	
//	g)	Saber se um número inteiro é negativo.
//	Exemplo: isNegative(-2) -> true     isNegative(3) -> false

	static boolean isNegative(int n){
	    return n < 0;
	}
	
//	h)	Saber se um número inteiro é impar.
	
	static boolean isOdd(int n){
	    return n%2 == 1;
	}
	
//	i)	Saber se um número inteiro é par.

	static boolean isEven(int n){
	    return n%2 == 0;
	}
	
//	j)	Saber se um número inteiro é menor que outro.

	static boolean isBiggerThan(int a, int b){
	    return a > b;
	}
	
//	k)	Saber se um número inteiro corresponde a um dígito (i.e. está entre 0 e 9).
	
	static boolean isSingleDigit(int n){
	    return n >= 0 && n <= 9;
	}
	
//	l)	Saber se um número está incluído num dado intervalo (fechado).
//	Exemplo: isIncluded(5, 4, 9) -> true

	static boolean isIncluded(int n, int LowerLim, int UpperLim){
	    return n >= LowerLim && n <= UpperLim;
	}
	
//	m)	Saber se um número está excluído de um dado intervalo (fechado).
//	Exemplo: isExcluded(4, 4, 9) -> false

	static boolean isExcluded(int n, int LowerLim, int UpperLim){
	    return n < LowerLim || n > UpperLim;
	}
	
//	n)	Saber se um número é múltiplo de outro e simultaneamente é par.

	static boolean isMultipleAndEven(int n, int m){
	    return (n%m == 0) && (n%2 == 0);
	}
	
//	o)	Saber se um número satisfaz a condição de ser par ou ser negativo.

	static boolean isNegativeOrEven(int n){
	    return n < 0 || n%2 == 0;
	}
	
//	p)	Calcular a operação lógica disjunção exclusiva (XOR) 
	//	entre dois valores booleanos, sem utilizar o operador ^.
//	Exemplos:
//	xor(true, 	false)	-> true
//	xor(false, 	true)	-> true
//	xor(true, 	true)	-> false
//	xor(false, 	false)	-> false

	static boolean XOR(boolean a, boolean b){
	    return a != b;
	}

//	q)	Saber se um carácter (char) corresponde a uma vogal minúscula.
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
