class IntArrays {

//	a)Defina uma função que constroi um vetor com os números naturais 
//	até um dado número n.
//	Exemplo: naturals(5) -> {1, 2, 3, 4, 5}
	static int[] naturals(int n){
	    int[] array = new int[n];
	    while(n != 0)
	    {
	    	n = n - 1;
	    	array[n] = n + 1; 
	    }
		return array;
	}

//	b)	Defina uma função que calcula o somatório dos valores de um vetor.
//	Exemplo: sum({1, 3, 5}) -> 9
		
	static int sum(int[] v){
		int sum = 0;
		int i = 0;
		while(i < v.length)
		{
			sum = sum + v[i];
			i = i + 1;
		}
		return sum;	
	}
	
//	c) Construir um vetor com dígitos aleatórios (números de 0 a 9), 
//	dado o comprimento.
//	Exemplo: randomDigits(5) -> {2, 1, 4, 9, 2}

	static int[] randomDigits(int n)
	{
		int[] v = new int[n];
		
		while(n != 0)
		{
			double r = Math.random(); // r estará no intervalo [0.0, 1.0[
			int i = (int) (r * 10); // i estará no intervalo [0, (max - 1)]
			
			n = n - 1;
			v[n] = i;
		}
		return v;
	}
	
//	d) Defina uma função que calcula a média dos valores de um vetor.
//	Exemplo: mean({13, 14, 16, 15}) -> 14.5

	static double mean(int[] v){
		
		int i = 0;
		int sum = 0;
		while(i < v.length)
		{
			sum = sum + v[i];
			i = i + 1;
		}
		return sum/v.length;
	}
	
//	e)	Defina uma função que copia (replica) um vetor de inteiros, 
//	tendo o novo vetor um tamanho dado como argumento.
//	Exemplo: copy({1, 2, 3}, 6) -> {1, 2, 3, 0, 0, 0}

	static int[] copy(int[] v, int length){
		
		int[] newArray = new int[length];
		
		int i = 0;
		while(i < v.length)
		{
			newArray[i] = v[i];
			i = i + 1;
		}
		return newArray;
	}
	
//	f)	Defina uma função que copia (replica) um vetor de inteiros, 
//	tendo o novo vetor o mesmo tamanho que o original.

	static int[] copy(int[] v){
		
		int[] array = v;
		return array;
	}
	
//	g)	Defina uma função para verificar se existe determinado número n num vetor.
//	Exemplo: exists(5, {1, 5, 2}) -> true

	static boolean exists(int n, int[] v)
	{
		int i = 0;
		while(i < v.length)
		{
			if(n == v[i])
				return true;

			i = i + 1;
		}
		return false;
	}
	
//	h)	Defina uma função que devolva o número de ocorrências 
//		de um determinado número num vetor.
//	Exemplo: count(3, {1, 3, 4, 5, 3}) -> 2

	static int count(int n, int[] v)
	{
		int i = 0;
		int count = 0;
		while(i < v.length)
		{
			if(n == v[i])
				count = count + 1;;

			i = i + 1;
		}
		return count;
	}
	
//	i)	Defina uma função que devolva o valor máximo de um vetor.
//	Exemplo: max({5, 1, 6, 9, 3}) -> 9
	static int max(int[] v)
	{
		int max = 0;
		int i = 0;

		while(i < v.length)
		{
			if(v[i] > max)
				max = v[i];

			i = i + 1;
		}		
		return max;
	}

//	j)	Defina uma função para construir um sub-vetor de outro vetor, 
//		dados o índice do primeiro elemento e 
//		o índice do último elemento a incluir.
//		Exemplo: subArray(2, 4, {3, 5, 6, 7, 8, 9}) -> {6, 7, 8}

	static int[] subArray(int first, int last, int[] v)
	{
		int[] subarray = new int[last - first + 1];

		int i = first;
		
		while(i <= last)
		{
			subarray[i - first] = v[i];
			i = i + 1;
		}
		return subarray;
	}

//	k)	Defina uma função que permita obter a primeira metade de um vetor v, 
//		incluindo opcionalmente o elemento do meio 
//		(caso o comprimento do vetor seja ímpar).
//		Exemplo: firstHalf({1, 2, 3, 4, 5}, true) -> {1, 2, 3}

	static int[] firstHalf(int[] v, boolean includeMiddle)
	{
		int halfLength = 0;
		
		if(v.length % 2 == 0)
		{
			halfLength = v.length/2;
		}
		else
		{
			halfLength = v.length/2;
			if(includeMiddle)
			{
				halfLength = halfLength + 1;
			}
		}
		
		int i = 0;
		int[] halfArray = new int[halfLength];
		
		while(i < halfLength)
		{
			halfArray[i] = v[i];
			i = i + 1;
		}
		
		return halfArray;
	}
	
//	l)	Analogamente à alínea anterior, 
//		defina uma função que permita obter a segunda metade de um vetor.

