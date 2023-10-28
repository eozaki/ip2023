class ExerciciosAdicionais2 {

//	A. Defina uma função static char complementoDeMinúscula(char c) que dada uma
//	letra minúscula, devolva o seu complemento. Se a função receber um carácter que não
//	é uma letra minúscula, deve devolver o carácter recebido.
//		complementoDeMinúscula(‘a’) -> ‘z’
//		complementoDeMinúscula(‘b’) -> ‘y’
//		complementoDeMinúscula(‘c’) -> ‘x’
//		complementoDeMinúscula(‘f’) -> ‘u’
//		complementoDeMinúscula(‘%’) -> ‘%’

	static char complementoDeMinúscula(char c)
	{
		if(c < 'a' || c > 'z')	//	ExerciciosAdicionais1.isLower(c) == false
			return c;

		return (char)(122 - ((int)c - 97));
	}
	
//	B. Defina uma função que dado um vetor de caracteres, devolva verdadeiro caso o
//	complemento do carácter na primeira posição do vetor exista numa das outras posições,
//	e falso caso contrário.
	
	static boolean complementoDoPrimeiro(char[] string)
	{
		char complemento = complementoDeMinúscula(string[0]);
		
		for(int i = 1; i < string.length; i++)
		{
			if(string[i] == complemento) 
				return true;
		}
		
		return false;
	}
	
//	C. Defina uma função que dado um vetor de caracteres e um índice, devolva verdadeiro
//	caso o complemento do carácter na posição indicada pelo índice exista numa das
//	outras posições, e falso caso contrário.

	static boolean complementoDeIndice(char[] string, int indice)
	{
		char complemento = complementoDeMinúscula(string[indice]);
		
		for(int i = 0; i < string.length; i++)
		{
			if(string[i] == complemento) 
				return true;
		}
		
		return false;
	}	
	
//	D. Resolva novamente a alínea B, mas use a função desenvolvida na alínea C.

	static boolean complementoDePrimeiroIndice(char[] string)
	{
		return complementoDeIndice(string, 0);
	}
	
//	E. Defina uma função que dado um vetor de caracteres, devolva verdadeiro se todos os
//	caracteres tiverem o seu complemento no vector, e falso caso contrário.

	static boolean complementosIncluidos(char[] string)
	{
		for(int i = 0; i < string.length; i++)
		{
			if(complementoDeIndice(string, i) == false)
				return false;
		}
		return true;
	}
	
//	F. Defina uma função que dado um vetor de caracteres, devolva um novo vetor com o
//	dobro do tamanho contendo
//		a. na segunda metade o complemento da primeira
//			{'a', 'b', 'c', 'd'} -> {'a', 'b', 'c', 'd', 'z', 'y', 'x', 'w'}
//		b. na segunda metade o complemento por ordem inversa
//			{'a', 'b', 'c', 'd'} -> {'a', 'b', 'c', 'd', 'w', 'x', 'y', 'z'}
//		c. cada caractere seguido do seu complemento
//			{'a', 'b', 'c', 'd'} -> {'a', 'z', 'b', 'y', 'c', 'x', 'd', 'w'}

	static char[] complementado_a(char[] string)
	{
		char[] complementado = new char[string.length * 2];
		
		for(int i = 0; i < string.length; i++)
		{
			complementado[i] = string[i];
			complementado[string.length + i] = complementoDeMinúscula(string[i]);
		}
		
		return complementado;
	}

	static char[] complementado_b(char[] string)
	{
		char[] complementado = new char[string.length * 2];
		
		for(int i = 0; i < string.length; i++)
		{
			complementado[i] = string[i];
			complementado[complementado.length - 1 - i] = complementoDeMinúscula(string[i]);
		}
		
		return complementado;
	}
	
	static char[] complementado_c(char[] string)
	{
		char[] complementado = new char[string.length * 2];
		
		for(int i = 0; i < string.length; i++)
		{
			complementado[i * 2] = string[i];
			complementado[i * 2 + 1] = complementoDeMinúscula(string[i]);
		}
		
		return complementado;
	}
	
//	G. Defina uma função que dados o número de linhas e o número de colunas, devolva uma
//	matriz com essas dimensões preenchida com letras minúsculas aleatórias.
	
	static char[][] createRandomCharMatrix(int lines, int columns)
	{
		char[][] matrix = new char[lines][columns];
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				matrix[i][j] = (char)((Math.random() * 26) + 97);
			}
		}
		
		return matrix;
	}
	
//	H. Defina uma função que dada uma matriz de caracteres, devolva uma nova matriz com o
//	dobro das linhas, em que a cada linha da matriz original deve corresponder essa linha
//	seguida de uma nova linha com o complemento de cada um dos caracteres dessa linha.
	
	static char[][] linhasComplementares(char[][] matrix)
	{
		char[][] complementar = new char[matrix.length * 2][matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				complementar[i * 2][j] 	= matrix[i][j];
				complementar[i * 2 + 1][j] = complementoDeMinúscula(matrix[i][j]);
			}
		}
		
		return complementar;
	}
	
//	I. Resolva novamente o exercício da alínea H, mas sem assumir que todas as linhas têm
//	o mesmo número de elementos.
	
	static char[][] linhasComplementaresEx(char[][] matrix)
	{
		char[][] complementar = new char[matrix.length * 2][];
		
		for(int i = 0; i < matrix.length; i++)
		{
			complementar[i * 2] 	= new char[matrix[i].length];
			complementar[i * 2 + 1] = new char[matrix[i].length];
			
			for(int j = 0; j < matrix[i].length; j++)
			{
				complementar[i * 2][j] 	= matrix[i][j];
				complementar[i * 2 + 1][j] = complementoDeMinúscula(matrix[i][j]);
			}
		}
		
		return complementar;
	}
}