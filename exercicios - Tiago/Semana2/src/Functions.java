
public class Functions 
{

//	Exercicios Semana 2
	
//	a)
	static int max(int a, int b)
	{
	    if(a > b )
	    {
	    	return a;
	    }
	    else
	    {
	    	return b;
	    }
	}
//	b)
	static boolean isMultiple(int a, int b)
	{
		/*	Não tem em conta valores negativos
		 *  ou se os parametros estão trocados
		 *  Valor final = a
		 *  Suposto multiplo = b
		 */
		int Acumulador = 0;
		
		while( a > Acumulador )
		{
			Acumulador = Acumulador + b;
		}
		if(Acumulador == a)
		{
			return true;
		}
		return false;
	}
	
//	c)
	static int abs(int a)
	{
		if(a < 0)
		{
			return a*(-1);
		}
		
		return a;
	}	

//	d)
	static int EscalaoIRS(int RendimentoAnual)
	{
		if(RendimentoAnual < 10000)
		{
			return 1;
		}
		if(RendimentoAnual >= 10000 && RendimentoAnual < 25500)
		{
			return 2;
		}
	
		if(RendimentoAnual >= 25500 && RendimentoAnual < 48500)
		{
			return 3;
		}
		if(RendimentoAnual >= 48500)
		{
			return 4;
		}
		return 0;
	}
	
//	e)
	static char next(char letter)
	{
		/*	Esta funcao nao verifica se "letter" 
		 *  é na verdade uma letra
		 */
		if(letter == 'z')
		{
			return 'a';
		}
		if(letter == 'Z')
		{
			return 'A';
		}
		int NextLetter = (int)letter + 1;
		return (char)NextLetter;
	}		

//	f)
	static int firstDigit(int n)
	{
		if(n < 0)
		{
			//	Funciona com valores negativos
			n = n * (-1);
		}
		
		while(n > 9)
		{
			n = n/10;
		}
		return n;
	}	

//	g)
	static int divide(int a, int b)
	{
		int Contador = 0;
		int Acumulador = 0;
		
		while(Acumulador < a)
		{
			Acumulador = Acumulador + b;
			
			if(Acumulador <= a)
			{
				Contador = Contador + 1;
			}
		}
		return Contador;
	}	

//	h)
	static int powerOfTwo(int n)
	{
		return n*n;
	}	
	
//	i)
	static int sumNaturalsUpTo(int n)
	{
		int Contador = 0;
		int Acumulador = 0;
		
		while(Contador < n)
		{
			Contador = Contador + 1;
			Acumulador = Acumulador + Contador;
		}
		return Acumulador;
	}	
	
//	j)
	static int sumEvenNumbersBetween(int n, int p)
	{
		int Contador = 0;
		int Acumulador = 0;
		
		while(Contador < n)
		{
			Contador = Contador + 1;
			Acumulador = Acumulador + Contador;
		}
		return Acumulador;
	}	
	
//	k)
	static int nFibonacci(int n)
	{		
		int ValorAnterior = 0;
		int Acumulador = 0;
		while(n > 0)
		{
			n = n - 1;
			
			if(Acumulador == 0)
			{
				Acumulador = 1;
			}
			else
			{
				int ValorAtual = Acumulador;
				Acumulador = ValorAnterior + Acumulador;
				ValorAnterior = ValorAtual;
			}
		}
		return Acumulador;
	}	
	
//	l)
	static int gcd(int m, int n)
	{		
		return 0;
	}	
	
}
