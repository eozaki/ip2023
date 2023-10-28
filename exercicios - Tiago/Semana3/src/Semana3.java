class Semana3 {

//Defina uma função que recebe como argumento um número natural n e devolve o número de divisores desse número.
//	Exemplo: divisors(8) -> 4

	static int divisors(int n){
		
		int i = 1;
		int NumberOfDivisors = 0;
		while(i != n+1)
		{
			if(n%i == 0)
			{
				NumberOfDivisors = NumberOfDivisors + 1;
			}
			i = i + 1;
		}
		return NumberOfDivisors;
	}
//b) Defina uma função que recebe como argumento um número natural n e devolve o somatório dos seus divisores próprios.
//	Exemplo: sumDivisors(6) -> 6	
	
	static int sumDivisors(int n)
	{
		int i = 2;
		int sum = 0;
		while(i != n+1)
		{
			if(n%i == 0)
			{
				sum = sum + (n/i);
			}
			i = i + 1;
		}
		return sum;
	}
	
//c)Defina uma função que recebe como argumento um número natural n e que devolve o número de números perfeitos até n. 
//Um número perfeito é tal que a soma dos seus divisores próprios é igual ao próprio número. Por exemplo, 
// 6 é um número perfeito: os divisores próprios de 6 são {3,2,1} e 3 + 2 + 1 = 6.

//	Exemplo: perfectNumbersUpTo(30) returns 2

	static int perfectNumbersUpTo(int n)
	{
		int i = 1;
		int perfectNumbersCount = 0;
		
		while(i != n+1)
		{
			if(i == sumDivisors(i))
			{
				perfectNumbersCount = perfectNumbersCount + 1;
			}
			i = i + 1;
		}
		return perfectNumbersCount ;
	}
	
//d) Defina uma função que recebe como argumento um número natural n 
//	e devolve verdadeiro caso n seja primo, ou falso caso contrário.
//	Exemplo: isPrime(6) returns false
	
	static boolean isPrime(int n)
	{
		if(n == 1)
			return false;
		
		int i = 2;
		
		while(i != n)
		{
			if(n%i == 0)
				return false;
			
			i = i + 1;
		}
		return true;
	}
	
/*e)Defina uma função que recebe como argumento um número natural n 
 * e devolve a soma dos números primos menores que n.
 * Exemplo: sumPrimesSmallerThan(8) returns 17
 */
	static int sumPrimesSmallerThan(int n)
	{
		int i = 1;
		int acumulador = 0;
		while(i != n)
		{
			if(isPrime(i))
			{
				acumulador = acumulador + i;
			}
			i = i + 1;
		}
		return acumulador ;
	}
	
/*	Defina uma função que recebe como argumento um número natural n e 
 * 	devolve o número de primos até n (inclusivé).
	Exemplo: countPrimesUpTo(10) returns 4
*/
	static int countPrimesUpTo(int n)
	{
		int i = 0;
		int NumberOfPrimes = 0;
		
		while(i != n+1)
		{
			if(isPrime(i))
			{
				NumberOfPrimes = NumberOfPrimes + 1;
			}
			i = i + 1;
		}
		return NumberOfPrimes ;
	}
	
/*g) Defina uma função que permite saber se existe algum número primo entre 
 * determinado intervalo (aberto).
	Exemplo: existsPrimeBetween(5, 9) returns true
 */
	static boolean existsPrimeBetween(int a, int b)
	{
		int i = a + 1;
		while(i != b)
		{
			if(isPrime(i))
				return true;
			
			i = i + 1;
		}
		return false;
	}
	
/*h) Defina uma função recursiva para calcular o n-ésimo número de Fibonacci.	
 */
	
	static int FibonacciN(int n)
	{
		if(n <= 1)
			return n;

		return FibonacciN(n - 1) + FibonacciN(n - 2);
	}
	
/* i)Defina uma função recursiva para calcular o fatorial de um número.
	Exemplo: factorial(5) return 120
 */
	static int factorial(int n)
	{
		if(n <= 1)
			return 1;
		
		return n*factorial(n-1);
	}
	
/*	j) Defina uma função recursiva para calcular o máximo divisor comum 
 * 	entre dois números.
 * 	Exemplo: gcd(30, 25) returns 5
 */
	static int gcd(int a, int b)
	{
		if(a == b)
			return a;
		
		if(a < b)
		{
			b = b - a;
		}
		else
		{
			a = a - b;
		}
		return gcd(a, b);
	}
	
/*	k) Defina uma função que recebe como argumento um natural n e 
 * 	devolve a maior diferença entre dois números primos consecutivos até n.
	Exemplo: largerDifferenceBetweenPrimes(11) returns 4
 */
	static int largerDifferenceBetweenPrimes(int n)
	{
		int i = 2;
		int differenceCount = 0;
		int largerDifference = 0;
		
		while(i != n+1)
		{
			if(isPrime(i))
			{
				if(differenceCount > largerDifference)
				{
					largerDifference = differenceCount;
				}

				differenceCount = 0;
			}

			differenceCount = differenceCount + 1;
			i = i + 1;
		}
		return largerDifference;
	}
}