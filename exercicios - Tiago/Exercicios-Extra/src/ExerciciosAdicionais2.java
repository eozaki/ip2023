class ExerciciosAdicionais2 {

//	A. Defina uma fun��o static char complementoDeMin�scula(char c) que dada uma
//	letra min�scula, devolva o seu complemento. Se a fun��o receber um car�cter que n�o
//	� uma letra min�scula, deve devolver o car�cter recebido.
//		complementoDeMin�scula(�a�) -> �z�
//		complementoDeMin�scula(�b�) -> �y�
//		complementoDeMin�scula(�c�) -> �x�
//		complementoDeMin�scula(�f�) -> �u�
//		complementoDeMin�scula(�%�) -> �%�

	static char complementoDeMin�scula(char c)
	{
		if(c < 'a' || c > 'z')	//	ExerciciosAdicionais1.isLower(c) == false
			return c;

		return (char)(122 - ((int)c - 97));
	}
	
//	B. Defina uma fun��o que dado um vetor de caracteres, devolva verdadeiro caso o
//	complemento do car�cter na primeira posi��o do vetor exista numa das outras posi��es,
//	e falso caso contr�rio.
	
	static boolean complementoDoPrimeiro(char[] string)
	{
		char complemento = complementoDeMin�scula(string[0]);
		
		for(int i = 1; i < string.length; i++)
		{
			if(string[i] == complemento) 
				return true;
		}
		
		return false;
	}
	
//	C. Defina uma fun��o que dado um vetor de caracteres e um �ndice, devolva verdadeiro
//	caso o complemento do car�cter na posi��o indicada pelo �ndice exista numa das
//	outras posi��es, e falso caso contr�rio.

	static boolean complementoDeIndice(char[] string, int indice)
	{
		char complemento = complementoDeMin�scula(string[indice]);
		
		for(int i = 0; i < string.length; i++)
		{
			if(string[i] == complemento) 
				return true;
		}
		
		return false;
	}	
	
//	D. Resolva novamente a al�nea B, mas use a fun��o desenvolvida na al�nea C.

	static boolean complementoDePrimeiroIndice(char[] string)
	{
		return complementoDeIndice(string, 0);
	}
	
//	E. Defina uma fun��o que dado um vetor de caracteres, devolva verdadeiro se todos os
//	caracteres tiverem o seu complemento no vector, e falso caso contr�rio.

	static boolean complementosIncluidos(char[] string)
	{
		for(int i = 0; i < string.length; i++)
		{
			if(complementoDeIndice(string, i) == false)
				return false;
		}
		return true;
	}
	
//	F. Defina uma fun��o que dado um vetor de caracteres, devolva um novo vetor com o
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
			complementado[string.length + i] = complementoDeMin�scula(string[i]);
		}
		
		return complementado;
	}

	static char[] complementado_b(char[] string)
	{
		char[] complementado = new char[string.length * 2];
		
		for(int i = 0; i < string.length; i++)
		{
			complementado[i] = string[i];
			complementado[complementado.length - 1 - i] = complementoDeMin�scula(string[i]);
		}
		
		return complementado;
	}
	
	static char[] complementado_c(char[] string)
	{
		char[] complementado = new char[string.length * 2];
		
		for(int i = 0; i < string.length; i++)
		{
			complementado[i * 2] = string[i];
			complementado[i * 2 + 1] = complementoDeMin�scula(string[i]);
		}
		
		return complementado;
	}
	
//	G. Defina uma fun��o que dados o n�mero de linhas e o n�mero de colunas, devolva uma
//	matriz com essas dimens�es preenchida com letras min�sculas aleat�rias.
	
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
	
//	H. Defina uma fun��o que dada uma matriz de caracteres, devolva uma nova matriz com o
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
				complementar[i * 2 + 1][j] = complementoDeMin�scula(matrix[i][j]);
			}
		}
		
		return complementar;
	}
	
//	I. Resolva novamente o exerc�cio da al�nea H, mas sem assumir que todas as linhas t�m
//	o mesmo n�mero de elementos.
	
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
				complementar[i * 2 + 1][j] = complementoDeMin�scula(matrix[i][j]);
			}
		}
		
		return complementar;
	}
}