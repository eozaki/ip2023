class CharArrays {

//	Desenvolva uma classe pacote CharArrays contendo 
//	funções/procedimentos sobre vetores de carateres, de modo a permitir:

//	a)	Criar um vetor com determinado caráter, de comprimento n.
//		Exemplo: create('c', 3}) -> {'c','c','c'}

	static char[] create(char c, int n)
	{
		char[] array = new char[n];
		
		for( int i = 0; i < array.length; i++)
		{
			array[i] = c;
		}
		
		return array;
	}
	
//	b)	Preencher todo o vetor com determinado caráter.
//		Exemplo: fill('c', {' ', 'h', 'r'}) -> {'c','c','c'}

	static void fill(char c, char[] v){
		
		for( int i = 0; i < v.length; i++)
		{
			v[i] = c;
		}
	}
	
	static char[] test_fill(char c, char[] v)
	{
		fill(c, v);
		return v;
	}
	
//	c)	Substituir todas as ocorrências de determinado caráter por outro.
//		Exemplo: replace('a','b',{'a','c','a'}) -> {'b','c','b'}
	
	static void replace(char findChar, char replaceChar, char[] v)
	{
		for(int i = 0; i < v.length; i++)
		{
			if(v[i] == findChar)
				v[i] = replaceChar;
		}
	}
	
	static char[] test_replace(char findChar, char replaceChar, char[] v)
	{
		replace(findChar, replaceChar, v);
		return v;
	}
	
//	d)	Substituir a primeira ocorrência de determinado caráter por outro.
	
	static void replaceFirstInstance(char findChar, char replaceChar, char[] v)
	{
		for(int i = 0; i < v.length; i++)
		{
			if(v[i] == findChar)
			{	
				v[i] = replaceChar;
				return ;
			}
		}
	}
	
	static char[] test_replaceFirstInstance(char findChar, char replaceChar, char[] v)
	{
		replaceFirstInstance(findChar, replaceChar, v);
		return v;
	}

//	e)	Substituir a última ocorrência de determinado caráter por outro.

	static void replaceLastInstance(char findChar, char replaceChar, char[] v)
	{
		for(int i = v.length - 1; i >= 0; i--)
		{
			if(v[i] == findChar)
			{	
				v[i] = replaceChar;
				return ;
			}
		}
	}
	
	static char[] test_replaceLastInstance(char findChar, char replaceChar, char[] v)
	{
		replaceLastInstance(findChar, replaceChar, v);
		return v;
	}

//	f)	Rodar os seus elementos para a esquerda 
//		(o primeiro elemento passa a ser o último).
//		Exemplo: shiftLeft({'a','b','c','d'}) -> {'b','c','d','a'}
	
	static void shiftLeft(char[] v)
	{
		char c = v[0];
		
		for(int i = 1; i < v.length; i++)
		{
			v[i - 1] = v[i];
		}
		
		v[v.length - 1] = c;
	}
	
	static char[] test_shiftLeft(char[] v)
	{
		shiftLeft(v);
		return v;
	}

//	g)	Rodar os seus elementos para a direita 
//		(o último elemento passa a ser o primeiro).
//		Exemplo: shiftRight({'a','b','c','d'}) -> {'d','a','b','c'}
	
	static void shiftRight(char[] v)
	{
		char c = v[v.length - 1];
		
		for(int i = v.length - 1; i > 0; i--)
		{
			v[i] = v[i - 1];
		}
		
		v[0] = c;
	}
		
	static char[] test_shiftRight(char[] v)
	{
		shiftRight(v);
		return v;
	}
	
//	h)	Trocar os valores de duas posições do vetor.
//		Exemplo: swap(1, 3, {'a','b','c','d'}) -> {'a','d','c','b'}
	
	static void swap(int i, int j, char[] v){
		char temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	}
	
	static char[] test_swap(int i, int j, char[] v){
		
		swap(i,j,v);
		return v;
	}

//	i)	Inverter a ordem dos seus elementos.
//		Exemplo: invert({'a','b','c'}) -> {'c','b','a'}

	static void invert(char[] v)
	{
		for(int i = 0; i < v.length/2; i++)
		{
			char c = v[v.length - i - 1];
			v[v.length - i - 1] = v[i];
			v[i] = c;
		}
	}
	
	static char[] test_invert(char[] v)
	{
		invert(v);
		return v;
	}

//	j)	Copiar um vetor de carateres.
	
	static char[] copy(char[] array){
		
		char[] v = new char[array.length];
		for(int i = 0; i < array.length; i++)
			v[i] = array[i];
		
		return v;
	}
	
//	k)	Dado um vetor de caráter, e dois índices (primeiro e último), 
//		obter um novo vetor que é um sub-vetor do vetor dado.
//		Exemplo: subarray({'a','b','c','d','e'}, 1, 3) -> {'b','c','d'}

	static char[] subarray(char[] v, int first, int last)
	{
		char[] array = new char[last - first + 1];
		
		for(int i = 0; i < array.length; i++)
		{
			array[i] = v[first + i];
		}
		return array;
	}
	
//	l)	Desenvolva uma função auxiliar para obter um número inteiro aleatório 
//		entre zero e um dado número máximo (inclusive).
//		Exemplo: randomIndex(5) devolve aleatoriamente um número 
//		compreendido no intervalo [0, 5].
//		java.lang.Math

	static int randomIndex(int max){
		double r = Math.random(); // r estará no intervalo [0.0, 1.0[
		int i = (int) (r * (max + 1)); // i estará no intervalo [0, (max - 1)]
		return i;
	}
	
//	m)	Substituir o valor de uma posição aleatória do vetor por um dado caráter c.
	static void replaceRandomChar(char c, char[] v)
	{
		v[ randomIndex(v.length - 1) ] = c;
	}
	
	static char[] test_replaceRandomChar(char c, char[] v)
	{
		replaceRandomChar(c, v);
		return v;
	}
	
//	n)	Baralhar os elementos de um vetor de carateres, 
//		aplicando o algoritmo de Fisher-Yates.
	static void shuffleFisherYates(char[] v)
	{
		for(int i = v.length - 1; i >= 0; i--)
		{
			if( i % 2 == 1)
			{
				char c = v[i];
				v[i] = v[0];
				v[0] = c;
			}
		}		
	}
	
	static char[] test_shuffleFisherYates(char[] v)
	{
		shuffleFisherYates(v);
		return v;
	}
	
//	o)	Ordenar os carateres por ordem crescente.
	
	static void bubbleSort(char[] v)
	{
		for(int i = 0, j = 0; i < v.length - j; i++)
		{			
			if(i == (v.length - 1 - j))
			{
				j++;
				
				if(j == v.length - 1)
					return;
					
				i = -1;
			}
			else
			{
				if(v[i] > v[i + 1])
					swap( i, i+1, v);
			}
		}
	}
	
	static char[] test_bubbleSort(char[] v)
	{
		bubbleSort(v);
		return v;
	}
	
//		EXERCICIOS EXTRA
	
//	Defina duas funções que permitam:

//	p)	Acrescentar um caráter ao final de um vetor de caráter, obtendo um vetor novo.
//		Exemplo: concat({'a','b','c'}, 'd') -> {'a','b','c','d'}

	static char[] concat(char[] v, char c)
	{
		char[] array = new char[v.length + 1];
		
		for(int i = 0; i < v.length; i++)
		{
			array[i] = v[i];
		}
		
		array[v.length] = c;
		
		return array;
	}
	
//	q)	Concatenar dois vetores de caráter (parte esquerda e direita), 
//		obtendo um vetor novo.

	static char[] concat(char[] left, char[] right){

		char[] array = new char[left.length + right.length];
		
		for(int i = 0; i < left.length; i++)
		{
			array[i] = left[i];
		}
		for(int i = 0; i < right.length; i++)
		{
			array[left.length + i] = right[i];
		}
		
		return array;
	}
	
//	r)	Defina um procedimento que substitui o valor de uma posição aleatória 
//		do vetor por um dado caráter c.
//		Exemplo: replaceRandom('z', {'a','b','c'}) -> {'a','z','c'}

	static void replaceRandom(char c, char[] v)
	{
		//	Nao é igual ao exercicio M?
		v[ randomIndex(v.length - 1) ] = c;
	}
	
	static char[] test_replaceRandom(char c, char[] v)
	{
		replaceRandom(c, v);
		return v;
	}
	
//	s)	Defina um procedimento que “troca as metades” de um vetor de carateres.
//		Exemplo: swapHalves({'a','b','c','d'}) -> {'c','d','a','b'}

	static void swapHalves(char[] v)
	{
		//	O exercicio nao define o que fazer com o
		//	indice do meio (caso o tamanho do vetor seja ímpar)
		for(int i = 0; i < v.length/2; i++)
		{
			char c = v[i];
			
			v[i] = v[v.length - v.length/2 + i];
			v[v.length - v.length/2 + i] = c;
		}
	}
	
	static char[] test_swapHalves(char[] v)
	{
		swapHalves(v);
		return v;
	}
}