	static int[] lastHalf(int[] v, boolean includeMiddle)
	{
		int halfLength = 0;
		
		if(v.length % 2 == 0)
		{
			halfLength = v.length/2;
		}
		else
		{
			halfLength = v.length/2;
			if(includeMiddle)
			{
				halfLength = halfLength + 1;
			}
		}
		
		int i = 0;
		int[] halfArray = new int[halfLength];
		
		while(i < halfLength)
		{
			halfArray[i] = v[v.length - halfLength + i];
			i = i + 1;
		}
		
		return halfArray;
	}	
	
//	m)	Defina uma função para construir um vetor juntando 
//		outros dois vetores (parte esquerda e direita).
//		Exemplo: merge({1, 2}, {9, 10}) -> {1, 2, 9, 10}

	static int[] merge(int[] left, int[] right){
	    
		int mergeLength = left.length + right.length;
		int[] mergeArray = new int[mergeLength];
	
		int i = 0;
		
		while(i < left.length)
		{	
			mergeArray[i] = left[i];
			i = i + 1;
		}
		
		i = 0;
		
		while(i < right.length)
		{
			mergeArray[i + left.length] = right[i];
			i = i + 1;
		}
		return mergeArray;
	}

//	n)	Defina uma função que construa um vetor invertido com base noutro vetor. 
//		Ou seja, o novo vetor será composto pelos elementos 
//		do vetor dado pela ordem inversa.
//		Exemplo: invert({1, 2, 3}) -> {3, 2, 1}

	static int[] invert(int[] v)
	{		
		int[] reverseArray = new int[v.length];
	
		int i = 0;
		
		while(i < v.length)
		{
			reverseArray[i] = v[v.length - i - 1];
			i = i + 1;
		}
		return reverseArray;
	}
	
//	o)	Sortear um número de um vetor, 
//	com igual probabilidade para todos os elementos. 
//	A solução passa por sortear um índice válido do vetor.
//	Exemplo: random({7, 2, 5, 4}) -> 7, 2, 5, ou 4

	static int random(int[] v)
	{
		double r = Math.random(); // r estará no intervalo [0.0, 1.0[
		int n = (int) (r * v.length+1); // i estará no intervalo [0, (max - 1)]
		
		return n;
	}
	
//		Exercícios extra

//	p)	Defina uma função que construa um vetor com base noutro, 
//		de modo a ter o dobro do tamanho e cada elemento duplicado.
//		Exemplo: duplicateEveryElement({1, 2, 3}) -> {1, 1, 2, 2, 3, 3}
	
	static int[] duplicateEveryElement(int[] v)
	{
		int[] duppedArray = new int[v.length*2];
		
		int i = 0;
		
		while(i < v.length)
		{
			duppedArray[i + i] 		= v[i];
			duppedArray[i + i + 1] 	= v[i];
			i = i + 1;
		}
		
		return duppedArray;
	}
	
//	q)	Defina uma função que construa um vetor com base noutro, 
//		sendo a primeira metade uma cópia e 
//		a segunda metade os mesmos elementos pela ordem inversa.
//	Exemplo: duplicateInverted({3, 2, 1}) -> {3, 2, 1, 1, 2, 3}
	
	static int[] duplicateInverted(int[] v)
	{
		int[] duppedInvertedArray = new int[v.length*2];
		
		int i = 0;
		
		while(i < v.length)
		{
			duppedInvertedArray[i] = v[i];
			duppedInvertedArray[v.length + i] = v[v.length - i - 1];
			i = i + 1;
		}
		
		return duppedInvertedArray;			
	}
	
//	r)	Defina uma função que construa um vetor com base noutro, 
//		representando uma cópia sem o elemento do meio 
//		(caso o tamanho seja ímpar).
//	Exemplo: copyWithoutMiddleElement({1, 2, 3, 4, 5}) -> {1, 2, 4, 5}

	static int[] copyWithoutMiddleElement(int[] v)
	{
		if(v.length % 2 == 0)
			return v;
		
		int halfSize = v.length/2;
		
		int[] copy = new int[v.length - 1];
		
		int i = 0;
		
		while(i < halfSize)
		{
			copy[i] = v[i];
			i = i + 1;
		}
		
		i = i + 1;
		
		while(i < v.length)
		{
			copy[i - 1] = v[i];
			i = i + 1;
		}
		
		return copy;			
	}
//	s)	Construir um vetor com n números da sequência de Fibonacci.
//	Exemplo: fibonacciSequence(7) -> {0, 1, 1, 2, 3, 5, 8}

	static int[] fibonacciSequence(int n)
	{
		int[] array = new int[n];
		
		int i = 0;
		
		while(i < n)
		{
			if(i == 0 || i == 1)
			{
				array[i] = i;
			}
			else
			{
				array[i] = array[i - 1] + array[i - 2];
			}
			i = i + 1;
		}
		
		return array;
	}
}